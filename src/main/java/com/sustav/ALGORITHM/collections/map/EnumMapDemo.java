package com.sustav.JAVA.collections.map;

import java.util.EnumMap;

public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<DayOfWeek, Integer> dayOfWeekIntegerEnumMap = new EnumMap<DayOfWeek, Integer>(DayOfWeek.class);
    }
}

enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
