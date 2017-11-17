package com.huzaifa.project.football.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huzaifa.project.football.Adapters.Adapt;
import com.huzaifa.project.football.Model;
import com.huzaifa.project.football.R;

import java.util.List;


public class main_Fragment extends Fragment {
    List<Model> models;
    public main_Fragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_main_frag,container,false);
        RecyclerView rc = (RecyclerView) view.findViewById(R.id.rc);
        rc.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rc.setLayoutManager(linearLayoutManager);
        Adapt adapt = new Adapt(models);
        rc.setAdapter(adapt);
        return view;
    }


}
