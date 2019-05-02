package com.example.android.jetflix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
    }



    public void Cancel1(View view) {
        Intent intent=new Intent(this,AddSearchHotel.class);
        startActivity(intent);
    }

    public void Add_Room(View view) {
        Toast.makeText(getApplicationContext(),"Room Added Successfully",Toast.LENGTH_SHORT).show();
    }
}
