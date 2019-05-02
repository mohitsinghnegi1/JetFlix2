package com.example.android.jetflix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);
    SharedPreferences pref;
    EditText e1,e2,e3,e4,e5;
    SharedPreferences.Editor edit;

    String username,password,repassword,phoneno,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.password);
        e4=findViewById(R.id.repassword);
        e5=findViewById(R.id.phoneno);
    }

    public void register(View view)
    {
        view.startAnimation(buttonClick);
        //if(condition true){}else{}
        pref=getSharedPreferences("login",MODE_PRIVATE);
         username=e1.getText().toString().trim();
         email=e2.getText().toString().trim();
         password=e3.getText().toString().trim();
         repassword=e4.getText().toString().trim();
         phoneno=e5.getText().toString().trim();
        Log.d("username :", "register: "+username);

        if((!username.equals("")) && (!email.equals("")) && (!password.equals("")) && (!repassword.equals("")) && (!phoneno.equals("")) ) {

            if(phoneno.length()==10) {

                if(password.equals(repassword)) {

                    edit=pref.edit();
                    edit.putString("username", username);
                    edit.putString("email", email);
                    edit.putString("password", password);
                    edit.putString("repassword", repassword);
                    edit.putString("phoneno", phoneno);
                    edit.apply();
                    Toast.makeText(getApplicationContext(),"Successful Registered",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), login.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Confirm password incorrect",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Enter valid Phone no",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please fill Out the missing fields",Toast.LENGTH_LONG).show();
        }

    }
    public boolean check_Phone_no(String phoneno){
        if(phoneno.length()!=10){
            return false;
        }
        else{
            return true;
        }


    };

}
