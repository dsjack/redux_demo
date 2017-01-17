package com.example.jack_cheng.redux_demo.model.reducer;

import com.example.jack_cheng.redux_demo.model.Order;
import com.example.jack_cheng.redux_demo.redux.Action;
import com.example.jack_cheng.redux_demo.redux.Observer;
import com.example.jack_cheng.redux_demo.redux.Reducer;
import com.example.jack_cheng.redux_demo.redux.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack_cheng on 2017/1/6.
 */

public class CounterStore implements Store<Order> {
    private List<Observer> observerList = new ArrayList<>();

    private Order order = new Order();
    private Reducer reducer;

    public CounterStore(Reducer reducer) {
        this.reducer = reducer;
    }

    @Override
    public Order getState() {
        return order;
    }

    @Override
    public void dispatch(Action action) {
        order = (Order) reducer.reduce(order, action);
        notifyChangeSubscriber();
    }

    @Override
    public void subscribe(Observer observer) {
        if (observer != null) {
            observerList.add(observer);
        }
    }

    @Override
    public void unSubscribe(Observer observer) {
        if (observer != null) {
            observerList.remove(observer);
        }
    }

    private void notifyChangeSubscriber() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
