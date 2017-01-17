package com.example.jack_cheng.redux_demo.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by jack_cheng on 2017/1/10.
 */

public class Product {
    private String name;
    private List<Counter> counter;
    private boolean isSoldOut;

    public Product(String name, List<Counter> counter, boolean isSoldOut) {
        this.name = name;
        this.counter = counter;
        this.isSoldOut = isSoldOut;
    }


    public String getName() {
        return name;
    }

    public List<Counter> getCounter() {
        return counter;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }
}
