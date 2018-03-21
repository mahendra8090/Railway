package com.example.hp.railway;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 8/21/2017.
 */

public class SearchAdapter extends ArrayAdapter<Search> {

    public SearchAdapter(Context context, ArrayList<Search> pnr){
        super(context,0,pnr);
    }
    public  View getView(int position, View convertView, ViewGroup parent){

    View listitemView = convertView;
    if (listitemView == null) {
        listitemView = LayoutInflater.from(getContext()).inflate(
                R.layout.search, parent, false);
    }
        Search current=getItem(position);
        TextView train_name_s=(TextView)listitemView.findViewById(R.id.train_name_s);
        train_name_s.setText(current.getMtrain_name_s());
        TextView train_no_s=(TextView)listitemView.findViewById(R.id.train_no_s);
        train_no_s.setText(current.getMtrain_no_s());
        TextView train_dept_s=(TextView)listitemView.findViewById(R.id.train_depart_s);
        train_dept_s.setText(current.getMtrain_arrival_s());
        TextView train_arrival_s=(TextView)listitemView.findViewById(R.id.train_arrival_s);
        train_arrival_s.setText(current.getMtrain_dept_s());
        TextView train_time_s=(TextView)listitemView.findViewById(R.id.train_time_s);
        train_time_s.setText(current.getMtrain_time_s());


    return listitemView;

}}
