package com.example.android.jetflix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SharedPreferences pref;
    EditText e1,e2,e3;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.password);
    }
    public void landingpage(View view)
    {
        //if(condition true){}else{toast}
        view.startAnimation(buttonClick);
        pref=getSharedPreferences("login",MODE_PRIVATE);
        String username=e1.getText().toString().trim();
        String email=e2.getText().toString().trim();
        String password=e3.getText().toString().trim();

        String chkusername=pref.getString("username","");
        String chkemail=pref.getString("email","");
        String chkpassword=pref.getString("password","");



        if(chkusername.equals(username)&& chkpassword.equals(password )&& chkemail.equals(email)) {

            Toast.makeText(getApplicationContext(),"successfully login",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), AddSearchHotel.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"mismatch username password email",Toast.LENGTH_LONG).show();
        }

    }

    public void gotosignup(View view)
    {view.startAnimation(buttonClick);
        Intent intent=new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);

    }



}
