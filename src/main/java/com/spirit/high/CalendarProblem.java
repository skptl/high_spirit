package com.spirit.high;

import java.util.Calendar;

public class CalendarProblem {


    public static void main(String[] args) {
        int yearToCalculate = 1943;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, yearToCalculate);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        calendar.set(Calendar.WEEK_OF_MONTH, 2);
        System.out.println(calendar.get(Calendar.DATE));
    }
}
