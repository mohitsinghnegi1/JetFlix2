package com.example.android.jetflix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return slideHeading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView img=view.findViewById(R.id.img);
        TextView text1=view.findViewById(R.id.textView);
        TextView text2=view.findViewById(R.id.textView2);
        img.setImageResource(slide_images[position]);
        text1.setText(slideHeading[position]);
        text2.setText(slide_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }

    public SliderAdapter(Context context){

        this.context=context;
    }
    public int[] slide_images={
            R.drawable.search,
            R.drawable.hotel7,
            R.drawable.fast
    };
    public String[] slideHeading={
        "Search Hotels",
            "Hotel Special",
            "Fast Services"
    };
    public String[] slide_description={
           " finding and watching movies and TV shows  easier than ever . Search Your favourite movie anytime from any place .",
            "Free private parking is possible on site \n" +
                    "Air conditioning | " +
                    "Non-smoking throughout\n" +
                    "Soundproof rooms|" +
                    "Lift | " +
                    "Non-smoking rooms",
            "Book Your favourate Hotel Fast at a very low cost with lot of extra facilities such as gym , swimming pool , parlour etc."
    };


}
