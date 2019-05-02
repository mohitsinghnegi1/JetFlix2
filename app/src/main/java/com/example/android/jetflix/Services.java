package com.example.android.jetflix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class Services extends AppCompatActivity {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);
    ViewFlipper f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        f1=(ViewFlipper) findViewById(R.id.flip1);
        Animation in= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out=AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        f1.setInAnimation(in);
        f1.setOutAnimation(out);
    }
    public void nextservice(View view)
    {
        view.startAnimation(buttonClick);
        f1.showNext();
    }
    public void prevservice(View view)
    {
        view.startAnimation(buttonClick);
        f1.showPrevious();
    }
}
