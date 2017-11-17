package com.huzaifa.project.football.Adapters;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huzaifa.project.football.Fragments.video_screen;
import com.huzaifa.project.football.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Muhammad Huzaifa on 10/4/2017.
 */

public class video_adapter extends RecyclerView.Adapter<video_adapter.ViewHolder> {
    String[] vid = {"hello","world","hey","fucker"};
    String[] links = {"https://img.youtube.com/vi/qoxSYKU6i14/hqdefault.jpg","https://img.youtube.com/vi/qoxSYKU6i14/hqdefault.jpg","https://img.youtube.com/vi/qoxSYKU6i14/hqdefault.jpg","https://img.youtube.com/vi/qoxSYKU6i14/hqdefault.jpg"};
    Context context;
    Fragment fragment ;
    FragmentManager fm;
    String x;
    RelativeLayout relativeLayout ;
    AppBarLayout appBarLayout;
     public video_adapter(Context context, FragmentManager fm) {
        this.context = context;
         this.fm = fm;
         x=context.getClass().getSimpleName();
         fragment = new video_screen();

    }

    @Override

    public video_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        relativeLayout = (RelativeLayout) parent.getRootView().findViewById(R.id.rlayout);
        appBarLayout = (AppBarLayout) parent.getRootView().findViewById(R.id.app_bar_layout);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(video_adapter.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction();
            }
        });
        holder.t1.setText(""+vid[position]);
        Picasso.with(context).load(links[position]).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return vid.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            t1=(TextView) itemView.findViewById(R.id.title);

        }
    }

    public void transaction() {

        FragmentTransaction ft = fm.beginTransaction();
        if(x.equals("Dashboard")) {
            ft.replace(R.id.rlayout, fragment);
            relativeLayout.removeAllViews();
            appBarLayout.setExpanded(false,true);
        } else {
            ft.replace(R.id.fl,fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }


}
