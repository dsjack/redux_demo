package com.example.jack_cheng.redux_demo.model;

/**
 * Created by jack_cheng on 2017/1/6.
 */

public class Counter {
    private String title = "no title";
    private int position;
    private int counterNumber;

    public Counter(String title, int position, int counter) {
        this.title = title;
        this.position = position;
        this.counterNumber = counter;
    }

    public int getCounterNumber() {
        return counterNumber;
    }

    public String getTitle() {
        return title;
    }
}
