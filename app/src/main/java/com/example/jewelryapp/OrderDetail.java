package com.example.jewelryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderDetail extends AppCompatActivity {

    private Intent In;
    private ArrayList<Order> Orders;
    private TextView TxtOrderType, TxtPrice, TxtMaterial, TxtStone, TxtMark, Txt;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);

        In = getIntent();
        Orders = Data.Get();

        int Position = In.getIntExtra("position", 0);

        TxtOrderType = (TextView)findViewById(R.id.TxtOrderType);
        TxtPrice = (TextView)findViewById(R.id.TxtPrice);
        TxtMaterial = (TextView) findViewById(R.id.TxtMaterial);
        TxtStone = (TextView)findViewById(R.id.TxtStone);
        TxtMark = (TextView)findViewById(R.id.TxtMArk);
        Txt = (TextView)findViewById(R.id.Text1);

        loadData(Orders.get(Position));

    }

    private void loadData(Order Order){
        TxtOrderType.setText(Order.getJewelType());
        TxtPrice.setText(Order.getPrice());
        TxtMaterial.setText(Order.getMaterial());
        TxtStone.setText(Order.getStone());
        TxtMark.setText(Order.getMark());

        if (TextUtils.isEmpty(Order.getMark())){
            Txt.setVisibility(View.INVISIBLE);
            TxtMark.setVisibility(View.INVISIBLE);
        }else{
            Txt.setVisibility(View.VISIBLE);
            TxtMark.setVisibility(View.VISIBLE);
        }

    }
}
