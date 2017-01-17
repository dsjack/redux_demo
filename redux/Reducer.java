package com.example.jack_cheng.redux_demo.redux;

/**
 * Created by jack_cheng on 2017/1/6.
 */

public interface Reducer<T, F extends Action> {
    public T reduce(T state, F action);
}
