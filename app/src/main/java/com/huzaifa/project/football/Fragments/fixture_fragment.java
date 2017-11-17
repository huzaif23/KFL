package com.huzaifa.project.football.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.huzaifa.project.football.Adapters.fixture_adapter;
import com.huzaifa.project.football.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class fixture_fragment extends Fragment {


    public fixture_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_fixture_fragment,container,false);
        final StickyListHeadersListView stick = (StickyListHeadersListView) view.findViewById(R.id.list);
        fixture_adapter adapter = new fixture_adapter(getContext());
        stick.addHeaderView(inflater.inflate(R.layout.header, null));
        stick.setDividerHeight(20);
        stick.setDrawingListUnderStickyHeader(true);
        stick.setAdapter(adapter);
        stick.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fl,new videos_display());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return view;
    }

}
