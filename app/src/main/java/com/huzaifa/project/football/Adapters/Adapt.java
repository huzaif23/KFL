package com.huzaifa.project.football.Adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.huzaifa.project.football.Model;
import com.huzaifa.project.football.R;

import java.util.List;

public class Adapt extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Model> models;


    public Adapt(List<Model> models) {
        this.models=models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
       RecyclerView.ViewHolder viewHolders = null;

        switch (viewType) {
            case 0 :
           view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            viewHolders = new viewHolder(view);
            break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
                viewHolders = new ViewHolders(view);
                break;
        }
        return viewHolders;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int viewtype = getItemViewType(position);
//            switch (viewtype) {
//                case 0:
//        viewHolder vh = (viewHolder) holder;
//      vh.t1.setText("hello");
//                    vh.t2.setText("world");
//                    break;
//                case 1:
//                    ViewHolders viewHolderss = (ViewHolders) holder;
//                    viewHolderss.b1.setEnabled(false);
//                    break;
//
//        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    class ViewHolders extends RecyclerView.ViewHolder {
        CardView cw;
        Button b1,b2,b3;
        public ViewHolders(View itemView) {
            super(itemView);
            cw = (CardView) itemView.findViewById(R.id.cv1);

            Log.v("card","it workds");
        }

    }

    class viewHolder extends RecyclerView.ViewHolder {
        CardView cw;
        TextView t1;
        TextView t2;
        public viewHolder(View itemView) {
            super(itemView);
//            cw = (CardView) itemView.findViewById(R.id.cv);
//            t1 = (TextView) itemView.findViewById(R.id.txt1);
//            t2 = (TextView) itemView.findViewById(R.id.txt2);
        }
    }
}
