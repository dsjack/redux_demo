package com.example.jack_cheng.redux_demo.model.actions;

import com.example.jack_cheng.redux_demo.redux.Action;

/**
 * Created by jack_cheng on 2017/1/9.
 */

public class AddAction implements Action {
    public static final String TYPE = "Add";
    private String tag;
    private int index;

    public AddAction(String tag, int index) {
        this.tag = tag;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
