package com.example.android.jetflix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddSearchHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_search_hotel);

    }

    public void searchData(View view) {

        Intent intent=new Intent(this,SearchRoom.class);
        startActivity(intent);


    }

    public void addRoom(View view) {

    Intent intent=new Intent(this,AddRoom.class);
    startActivity(intent);

    }

    public void ourService(View view) {
        Intent intent=new Intent(this,Services.class);
        startActivity(intent);
        Toast.makeText(this,"activity",Toast.LENGTH_SHORT).show();
    }
}
