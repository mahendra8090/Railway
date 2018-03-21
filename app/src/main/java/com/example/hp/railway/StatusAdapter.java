package com.example.hp.railway;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 8/20/2017.
 */

public class StatusAdapter extends ArrayAdapter<Status> {


    public StatusAdapter(Context context, ArrayList<Status> local) {
        super(context,0, local);
    }

    @NonNull
    @Override
    public  View getView(int position, View convertView, ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.status_list, parent, false);
        }


        Status current=getItem(position);

        TextView arr=(TextView)listitemView.findViewById(R.id.sch_arrival);
        arr.setText(current.getArrival());

        TextView dept=(TextView)listitemView.findViewById(R.id.sch_dept);
       dept.setText(current.getDept());
        TextView place=(TextView)listitemView.findViewById(R.id.place);
       place.setText(current.getMplace());
        TextView late=(TextView)listitemView.findViewById(R.id.late);
        late.setText(current.getMlate());
        TextView act_arr=(TextView)listitemView.findViewById(R.id.act_arrival);
        act_arr.setText(current.getMact_arr());
        TextView act_dept=(TextView)listitemView.findViewById(R.id.act_dept);
        act_dept.setText(current.getMact_dept());


  return  listitemView;
}}
