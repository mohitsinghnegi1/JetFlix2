package com.example.android.jetflix;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchRoom extends AppCompatActivity {


    ListView lv_languages;
    LanguagesListAdapter list_adapter;
    ArrayList<String> house_name=new ArrayList<String>();
    ArrayList<String> email=new ArrayList<>();
    ArrayList<String> description=new ArrayList<>();
    ArrayList<Integer> rooms_available=new ArrayList<>();
    ArrayList<String> contact_no=new ArrayList<>();
    ArrayList<Double> price=new ArrayList<>();
    ArrayList<Double> size_sqfeet=new ArrayList<>();
    ArrayList<Integer> img=new ArrayList<>();

    public static Integer[] images={
            R.drawable.privateroom,
            R.drawable.privateroom,
            R.drawable.privateroom,
            R.drawable.privateroom,
            R.drawable.privateroom,
            R.drawable.privateroom,
            R.drawable.privateroom,
            R.drawable.privateroom,
            R.drawable.privateroom,

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_room);
        String[] name={"House1 ","House2 ","House3","House4","House5"};
        String[] email1={"mohit@gmail.com","mohit@gmail.com","mohit@gmail.com","mohit@gmail.com","mohit@gmail.com"};
        String[] desc={"A very comfortable air condionar room .","A very comfortable air condionar room .","A very comfortable air condionar room .","A very comfortable air condionar room .","A very comfortable air condionar room ."};
        Integer[] room_avail={2,3,4,5,6};
        String[] contact={"8194997428","8194997428","8194997428","8194997428","8194997428"};
        Double[] price1={20000.0,3000.0,4000.0,5000.0,6000.0};
        Double[] size1={100.0,200.0,100.0,150.0,300.0};

        house_name.addAll(Arrays.asList(name));
        email.addAll(Arrays.asList(email1));
        description.addAll(Arrays.asList(desc));
        rooms_available.addAll(Arrays.<Integer>asList(room_avail));
        contact_no.addAll(Arrays.asList(contact));
        price.addAll(Arrays.asList(price1));
        size_sqfeet.addAll(Arrays.asList(size1));
        img.addAll(Arrays.<Integer>asList(images)) ;
        init();
        lv_languages.setAdapter(list_adapter);



    }
    private void init() {



        list_adapter = new LanguagesListAdapter(SearchRoom.this,house_name, img,email,description,rooms_available,contact_no,price,size_sqfeet);
        lv_languages = (ListView) findViewById(R.id.lv_languages);
    }



}
