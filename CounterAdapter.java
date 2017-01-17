package com.example.jack_cheng.redux_demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jack_cheng.redux_demo.model.Counter;
import com.example.jack_cheng.redux_demo.model.Product;
import com.example.jack_cheng.redux_demo.model.actions.ActionCreator;
import com.example.jack_cheng.redux_demo.model.reducer.CounterStore;

import java.util.List;

/**
 * Created by jack_cheng on 2017/1/6.
 */

public class CounterAdapter extends RecyclerView.Adapter<CounterAdapter.Content_Holder> {

    private List<Product> products;
    private CounterStore store;
    private ActionCreator actionCreator;

    public CounterAdapter(CounterStore counterList) {
        this.store = counterList;
    }

    public void setCounterListData(List<Product> order) {
        this.products = order;
        actionCreator = new ActionCreator();
        notifyDataSetChanged();
    }

    @Override
    public Content_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_content, parent, false);
        return new Content_Holder(v);
    }

    @Override
    public void onBindViewHolder(Content_Holder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        if (products == null) {
            return 0;
        } else {
            return products.size();
        }
    }


    public class Content_Holder extends RecyclerView.ViewHolder {

        private LinearLayout llv_counterArea;
        private TextView txt_productName;

        public Content_Holder(View itemView) {
            super(itemView);

            llv_counterArea = (LinearLayout) itemView.findViewById(R.id.llv_counter_area);
            txt_productName = (TextView) itemView.findViewById(R.id.txt_product_name);
        }

        private void bindView(final int position) {
            txt_productName.setText(products.get(position).getName());


            llv_counterArea.removeAllViews();
            for (int i = 0; i < products.get(position).getCounter().size(); i++) {
                final View counterView = LayoutInflater.from(itemView.getContext()).inflate(R.layout.counter_layout, null, false);
                counterView.setId(i);
                TextView counterName = (TextView) counterView.findViewById(R.id.txt_counter_name);
                TextView counterNumber = (TextView) counterView.findViewById(R.id.txt_counter_count);
                Button btn_add = (Button) counterView.findViewById(R.id.btn_counter_add);
                Button btn_reduce = (Button) counterView.findViewById(R.id.btn_counter_reduce);

                Counter counterData = products.get(position).getCounter().get(i);

                counterName.setText(counterData.getTitle());
                counterNumber.setText(String.valueOf(counterData.getCounterNumber()));

                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        store.dispatch(actionCreator.addCounterNumber(position, counterView.getId()));
                    }
                });


                btn_reduce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        store.dispatch(actionCreator.reduceCounterNumber(position, counterView.getId()));
                    }
                });

                llv_counterArea.addView(counterView);
            }
        }
    }
}
