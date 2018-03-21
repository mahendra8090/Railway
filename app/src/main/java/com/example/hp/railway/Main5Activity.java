package com.example.hp.railway;

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

public class Main5Activity extends AppCompatActivity {
    int i;
     String date;
     String train_no;
    String e_station_code;

     EditText e_train_no,e_date,e_station;
TextView testing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        e_station=(EditText)findViewById(R.id.spot_station_name);
        e_date=(EditText)findViewById(R.id.spot_date);
        e_train_no=(EditText)findViewById(R.id.s_train_no);
       testing=(TextView)findViewById(R.id.testing);

    }

    public void submit_spot(View view){
        date=e_date.getText().toString();
        train_no=e_train_no.getText().toString();
        e_station_code=e_station.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.railwayapi.com/v2/live/train/"+train_no+"/date/"+date+"/apikey/y5dhxplwzs/";

// Request a string response from the provided URL.
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {



                        try {
                            JSONArray r_route = response.getJSONArray("route");

                            for(i=0;i<r_route.length();i++) {

                                JSONObject route1 = r_route.getJSONObject(i);
                                JSONObject station=route1.getJSONObject("station_");
                                String s=station.getString("code");
                               if(s.equals(e_station_code))
                                   break;


                            }
                            JSONObject route1 = r_route.getJSONObject(i);
                            JSONObject station=route1.getJSONObject("station_");
                            String mystation_code=station.getString("code");
                            String mystation_sedarr=station.getString("scharr");
                            String mystation_seddept=station.getString("schdep");
                            String mystation_actarr=station.getString("actarr");
                            String mystation_actdept=station.getString("actdep");
                            String mystation_depatingstatus=station.getString("has_departed");
                            String mystation_latestatus=station.getString("latemin");
                            String mystation_day=station.getString("day");
                            String mystation_scharr_date=station.getString("scharr_date");
                            String mystation_actarr_day=station.getString("actarr_date");


                            testing.setText(mystation_code);//+"\n"+mystation_sedarr+"\n"+mystation_actdept+"\n"+mystation_seddept+"\n"+mystation_actarr+"\n"+mystation_depatingstatus+"\n"+
                                   // "\n"+mystation_latestatus+"\n"+mystation_day+"\n"+mystation_scharr_date+"\n"+mystation_actarr_day  );









                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }


                    // Display the first 500 characters of the response string.

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       testing.setText("error");
                    }
                });

        queue.add(jsonRequest);


    }
}
