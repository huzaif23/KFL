package com.huzaifa.project.football.Adapters;


import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huzaifa.project.football.R;
import com.squareup.picasso.Picasso;

public class List_Adapter extends ArrayAdapter<String> {
    String[] dummy;
    Integer[] dummys;
    Activity context;

    public List_Adapter(Activity context, String[] dummy, Integer[] dummys) {
        super(context, R.layout.list_item,dummy);
        this.context=context;
        this.dummy = dummy;
        this.dummys = dummys;
    }



    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_item,null,true);
        TextView textView = (TextView) view.findViewById(R.id.txt);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        AssetManager asm = context.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(asm,"fonts/Superstar M54.ttf");
        textView.setTypeface(typeface);
        textView.setText(dummy[position]);

//        img.setImageResource(dummys[position]);
        Picasso.with(context).load(dummys[position])
                .placeholder(R.drawable.place)
                .into(img);
        return view;
    }
}
