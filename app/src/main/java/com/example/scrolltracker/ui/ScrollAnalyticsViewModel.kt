package com.example.scrolltracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scrolltracker.data.repo.ScrollRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScrollAnalyticsViewModel @Inject constructor(
    private val repository: ScrollRepository
) : ViewModel() {

    private val _selectedTimeRange = MutableStateFlow(TimeRange.HOURS_24)
    val selectedTimeRange = _selectedTimeRange.asStateFlow()

    private val _totalScrollMeters = MutableStateFlow(0f)
    val totalScrollMeters = _totalScrollMeters.asStateFlow()

    private val _wakeCountState = MutableStateFlow(0)
    val wakeCountState = _wakeCountState.asStateFlow()

    val scrollStats = selectedTimeRange.flatMapLatest { timeRange ->
        val (startTime, endTime) = getTimeRangeMillis(timeRange)
        repository.getScrollStatsByTime(startTime, endTime, timeRange.isHourly)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val appScrollStats = selectedTimeRange.flatMapLatest { timeRange ->
        val (startTime, endTime) = getTimeRangeMillis(timeRange)
        repository.getAppScrollStats(startTime, endTime)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val appUsageStats = selectedTimeRange.flatMapLatest { timeRange ->
//        val (startTime, endTime) = getTimeRangeMillis(timeRange)
        repository.getAppUsageStats()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val wakeCount = wakeCountState.flatMapLatest {
        repository.getWakeCount()
    }.stateIn(
        scope = viewModelScope, started = SharingStarted.WhileSubscribed(5000), initialValue = 0
    )

    val hourlyUsageStats = selectedTimeRange.flatMapLatest { timeRange ->
        val (startTime, endTime) = getTimeRangeMillis(timeRange)
        repository.getHourlyUsageStats(startTime, endTime)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    init {
        loadTotalScrollMeters()
    }

    fun setTimeRange(timeRange: TimeRange) {
        _selectedTimeRange.value = timeRange
    }

    private fun loadTotalScrollMeters() {
        viewModelScope.launch {
            _totalScrollMeters.value = repository.getTotalScrollMeters()

        }
    }

    fun refresh() {
        loadTotalScrollMeters()
    }

    fun clearAllData() {
        viewModelScope.launch {
            repository.clearAllData()
        }
    }

    private fun getTimeRangeMillis(timeRange: TimeRange): Pair<Long, Long> {
        val now = System.currentTimeMillis()
        return when (timeRange) {
            TimeRange.HOURS_6 -> Pair(now - 6 * 60 * 60 * 1000L, now)
            TimeRange.HOURS_12 -> Pair(now - 12 * 60 * 60 * 1000L, now)
            TimeRange.HOURS_24 -> Pair(now - 24 * 60 * 60 * 1000L, now)
            TimeRange.DAYS_3 -> Pair(now - 3 * 24 * 60 * 60 * 1000L, now)
            TimeRange.DAYS_7 -> Pair(now - 7 * 24 * 60 * 60 * 1000L, now)
            TimeRange.DAYS_30 -> Pair(now - 30 * 24 * 60 * 60 * 1000L, now)
        }
    }
}

enum class TimeRange(val displayName: String, val isHourly: Boolean) {
    HOURS_6("6 Hours", true), HOURS_12("12 Hours", true), HOURS_24(
        "24 Hours", true
    ),
    DAYS_3("3 Days", false), DAYS_7("7 Days", false), DAYS_30("30 Days", false)
}