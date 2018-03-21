package com.example.hp.railway;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public int i;

    public String s1="14236";
    public String s2="19-03-2018";
    public TextView mTextView;
    public EditText et1;
    public EditText et2;
    public  StatusAdapter itemAdapter;
    String  jsonResponse;
    //declear array
   public ArrayList<Status> stat=new ArrayList<Status>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


     mTextView = (TextView) findViewById(R.id.status);
        et1 = (EditText) findViewById(R.id.s_train_no);
        et2 = (EditText) findViewById(R.id.date);

// Instantiate the RequestQueue.



    }
    public void submitstatus(View view){
        s1=et1.getText().toString();
        s2=et2.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.railwayapi.com/v2/live/train/14235/date/21-03-2018/apikey/y5dhxplwzs/";
        jsonResponse="mahendra kumar";
// Request a string response from the provided URL.
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {



                        try {
                            JSONArray r_route = response.getJSONArray("route");

                           for(i=0;i<r_route.length();i++) {

                                JSONObject route1 = r_route.getJSONObject(i);
                                String sed_arrival = route1.getString("scharr");
                                String sed_dept = route1.getString("schdep");
                                String late=route1.getString("status");
                                String act_arr=route1.getString("actarr");
                                String act_dept=route1.getString("actdep");
                                JSONObject station=route1.getJSONObject("station");
                                String s=station.getString("name");

                                stat.add(new Status(sed_arrival,sed_dept,s,late,act_arr,act_dept));

                            }
                            mTextView.setText("sucess"+jsonResponse);
                           StatusAdapter itemAdapter = new StatusAdapter(Main2Activity.this,stat);
                            ListView listView=(ListView)findViewById(R.id.list);
                         listView.setAdapter(itemAdapter);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }


                    // Display the first 500 characters of the response string.

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("That didn't work!");
                    }
                });

        queue.add(jsonRequest);


    }}

