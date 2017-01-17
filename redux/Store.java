package com.example.jack_cheng.redux_demo.redux;

/**
 * Created by jack_cheng on 2017/1/6.
 */

public interface Store<T> {
    public T getState();
    public void dispatch(Action action);
    public void subscribe(Observer observer);
    public void unSubscribe(Observer observer);
}
