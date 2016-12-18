package com.sunil.multiselectionrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.single_selection)
    public void singleSelectionClicked(){

        Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        intent.putExtra("TAG", "single");
        startActivity(intent);
    }

    @OnClick(R.id.max_selection)
    public void maxSelectionClicked(){
        Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        intent.putExtra("TAG", "max");
        startActivity(intent);
    }

    @OnClick(R.id.multi_selection)
    public void multiSelectionClicked(){
        Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        intent.putExtra("TAG", "multiple");
        startActivity(intent);
    }
}
