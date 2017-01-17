package com.example.jack_cheng.redux_demo.model.reducer;

import com.example.jack_cheng.redux_demo.model.Visibility;
import com.example.jack_cheng.redux_demo.model.actions.ChangeVisibilityAction;
import com.example.jack_cheng.redux_demo.redux.Action;
import com.example.jack_cheng.redux_demo.redux.Reducer;

/**
 * Created by jack_cheng on 2017/1/9.
 */

public class VisibilityReducer implements Reducer<Visibility, Action> {

    @Override
    public Visibility reduce(Visibility state, Action action) {
        switch (action.getType()){
            case ChangeVisibilityAction.TYPE:
                return filter(state, ((ChangeVisibilityAction)action).getVisibility());
        }
        return state;
    }

    private Visibility filter(Visibility state, Visibility filter) {
        return filter;
    }
}
