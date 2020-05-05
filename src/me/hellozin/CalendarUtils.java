package me.hellozin;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class CalendarUtils {

    private final static int DAY_OF_WEEK_LENGTH = DayOfWeek.values().length;
    private final static DayOfWeek DEFAULT_START_DAY_OF_WEEK = DayOfWeek.SUNDAY;

    public static List<Week> weeksOf(int year, int month) {
        return weeksOf(DEFAULT_START_DAY_OF_WEEK, year, month);
    }

    public static List<Week> weeksOf(DayOfWeek startDayOfWeek, int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate lastDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        int prevDays = distanceOfStartWith(startDayOfWeek, startDate.getDayOfWeek());
        int lastDayOfPrevMonth = startDate.minusDays(1).getDayOfMonth();

        Week week = new Week();
        for (int i = 0; i < prevDays; i++) {
            week.add(lastDayOfPrevMonth - (prevDays - i - 1));
        }

        List<Week> weeks = new ArrayList<>();
        for (int day = 1; day <= lastDate.getDayOfMonth(); day++) {
            if (week.size() == DAY_OF_WEEK_LENGTH) {
                weeks.add(week);
                week = new Week();
            }
            week.add(day);
        }

        int firstDayOfNextMonth = lastDate.plusDays(1).getDayOfMonth();
        while (week.size() < DAY_OF_WEEK_LENGTH) {
            week.add(firstDayOfNextMonth);
            firstDayOfNextMonth += 1;
        }

        weeks.add(week);
        return weeks;
    }

    private static int distanceOfStartWith(DayOfWeek startDayOfWeek, DayOfWeek targetDayOfWeek) {
        int startValue = startDayOfWeek.getValue();
        int targetValue = targetDayOfWeek.getValue();

        return targetValue >= startValue
                ? targetValue - startValue
                : targetValue + (DAY_OF_WEEK_LENGTH - startValue);
    }

}
