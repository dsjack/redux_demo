package com.example.jack_cheng.redux_demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack_cheng on 2017/1/10.
 */

public class Order {
    private List<Product> productList = new ArrayList<>();
    private Visibility visibility = Visibility.SHOW_ALL;

    public List<Product> getProductList() {
        return productList;
    }

    public Visibility getVisibility() {
        return visibility;
    }
}
