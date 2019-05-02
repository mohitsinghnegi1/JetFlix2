package com.example.android.jetflix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class LanguagesListAdapter extends BaseAdapter {

        SearchRoom context ;

    ArrayList<String> house_name;
    ArrayList<String> email;
    ArrayList<String> description;
    ArrayList<Integer> rooms_available;
    ArrayList<String> contact_no;
    ArrayList<Double> price;
    ArrayList<Double> size_sqfeet;
    ArrayList<Integer> img;
        private static LayoutInflater inflater=null;

        public LanguagesListAdapter(SearchRoom mainActivity, ArrayList<String> house, int[] prgmImages) {

        }

    public LanguagesListAdapter(SearchRoom searchRoom, ArrayList<String> house_name, ArrayList<Integer> img, ArrayList<String> email, ArrayList<String> description, ArrayList<Integer> rooms_available, ArrayList<String> contact_no, ArrayList<Double> price, ArrayList<Double> size_sqfeet) {
        this.house_name=house_name;
        this.context=searchRoom;
        this.email=email;
        this.description=description;
        this.contact_no=contact_no;
        this.img=img;
        this.price=price;
        this.size_sqfeet=size_sqfeet;
        this.rooms_available=rooms_available;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
        public int getCount() {
    // TODO Auto-generated method stub
            return house_name.size();
        }

        @Override
        public Object getItem(int position) {
    // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
    // TODO Auto-generated method stub
            return position;
        }

        public class Holder
        {
            TextView name1;
            ImageView img1;
            TextView email1;
            TextView desc1;
            TextView phoneno1;
            TextView size1;
            TextView price1;
            TextView room_avail1;

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
            Holder holder=new Holder();
            View view;
            view = inflater.inflate(R.layout.layout_room_list_item, null);

            holder.name1=(TextView) view.findViewById(R.id.name);
            holder.img1=(ImageView) view.findViewById(R.id.im_language);
            holder.email1=view.findViewById(R.id.email);
            holder.desc1=view.findViewById(R.id.desc);
            holder.phoneno1=view.findViewById(R.id.phoneno);
            holder.size1=view.findViewById(R.id.size);
            holder.price1=view.findViewById(R.id.price);
            holder.room_avail1=view.findViewById(R.id.room_avail);

            holder.name1.setText(house_name.get(position));
            holder.email1.setText(email.get(position));
            holder.desc1.setText(description.get(position));
            holder.phoneno1.setText(contact_no.get(position));
            holder.size1.setText("SIZE OF SPACE( in sqft ) : "+size_sqfeet.get(position));
            holder.price1.setText("PRICE : "+price.get(position));
            holder.room_avail1.setText("ROOM AVAILABLE : "+rooms_available.get(position));


            Picasso.with(context).load(img.get(position)).into(holder.img1);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    // TODO Auto-generated method stub
                    Toast.makeText(context, "You Clicked " + house_name.get(position), Toast.LENGTH_LONG).show();
                }
            });
            return view;
        }

    }

