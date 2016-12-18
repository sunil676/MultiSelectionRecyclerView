package com.sunil.multiselectionrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.sunil.multiselectionrecyclerview.adapters.MultiMaxSelectionAdapter;
import com.sunil.multiselectionrecyclerview.adapters.MultiSelectionAdapter;
import com.sunil.multiselectionrecyclerview.adapters.SingleSelectionAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sunil on 12/17/16.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.selected)
    Button selected;

    private String tag;
    String names[] = Constant.name;

    SingleSelectionAdapter adapterSingle;
    MultiMaxSelectionAdapter adapterMultiMax;
    MultiSelectionAdapter adapterMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tag = bundle.getString("TAG");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List<ItemModel> list = getList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (tag.equalsIgnoreCase("Single")) {
            adapterSingle = new SingleSelectionAdapter(this, list);
            mRecyclerView.setAdapter(adapterSingle);
        } else if (tag.equalsIgnoreCase("max")) {
            adapterMultiMax = new MultiMaxSelectionAdapter(this, list);
            mRecyclerView.setAdapter(adapterMultiMax);
        } else if (tag.equalsIgnoreCase("multiple")) {
            adapterMulti = new MultiSelectionAdapter(this, list);
            mRecyclerView.setAdapter(adapterMulti);
        }
    }

    private List<ItemModel> getList() {
        List<ItemModel> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            ItemModel model = new ItemModel();
            model.setName(names[i]);
            model.setId(i);
            list.add(model);
        }
        return list;
    }

    @OnClick(R.id.selected)
    public void selectedClick() {
        if (tag.equalsIgnoreCase("Single")) {
            if (adapterSingle.selectedPosition() != -1) {
                ItemModel itemModel = adapterSingle.getSelectedItem();
                String cityName = itemModel.getName();
                showToast("Selected City is: " + cityName);
            } else {
                showToast("Please select any city");
            }
        }else if (tag.equalsIgnoreCase("max")){
            List<ItemModel> list = adapterMultiMax.getSelectedItem();
            if (list.size() > 0){
                StringBuilder sb = new StringBuilder();
                for (int index = 0; index < list.size(); index++){
                    ItemModel model = list.get(index);
                    sb.append(model.getName()+"\n");
                }
                showToast(sb.toString());
            }else{
                showToast("Please select any city");
            }
        }
        else if (tag.equalsIgnoreCase("multiple")){
            List<ItemModel> list = adapterMulti.getSelectedItem();
            if (list.size() > 0){
                StringBuilder sb = new StringBuilder();
                for (int index = 0; index < list.size(); index++){
                    ItemModel model = list.get(index);
                    sb.append(model.getName()+"\n");
                }
                showToast(sb.toString());
            }else{
                showToast("Please select any city");
            }
        }
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}