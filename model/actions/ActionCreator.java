package com.example.jack_cheng.redux_demo.model.actions;

import com.example.jack_cheng.redux_demo.model.Counter;
import com.example.jack_cheng.redux_demo.model.Visibility;
import com.example.jack_cheng.redux_demo.model.dto.FakeDataDTO;
import com.example.jack_cheng.redux_demo.redux.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack_cheng on 2017/1/10.
 * <p>
 * 可以在此處處理API先程序 再回傳Action
 */

public class ActionCreator {

    public Action initProductData(FakeDataDTO dto ,int position) {
        List<Counter> counterList = new ArrayList<>();

        for (int j = 0; j < dto.getColorName().size(); j++) {
            counterList.add(new Counter(dto.getColorName().get(j), position, 0));
        }
        return addProduct(dto.getProductName(), counterList , dto.isSoldOut());
    }

    public Action addCounterNumber(int position, int target) {
        return new AddAction(position, target);
    }

    public Action reduceCounterNumber(int position, int target) {
        return new ReduceAction(position, target);
    }


    public Action addProduct(String porductName, List<Counter> isSoldout, boolean soldOut) {
        return new AddProductAction(porductName, isSoldout, soldOut);
    }

    public Action ChangeFilter(Visibility filter){
        return  new ChangeVisibilityAction(filter);
    }

}
