package com.example.scrolltracker;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140#J(\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010,\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/example/scrolltracker/ScrollBehaviorChartView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linePaint", "Landroid/graphics/Paint;", "dotPaint", "dotStrokePaint", "gridPaint", "textPaint", "tooltipPaint", "tooltipTextPaint", "dataPoints", "", "Lcom/example/scrolltracker/ScrollDataPoint;", "animationProgress", "", "selectedPointIndex", "gestureDetector", "Landroid/view/GestureDetector;", "padding", "topPadding", "bottomPadding", "chartWidth", "chartHeight", "startAnimation", "", "updateData", "newData", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawGrid", "drawAxes", "drawChart", "drawLabels", "drawTooltip", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "ChartGestureListener", "app_debug"})
public final class ScrollBehaviorChartView extends android.view.View {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint linePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint dotPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint dotStrokePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint gridPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint textPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint tooltipPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint tooltipTextPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.scrolltracker.ScrollDataPoint> dataPoints = null;
    private float animationProgress = 0.0F;
    private int selectedPointIndex = -1;
    @org.jetbrains.annotations.NotNull()
    private final android.view.GestureDetector gestureDetector = null;
    private final float padding = 80.0F;
    private final float topPadding = 100.0F;
    private final float bottomPadding = 120.0F;
    private float chartWidth = 0.0F;
    private float chartHeight = 0.0F;
    
    @kotlin.jvm.JvmOverloads()
    public ScrollBehaviorChartView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public ScrollBehaviorChartView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public ScrollBehaviorChartView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    private final void startAnimation() {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.scrolltracker.ScrollDataPoint> newData) {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    private final void drawGrid(android.graphics.Canvas canvas) {
    }
    
    private final void drawAxes(android.graphics.Canvas canvas) {
    }
    
    private final void drawChart(android.graphics.Canvas canvas) {
    }
    
    private final void drawLabels(android.graphics.Canvas canvas) {
    }
    
    private final void drawTooltip(android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/example/scrolltracker/ScrollBehaviorChartView$ChartGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/example/scrolltracker/ScrollBehaviorChartView;)V", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_debug"})
    final class ChartGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        
        public ChartGestureListener() {
            super();
        }
        
        @java.lang.Override()
        public boolean onSingleTapUp(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e) {
            return false;
        }
    }
}