package com.huzaifa.project.football.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huzaifa.project.football.Model;
import com.huzaifa.project.football.R;

import java.util.List;



public class StatsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> models;
   public StatsAdapter(List<Object> models)
    {
        this.models = models;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case 0:
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_item,parent,false);
            viewHolder = new ViewHolder(view);
            break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_two_items,parent,false);
                viewHolder = new SecondViewHolder(view);
                break;
            default:
                viewHolder = null;
        }

        return  viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
       if(models.get(position) instanceof Model) {
           return 0;
       }
       else if(models.get(position) instanceof String)
           return 1;
       return -1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       int item = getItemViewType(position);

        switch (holder.getItemViewType()) {
            case 0:
                ViewHolder viewHolders = (ViewHolder) holder;

                setFields(viewHolders,position);
                break;
            case 1:
                SecondViewHolder secondViewHolder = (SecondViewHolder) holder;
                secondViewHolder.image.setImageResource(R.drawable.ronaldoo);
                break;
        }
    }

//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//            switch (position) {
//                case 0:
//                    holder.t1.setText("Win");
//                    holder.t2.setText(models.get(position).win);
//                    break;
//                case 1:
//                    holder.t1.setText("Lose");
//                    holder.t2.setText(models.get(position).lose);
//                    break;
//                case 2:
//                    holder.t1.setText("Draw");
//                    holder.t2.setText(models.get(position).draw);
//                    break;
//            }
//    }



    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView t1,t2,t3,t4,t5,t6;
        public CardView cardView;

        public  ViewHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.txt2);
             t2 = (TextView) itemView.findViewById(R.id.txt4);
            t3 = (TextView) itemView.findViewById(R.id.txt6);
             cardView = (CardView) itemView.findViewById(R.id.cv2);
        }
    }

    class SecondViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView name;
            TextView goals;
        public SecondViewHolder(View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);


        }
    }

    private void setFields(ViewHolder viewHoldera,int position) {
       Model model = (Model) models.get(position);
       viewHoldera.t1.setText(model.win);
        viewHoldera.t2.setText(model.lose);
        viewHoldera.t3.setText(model.draw);
    }
}
