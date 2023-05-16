package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class VacationPayCalculation {
    private static String holidays = " Jan 01 | Jan 02 | Jan 03 | Jan 04 | Jan 05 | Jan 06 | Jan 07 | Jan 08 | " +
            " Feb 23 | Mar 08 | May 01 | May 09 | Jun 12 | Now 04 ";
    public static String calculation(String vacationStartStr, String vacationEndStr, float salary ){
        int workingDays = 0;
        float value;

        Date vacationStart, vacationEnd;
        Calendar instance = Calendar.getInstance();

        try {
            vacationStart = new SimpleDateFormat("dd.MM.yyyy").parse(vacationStartStr);
            vacationEnd = new SimpleDateFormat("dd.MM.yyyy").parse(vacationEndStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        while (vacationStart.getTime() <= vacationEnd.getTime()) {
            if (!holidays.contains(vacationStart.toString().substring(5, 10)))
                workingDays++;
            instance.setTime(vacationStart);
            instance.add(Calendar.DAY_OF_MONTH, 1);
            vacationStart = instance.getTime();
        }

        value = salary / 29.3f * workingDays;
        return "Result: " + value;
    }
}
