package com.example.scrolltracker.ui.screens;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/scrolltracker/ui/screens/Screen;", "", "route", "", "<init>", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Dashboard", "AppUsage", "ScrollStats", "Settings", "Lcom/example/scrolltracker/ui/screens/Screen$AppUsage;", "Lcom/example/scrolltracker/ui/screens/Screen$Dashboard;", "Lcom/example/scrolltracker/ui/screens/Screen$ScrollStats;", "Lcom/example/scrolltracker/ui/screens/Screen$Settings;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/scrolltracker/ui/screens/Screen$AppUsage;", "Lcom/example/scrolltracker/ui/screens/Screen;", "<init>", "()V", "app_debug"})
    public static final class AppUsage extends com.example.scrolltracker.ui.screens.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.scrolltracker.ui.screens.Screen.AppUsage INSTANCE = null;
        
        private AppUsage() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/scrolltracker/ui/screens/Screen$Dashboard;", "Lcom/example/scrolltracker/ui/screens/Screen;", "<init>", "()V", "app_debug"})
    public static final class Dashboard extends com.example.scrolltracker.ui.screens.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.scrolltracker.ui.screens.Screen.Dashboard INSTANCE = null;
        
        private Dashboard() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/scrolltracker/ui/screens/Screen$ScrollStats;", "Lcom/example/scrolltracker/ui/screens/Screen;", "<init>", "()V", "app_debug"})
    public static final class ScrollStats extends com.example.scrolltracker.ui.screens.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.scrolltracker.ui.screens.Screen.ScrollStats INSTANCE = null;
        
        private ScrollStats() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/scrolltracker/ui/screens/Screen$Settings;", "Lcom/example/scrolltracker/ui/screens/Screen;", "<init>", "()V", "app_debug"})
    public static final class Settings extends com.example.scrolltracker.ui.screens.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.scrolltracker.ui.screens.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
}