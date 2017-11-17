package com.huzaifa.project.football.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huzaifa.project.football.Adapters.StatsAdapter;
import com.huzaifa.project.football.Model;
import com.huzaifa.project.football.R;

import java.util.ArrayList;


public class Team_info extends Fragment {

StatsAdapter statsAdapter;
    ArrayList<Object> models;
    public Team_info() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_info,container,false);
        Initializer();
        RecyclerView rc = (RecyclerView) view.findViewById(R.id.rc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rc.setLayoutManager(linearLayoutManager);
        statsAdapter = new StatsAdapter(models);
        rc.setAdapter(statsAdapter);
        rc.setHasFixedSize(true);
        return view;
    }
    public void Initializer() {
         models = new ArrayList<>();
        models.add(new Model("asd","adsf","asdf","3","4","5"));
        models.add("image");
}
}