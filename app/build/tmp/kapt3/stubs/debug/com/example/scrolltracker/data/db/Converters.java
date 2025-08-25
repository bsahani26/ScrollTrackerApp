package com.example.scrolltracker.data.db;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/scrolltracker/data/db/Converters;", "", "<init>", "()V", "fromTimestamp", "Ljava/util/Date;", "value", "", "dateToTimestamp", "date", "app_debug"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date fromTimestamp(long value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    public final long dateToTimestamp(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        return 0L;
    }
}