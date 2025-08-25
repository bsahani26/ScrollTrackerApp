package com.example.scrolltracker.service;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\'\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002J\u0016\u0010)\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010%J\u000e\u0010*\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/example/scrolltracker/service/ScrollMonitoringService;", "Landroid/accessibilityservice/AccessibilityService;", "<init>", "()V", "repository", "Lcom/example/scrolltracker/data/repo/ScrollRepository;", "getRepository", "()Lcom/example/scrolltracker/data/repo/ScrollRepository;", "setRepository", "(Lcom/example/scrolltracker/data/repo/ScrollRepository;)V", "packageManager", "Landroid/content/pm/PackageManager;", "getPackageManager", "()Landroid/content/pm/PackageManager;", "setPackageManager", "(Landroid/content/pm/PackageManager;)V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "activeSessions", "", "", "Lcom/example/scrolltracker/data/entity/AppUsageSession;", "pixelToMeterRatio", "", "onCreate", "", "onServiceConnected", "onAccessibilityEvent", "event", "Landroid/view/accessibility/AccessibilityEvent;", "handleScrollEvent", "handleWindowStateChanged", "handleAppForeground", "packageName", "appName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateScrollDistance", "calculateScrollDirection", "getOrCreateSessionId", "updateSessionScrollCount", "loadActiveSessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startForegroundService", "onInterrupt", "onDestroy", "app_debug"})
public final class ScrollMonitoringService extends android.accessibilityservice.AccessibilityService {
    @javax.inject.Inject()
    public com.example.scrolltracker.data.repo.ScrollRepository repository;
    @javax.inject.Inject()
    public android.content.pm.PackageManager packageManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, com.example.scrolltracker.data.entity.AppUsageSession> activeSessions = null;
    private final float pixelToMeterRatio = 2.645833E-4F;
    
    public ScrollMonitoringService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.scrolltracker.data.repo.ScrollRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.example.scrolltracker.data.repo.ScrollRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.pm.PackageManager getPackageManager() {
        return null;
    }
    
    public final void setPackageManager(@org.jetbrains.annotations.NotNull()
    android.content.pm.PackageManager p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    protected void onServiceConnected() {
    }
    
    @java.lang.Override()
    public void onAccessibilityEvent(@org.jetbrains.annotations.Nullable()
    android.view.accessibility.AccessibilityEvent event) {
    }
    
    private final void handleScrollEvent(android.view.accessibility.AccessibilityEvent event) {
    }
    
    private final void handleWindowStateChanged(android.view.accessibility.AccessibilityEvent event) {
    }
    
    private final java.lang.Object handleAppForeground(java.lang.String packageName, java.lang.String appName, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object getAppName(java.lang.String packageName, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final float calculateScrollDistance(android.view.accessibility.AccessibilityEvent event) {
        return 0.0F;
    }
    
    private final java.lang.String calculateScrollDirection(android.view.accessibility.AccessibilityEvent event) {
        return null;
    }
    
    private final java.lang.String getOrCreateSessionId(java.lang.String packageName) {
        return null;
    }
    
    private final java.lang.Object updateSessionScrollCount(java.lang.String packageName, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadActiveSessions(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void startForegroundService() {
    }
    
    @java.lang.Override()
    public void onInterrupt() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}