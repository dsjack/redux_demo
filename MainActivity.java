package com.example.jack_cheng.redux_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jack_cheng.redux_demo.model.Order;
import com.example.jack_cheng.redux_demo.model.Product;
import com.example.jack_cheng.redux_demo.model.Visibility;
import com.example.jack_cheng.redux_demo.model.actions.ActionCreator;
import com.example.jack_cheng.redux_demo.model.dto.FakeDataDTO;
import com.example.jack_cheng.redux_demo.model.reducer.CounterStore;
import com.example.jack_cheng.redux_demo.model.reducer.ProductReducer;
import com.example.jack_cheng.redux_demo.model.reducer.VisibilityReducer;
import com.example.jack_cheng.redux_demo.redux.Observer;
import com.example.jack_cheng.redux_demo.redux.Reducer;
import com.example.jack_cheng.redux_demo.redux.Redux;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Observer {

    private CounterStore counterStore;
    private CounterAdapter adapter;
    private ActionCreator actionCreator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionCreator = new ActionCreator();
        initRedux();
        createFakeData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.counter_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CounterAdapter(counterStore);
        adapter.setCounterListData(counterStore.getState().getProductList());
        recyclerView.setAdapter(adapter);
    }

    private void initRedux() {
        String[] keys = new String[]{"productList", "visibility"};
        Reducer[] reducers = new Reducer[]{new ProductReducer(), new VisibilityReducer()};
        Reducer combineReducer = Redux.combineReducers(Order.class, keys, reducers);
        counterStore = Redux.createStore(CounterStore.class, combineReducer);
    }

    private void createFakeData() {

        List<FakeDataDTO> dtoList = new ArrayList<>();
        FakeDataDTO dto = new FakeDataDTO();
        dto.setProductName("第一個商品");
        dto.setSoldOut(false);
        List<String> colorList = new ArrayList<>();
        colorList.add("黑");
        colorList.add("白");
        colorList.add("紅");
        dto.setColorName(colorList);

        FakeDataDTO dto2 = new FakeDataDTO();
        dto2.setProductName("第二個商品");
        dto2.setSoldOut(false);
        List<String> colorList2 = new ArrayList<>();
        colorList2.add("黑");
        colorList2.add("白");
        dto2.setColorName(colorList2);

        FakeDataDTO dto3 = new FakeDataDTO();
        dto3.setProductName("第三個商品");
        dto3.setSoldOut(true);
        List<String> colorList3 = new ArrayList<>();
        colorList3.add("藍");
        colorList3.add("白");
        colorList3.add("紅");
        dto3.setColorName(colorList3);

        dtoList.add(dto);
        dtoList.add(dto2);
        dtoList.add(dto3);

        for (int i = 0; i < dtoList.size(); i++) {
            counterStore.dispatch(actionCreator.initProductData(dtoList.get(i), i));
        }

    }


    @Override
    public void update() {
        List<Product> productList = counterStore.getState().getProductList();
        List<Product> filterProductList = new ArrayList<>();
        switch (counterStore.getState().getVisibility()) {
            case SHOW_ON_SALE:
                for (Product p : productList) {
                    if (!p.isSoldOut()) {
                        filterProductList.add(p);
                    }
                }
                break;
            case SHOW_SOLD_OUT:
                for (Product p : productList) {
                    if (p.isSoldOut()) {
                        filterProductList.add(p);
                    }
                }
                break;
            case SHOW_ALL:
            default:
                filterProductList = productList;
                break;
        }

        adapter.setCounterListData(filterProductList);
    }

    @Override
    protected void onStop() {
        super.onStop();
        counterStore.unSubscribe(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        counterStore.subscribe(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.show_all:
                counterStore.dispatch(actionCreator.ChangeFilter(Visibility.SHOW_ALL));
                break;
            case R.id.action_on_sale:
                counterStore.dispatch(actionCreator.ChangeFilter(Visibility.SHOW_ON_SALE));
                break;
            case R.id.action_sold_out:
                counterStore.dispatch(actionCreator.ChangeFilter(Visibility.SHOW_SOLD_OUT));
                break;
        }

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }


}
