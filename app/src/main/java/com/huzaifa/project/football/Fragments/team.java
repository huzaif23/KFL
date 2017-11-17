package com.huzaifa.project.football.Fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.huzaifa.project.football.Adapters.List_Adapter;
import com.huzaifa.project.football.Dashboard;
import com.huzaifa.project.football.R;

public class team extends Fragment {
    public team() {

    }

    ListView list;
    String dummy[] = {
            "FC Barcelona","Arsenal FC","Real Madrid CF","PSG","Manchester United FC"
    };
    Integer[] dummys = {
            R.drawable.a,R.drawable.b,R.drawable.d,R.drawable.e,R.drawable.f
    };
    Intent intent = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team,container,false);
        list = (ListView) view.findViewById(R.id.lv);
        TextView textView1 = (TextView) view.findViewById(R.id.txt1);
        Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(),"fonts/Superstar M54.ttf");
        textView1.setTypeface(typeface);
        List_Adapter list_adapter = new List_Adapter(getActivity(),dummy,dummys);
        list.setAdapter(list_adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getActivity(), Dashboard.class);
                startActivity(intent);
            }
        });
        return view;
    }

}




