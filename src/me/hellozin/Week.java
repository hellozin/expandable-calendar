package me.hellozin;

import java.util.ArrayList;
import java.util.List;

public class Week {

    List<Integer> week;

    public Week() {
        this.week = new ArrayList<>();
    }

    public void add(Integer day) {
        this.week.add(day);
    }

    public int size() {
        return this.week.size();
    }

    public List<Integer> getWeek() {
        return week;
    }

    @Override
    public String toString() {
        return this.week.toString();
    }
}
