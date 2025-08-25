# ScrollTrackerSample

A minimal sample that uses an AccessibilityService to monitor scroll metrics (speed, distance, duration) across apps, stores them in Room, exposes them via an MVVM+Hilt stack, and visualizes the last 7 days with a Vico bar chart (XML view).

## How to run
1. Open the project in Android Studio (Giraffe or newer recommended).
2. Sync Gradle.
3. Run the app on a device with Android 9 (API 28) or newer.
4. In the app, tap "Open Accessibility Settings" and enable **ScrollTrackerSample** under "Downloaded apps".
5. Start scrolling in any app. Metrics will update when you return.

## Notes
- Min SDK 28 to use `AccessibilityRecord.getScrollDeltaY()` (per Android API 28+).
- Speed is approximated as `abs(deltaY) / elapsedSeconds` between consecutive scroll events.
- "Active duration" sums elapsed time between consecutive scroll events with a max gap of 500 ms treated as continuous.
