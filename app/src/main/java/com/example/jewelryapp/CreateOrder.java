package com.example.jewelryapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateOrder extends AppCompatActivity {
    private EditText Mark;
    private Resources Resources;
    private ArrayList<Order> Orders;
    private Spinner JewelType, Material, Stone;
    private CheckBox Mark1;
    private TextView Price;
    private Handler Hand = new Handler();

    private ArrayAdapter<String> Adapter, Add1, Add2;
    private String[] Option1, Option2, Option3;
    private int P1, P2;

    int TotalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_order);
        JewelType = (Spinner)findViewById(R.id.SpType);
        Material = (Spinner)findViewById(R.id.SpMaterial);
        Stone = (Spinner)findViewById(R.id.SpStone);
        Mark1 = (CheckBox)findViewById(R.id.ChMark);
        Mark = (EditText)findViewById(R.id.TxtMark);
        Price = (TextView)findViewById(R.id.TxtPrice);

        Resources = this.getResources();
        Orders = Data.Get();

        Option1 = this.getResources().getStringArray(R.array.jewelType);
        Option2 = this.getResources().getStringArray(R.array.materials);
        Option3 = this.getResources().getStringArray(R.array.stoles);

        Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Option1);
        Add1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Option2);
        Add2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Option3);

        JewelType.setAdapter(Adapter);
        Material.setAdapter(Add1);
        Stone.setAdapter(Add2);

        Hand.removeCallbacks(Actualizar);
        Hand.postDelayed(Actualizar,10);
    }

    private Runnable Actualizar = new Runnable() {
        @Override
        public void run() {
            Data.Actualizar(Mark1, Mark, JewelType, Material, Stone, P1, P2, Price,TotalPrice);
            Hand.postDelayed(this, 100);
        }
    };


    public void Save(View view){

        String ID, JewelTypeV, MaterialV, StoneV, MarkV, PriceV;
        ID = String.valueOf(Orders.size()+1);
        JewelTypeV = JewelType.getSelectedItem().toString();
        MaterialV = Material.getSelectedItem().toString();
        StoneV = Stone.getSelectedItem().toString();
        MarkV = Mark.getText().toString();
        PriceV = Price.getText().toString();

        if (Mark1.isChecked()){
            if (TextUtils.isEmpty(Mark.getText().toString())){
                Toast.makeText(this,R.string.MarkError, Toast.LENGTH_LONG).show();
            }else{
                Order O = new Order(ID,JewelTypeV,MaterialV,StoneV, PriceV);
                O.setMark(MarkV);
                O.getPrice();
                O.SaveOrder();
                Toast.makeText(this, R.string.Done, Toast.LENGTH_LONG).show();
            }
        } else{

            Order O = new Order(ID,JewelTypeV,MaterialV,StoneV, PriceV);
            O.SaveOrder();
            Toast.makeText(this, R.string.Done, Toast.LENGTH_LONG).show();
        }

    }


}

