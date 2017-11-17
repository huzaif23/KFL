package com.huzaifa.project.football.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huzaifa.project.football.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Muhammad Huzaifa on 9/24/2017.
 */

public class fixture_adapter extends BaseAdapter implements StickyListHeadersAdapter {

    String[] teams;
    String[] teams_name;
    private LayoutInflater layoutInflater ;

    public fixture_adapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        teams = context.getResources().getStringArray(R.array.teams);
        teams_name = context.getResources().getStringArray(R.array.teams_name);
    }

    @Override
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
       HeaderViewHolder head ;
        if (view == null) {
            head = new HeaderViewHolder();
            view = layoutInflater.inflate(R.layout.header,viewGroup,false);
            head.text = (TextView) view.findViewById(R.id.txtHead);
            view.setTag(head);
        }
        else {
            head = (HeaderViewHolder) view.getTag();
        }
        String headerText = "" +teams[i];
        head.text.setText(headerText);
        return view;

    }

    @Override
    public long getHeaderId(int i) {
        return  teams[i].subSequence(0,1).charAt(0);
    }

    @Override
    public int getCount() {
        return teams.length;
    }

    @Override
    public Object getItem(int position) {
        return teams[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHoler;
        if (convertView == null) {
            viewHoler = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.fix_item,parent,false);
            viewHoler.text = (TextView) convertView.findViewById(R.id.txt);
            viewHoler.text1 = (TextView) convertView.findViewById(R.id.txt1);
            convertView.setTag(viewHoler);
        }
        else {
            viewHoler = (ViewHolder) convertView.getTag();
        }


        viewHoler.text.setText(teams_name[position]);
        viewHoler.text1.setText(teams_name[position+1]);
        return convertView;
    }
    class ViewHolder {
        TextView text;
         TextView text1;
    }
    class HeaderViewHolder {
        TextView text,text1;
    }
}
