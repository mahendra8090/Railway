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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    public EditText edit;
    public String e;
    public TextView pnr_;
   public  TextView t_name_;
    public TextView t_no_;
  public TextView t_class_;
    public TextView doj_;
    public TextView status;
    public TextView to_name;
    public TextView to_code;
    public TextView f_name;
    public TextView f_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edit = (EditText) findViewById(R.id.pnrstatus);



       pnr_ = (TextView) findViewById(R.id.pnr);
        t_name_ = (TextView) findViewById(R.id.train_name);
        t_no_ = (TextView) findViewById(R.id.train_no);
        t_class_ = (TextView) findViewById(R.id.t_class);
       doj_ = (TextView) findViewById(R.id.doj);
       status = (TextView) findViewById(R.id.status);
        to_name = (TextView) findViewById(R.id.from_name);
        to_code = (TextView) findViewById(R.id.from_code);
        f_name = (TextView) findViewById(R.id.to_name);
       f_code = (TextView) findViewById(R.id.to_code);}

public void submitpnr2(){
        e=edit.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(Main3Activity.this);
        String url = "http://api.railwayapi.com/v2/pnr-status/pn"+e+"apikey/y5dhxplwzs/";

// Request a string response from the provided URL.
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            int passanger_no = response.getInt("total_passengers");
                            String t_name = response.getString("train_name");
                            String t_no = response.getString("train_num");
                            String t_class = response.getString("class");
                            String t_pnr = response.getString("pnr");
                            String t_doj = response.getString("doj");
                            JSONObject t_fromjson = response.getJSONObject("from_station");
                            String t_from_name = t_fromjson.getString("name");
                            String t_from_code = t_fromjson.getString("code");
                            JSONObject t_tojson = response.getJSONObject("reservation_upto");
                            String t_to_name = t_fromjson.getString("name");
                            String t_to_code = t_fromjson.getString("code");
                            status.setText("sucess");
                            t_class_.setText(t_class);
                            doj_.setText(t_doj);
                            t_no_.setText(t_no);
                            t_name_.setText(t_name);
                            pnr_.setText(t_pnr);
                            to_name.setText(t_to_name);
                            to_code.setText(t_to_code);
                            f_name.setText(t_from_name);
                            f_code.setText(t_from_code);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }}


                , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        status.setText("error");
                    }
                });
// Add the request to the RequestQueue.
        queue.add(jsonRequest);






    }

    }

