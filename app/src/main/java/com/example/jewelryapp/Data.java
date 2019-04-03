package com.example.jewelryapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Data {




    private static ArrayList<Order> Orders = new ArrayList<>();
    public static void Save(Order O){
        Orders.add(O);
    }
    public static ArrayList<Order> Get(){
        return Orders;
    }
    public static void Actualizar(CheckBox Mark1, EditText Mark, Spinner JewelType, Spinner Material, Spinner Stone, int P1, int P2, TextView Price, int TotalPrice){
        int ruby = 190000;
        int esmeralda = 180000;
        int quarzo = 150000;

        if (Mark1.isChecked()){
            Mark.setVisibility(View.VISIBLE);
        }else{
            Mark.setVisibility(View.INVISIBLE);
        }
        switch (JewelType.getSelectedItemPosition()){

            case 0:
                switch (Material.getSelectedItemPosition()){
                    case 0:
                        P1 = 100000;
                        break;
                    case 1:
                        P1 = 50000;
                        break;
                    case 2:
                        P1 = 150000;
                        break;
                }
                switch (Stone.getSelectedItemPosition()){
                    case 0:
                        P2 = ruby;
                        break;
                    case 1:
                        P2 = esmeralda;
                        break;
                    case 2:
                        P2 = quarzo;
                        break;
                }
                break;
            case 1:
                switch (Material.getSelectedItemPosition()){
                    case 0:
                        P1 = 50000;
                        break;
                    case 1:
                        P1 = 30000;
                        break;
                    case 2:
                        P1 = 90000;
                        break;
                }
                switch (Stone.getSelectedItemPosition()){
                    case 0:
                        P2 = ruby;
                        break;
                    case 1:
                        P2 = esmeralda;
                        break;
                    case 2:
                        P2 = quarzo;
                        break;
                }
                break;
        }
        TotalPrice = P1 + P2;
        Price.setText(String.valueOf(TotalPrice/1000)+"mil");
    }
}