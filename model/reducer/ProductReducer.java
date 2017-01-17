package com.example.jack_cheng.redux_demo.model.reducer;

import com.example.jack_cheng.redux_demo.model.Counter;
import com.example.jack_cheng.redux_demo.model.Product;
import com.example.jack_cheng.redux_demo.model.actions.AddAction;
import com.example.jack_cheng.redux_demo.model.actions.AddProductAction;
import com.example.jack_cheng.redux_demo.model.actions.ReduceAction;
import com.example.jack_cheng.redux_demo.redux.Action;
import com.example.jack_cheng.redux_demo.redux.Reducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack_cheng on 2017/1/10.
 */

public class ProductReducer implements Reducer<List<Product>, Action> {
    @Override
    public List<Product> reduce(List<Product> state, Action action) {
        List<Product> newProductList = new ArrayList<>();
        List<Counter> newCounterList = new ArrayList<>();

        switch (action.getType()) {
            case AddProductAction.TYPE:
                String productName = ((AddProductAction) action).getProductName();
                List<Counter> counterList = ((AddProductAction) action).getCounterList();
                boolean isSoldout = ((AddProductAction)action).isSoldout();

                Product newProduct = new Product(productName, counterList, isSoldout);

                newProductList.addAll(state);
                newProductList.add(newProduct);

                return newProductList;

            case AddAction.TYPE:
                int addTarget = ((AddAction) action).getIndex();
                int addPosition = ((AddAction) action).getPosition();

                for (int i = 0; i < state.size(); i++) {
                    if (addPosition == i) {
                        Product product = state.get(i);
                        for (int j = 0; j < product.getCounter().size(); j++) {
                            if (addTarget == j) {
                                newCounterList.add(new Counter(
                                        product.getCounter().get(j).getTitle(),
                                        i,
                                        product.getCounter().get(j).getCounterNumber() + 1));
                            } else {
                                newCounterList.add(product.getCounter().get(j));
                            }
                        }
                        newProductList.add(new Product(state.get(i).getName(),newCounterList,state.get(i).isSoldOut()));
                    } else {
                        newProductList.add(new Product(state.get(i).getName(), state.get(i).getCounter(),state.get(i).isSoldOut()));
                    }
                }

                return newProductList;

            case ReduceAction.TYPE:
                int reduceTarget = ((ReduceAction) action).getIndex();
                int reducePosition = ((ReduceAction) action).getPosotion();

                for (int i = 0; i < state.size(); i++) {
                    if (reducePosition == i) {
                        Product product = state.get(i);
                        for (int j = 0; j < product.getCounter().size(); j++) {
                            if (reduceTarget == j) {
                                newCounterList.add(new Counter(
                                        product.getCounter().get(j).getTitle(),
                                        i,
                                        product.getCounter().get(j).getCounterNumber() - 1));
                            } else {
                                newCounterList.add(product.getCounter().get(j));
                            }
                        }
                        newProductList.add(new Product(state.get(i).getName(),newCounterList,state.get(i).isSoldOut()));
                    } else {
                        newProductList.add(new Product(state.get(i).getName(), state.get(i).getCounter(),state.get(i).isSoldOut()));
                    }
                }

                return newProductList;
        }

        return state;
    }
}
