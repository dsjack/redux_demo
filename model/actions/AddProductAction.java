package com.example.jack_cheng.redux_demo.model.actions;

import com.example.jack_cheng.redux_demo.model.Counter;
import com.example.jack_cheng.redux_demo.redux.Action;

import java.util.List;

/**
 * Created by jack_cheng on 2017/1/10.
 */

public class AddProductAction implements Action {
    public static final String TYPE = "Add_Product";
    private String productName;
    private List<Counter> counterList;
    private boolean isSoldout;

    public AddProductAction(String productName, List<Counter> counterList ,boolean isSoldout) {
        this.productName = productName;
        this.counterList = counterList;
        this.isSoldout = isSoldout;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Counter> getCounterList() {
        return counterList;
    }

    public void setCounterList(List<Counter> counterList) {
        this.counterList = counterList;
    }

    public boolean isSoldout() {
        return isSoldout;
    }

    public void setSoldout(boolean soldout) {
        isSoldout = soldout;
    }
}
