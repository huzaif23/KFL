package com.huzaifa.project.football.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.huzaifa.project.football.R;

public class pts_table_adapter extends RecyclerView.Adapter<pts_table_adapter.ViewHolder> {

    String[] groups = {"Group A","Group B","Group C","Group D"};
    String[] teams = {"Real Madrid","Barcelona","Arsenal","Liverpool"};
    Integer[] pts = {4,5,6,4};
    Context context;
    public pts_table_adapter(Context context) {
       this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pts_table_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.head.setText(""+groups[position]);
        addRows(context,holder.table);

    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return groups.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView head;
        TableLayout table;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            head = (TextView) itemView.findViewById(R.id.head);
            table = (TableLayout) itemView.findViewById(R.id.table);
            cardView = (CardView) itemView.findViewById(R.id.card);
        }

        }
    public void addRows(Context context,TableLayout tableLayout) {
        TableRow[] row = new TableRow[teams.length];
        TextView[] textViews = new TextView[5];
        for (int i=0;i<teams.length;i++) {
            row[i] = new TableRow(context);
            row[i].setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            for(int x=0;x<5;x++) {
                textViews[x] = new TextView(context);
                textViews[x].setTextSize(14);
                textViews[x].setTextColor(Color.BLACK);
                textViews[x].setPadding(0,15,0,0);
                if(i == teams.length-1) {
                    textViews[i].setPadding(0,0,0,20);
                }
                if(x==0)
                    textViews[x].setText(String.valueOf(i+1));
                else if (x==1)
                    textViews[x].setText(teams[i]);
                else if (x==2)
                    textViews[x].setText(String.valueOf(5));
                else if (x==3)
                    textViews[x].setText(String.valueOf(6));
                else
                    textViews[x].setText(String.valueOf(12));

                row[i].addView(textViews[x]);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    textViews[x].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }

            }

            tableLayout.addView(row[i]);
        }
    }
}




