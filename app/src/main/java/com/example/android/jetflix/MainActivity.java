package com.example.android.jetflix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    LinearLayout mdotLayout;
    SliderAdapter sliderAdapter;
    private TextView[] mDots;
    Button prevBtn,nextBtn;
    int mDotsCount=3;
    int currentPage=0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.pager);
        mdotLayout=findViewById(R.id.dot_layout);
        prevBtn=findViewById(R.id.prev);
        nextBtn=findViewById(R.id.next);

        sliderAdapter =new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDotIndecator();
        viewPager.addOnPageChangeListener(viewListener);
    }
    public void addDotIndecator(){
        mDots=new TextView[mDotsCount];
        for(int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextColor(Color.GRAY);
            mDots[i].setTextSize(35);
            mdotLayout.addView(mDots[i]);
            prevBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(currentPage-1);
                }
            });
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(nextBtn.getText().toString()=="FINISH"){
                        Toast.makeText(MainActivity.this, "last page", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this,login.class);
                        startActivity(intent);
                    }
                    viewPager.setCurrentItem(currentPage+1);
                }
            });

        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            mDots[i].setTextSize(50);
            mDots[i].setTextColor(Color.WHITE);
            currentPage=i;
            if(currentPage==0){
                nextBtn.setEnabled(true);
                prevBtn.setEnabled(false);
                prevBtn.setVisibility(View.INVISIBLE);
                nextBtn.setText("NEXT");
                prevBtn.setText("");
            }
            else if(i==mDots.length-1){
                nextBtn.setEnabled(true);
                prevBtn.setEnabled(true);
                prevBtn.setVisibility(View.VISIBLE);
                nextBtn.setText("FINISH");
                prevBtn.setText("PREV");

            }

            else{
                nextBtn.setEnabled(true);
                prevBtn.setEnabled(true);
                prevBtn.setVisibility(View.VISIBLE);
                nextBtn.setText("NEXT");
                prevBtn.setText("PREV");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
            mDots[i].setTextColor(Color.GRAY);
            mDots[i].setTextSize(35);
        }
    };
}
