package com.example.jack_cheng.redux_demo.model.actions;

import com.example.jack_cheng.redux_demo.model.Visibility;
import com.example.jack_cheng.redux_demo.redux.Action;

/**
 * Created by jack_cheng on 2017/1/12.
 */

public class ChangeVisibilityAction implements Action {
    public static final String TYPE = "change_visibility";

    private Visibility visibility;

    public ChangeVisibilityAction(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
}
