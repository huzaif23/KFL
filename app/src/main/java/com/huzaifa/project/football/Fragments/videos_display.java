package com.huzaifa.project.football.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.huzaifa.project.football.Adapters.video_adapter;
import com.huzaifa.project.football.R;



public class videos_display extends Fragment  {

video_adapter video_adapter;
RelativeLayout relativeLayout;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManager = getFragmentManager();
         video_adapter = new video_adapter(context,fragmentManager);
    }

    public videos_display(RelativeLayout relativeLayout) {
       this.relativeLayout = relativeLayout;
    }
    public videos_display() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_videos_display,container,false);
        RecyclerView rc = (RecyclerView) view.findViewById(R.id.rc);
        rc.setHasFixedSize(true);
        StaggeredGridLayoutManager stgl  = new StaggeredGridLayoutManager(2,1);
        rc.setLayoutManager(stgl);
        rc.setAdapter(video_adapter);

        return view;
    }





}
