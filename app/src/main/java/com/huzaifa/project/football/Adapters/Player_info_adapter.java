package com.huzaifa.project.football.Adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huzaifa.project.football.R;

public class Player_info_adapter extends RecyclerView.Adapter<Player_info_adapter.Viewholder> {

public Player_info_adapter() {

}

    class Viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        CardView cardView;
        TextView t1,t2;
        public Viewholder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgs);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            t1=(TextView) itemView.findViewById(R.id.name);
            t2= (TextView) itemView.findViewById(R.id.pos);
        }
    }

    @Override
    public Player_info_adapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.player_info_items,parent,false);
        Player_info_adapter.Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Player_info_adapter.Viewholder holder, int position) {
        switch (position) {
            case 0:
        holder.img.setImageResource(R.drawable.messi);
        holder.t1.setText("Messi");
        holder.t2.setText("LM");
                break;
            case 1:
                holder.img.setImageResource(R.drawable.rona);
                holder.t1.setText("Ronaldo");
                holder.t2.setText("LWF");
                break;
            case 2:
                holder.img.setImageResource(R.drawable.kaka);
                holder.t1.setText("Kaka");
                holder.t2.setText("MF");

    }}

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
