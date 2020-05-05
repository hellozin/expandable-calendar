package me.hellozin;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Week> weeks = CalendarUtils.weeksOf(2020, 05);
        System.out.println(weeks);
    }
}
