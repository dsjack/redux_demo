package com.example.jack_cheng.redux_demo.model.actions;

import com.example.jack_cheng.redux_demo.redux.Action;

/**
 * Created by jack_cheng on 2017/1/9.
 */

public class ReduceAction implements Action {
    public static final String TYPE = "Reduce";
    private int posotion;
    private int index;

    public ReduceAction(int posotion, int index) {
        this.posotion = posotion;
        this.index = index;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPosotion() {
        return posotion;
    }

    public void setPosotion(int posotion) {
        this.posotion = posotion;
    }
}
