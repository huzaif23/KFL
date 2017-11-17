package com.huzaifa.project.football.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huzaifa.project.football.Adapters.Player_info_adapter;
import com.huzaifa.project.football.R;


public class Player_info extends Fragment {

RecyclerView recyclerView;
    Player_info_adapter player_info;

    LinearLayoutManager linearLayoutManager;
    StaggeredGridLayoutManager stl;
    public Player_info() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_info,container,false);
        player_info = new Player_info_adapter();
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
         linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        stl = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(stl);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(player_info);
        return view;
    }


}
