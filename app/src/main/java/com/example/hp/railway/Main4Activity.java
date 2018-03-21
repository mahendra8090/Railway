package com.example.hp.railway;

import android.app.ProgressDialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
int i;
    ProgressDialog progressDialog;
    ArrayList<Search> train_list=new ArrayList<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
      final TextView trains = (TextView) findViewById(R.id.trains);
        final RequestQueue queue = Volley.newRequestQueue(this);
        progressDialog = new ProgressDialog(Main4Activity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);

        final JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, "http://api.railwayapi.com/v2/between/source/LJN/dest/BSB/date/24-09-2018/apikey/y5dhxplwzs/", null, new Response.Listener<JSONObject>() {

                    @Override


                    public void onResponse(JSONObject response) {
                        progressDialog.show();
                       // trains.setText(""+response);
                        try {
                            JSONArray total_trains = response.getJSONArray("trains");
                            for (i = 0; i < total_trains.length(); i++) {
                                JSONObject train_details = total_trains.getJSONObject(i);
                                String train_name = train_details.getString("name");
                                String train_no = train_details.getString("number");
                                String train_dept = train_details.getString("src_departure_time");
                                String train_arrival = train_details.getString("dest_arrival_time");
                                String train_time = train_details.getString("travel_time");

                                train_list.add(new Search(train_arrival,train_dept, train_name,train_no,train_time));


                            }
                            progressDialog.dismiss();
                            ListView list_train = (ListView) findViewById(R.id.list_trains);
                            SearchAdapter adapter = new SearchAdapter(Main4Activity.this,train_list);
                            list_train.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Display the first 500 characters of the response string.

                    }


                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        trains.setText("error");
                        progressDialog.dismiss();
                    }

                });


// Add the request to the RequestQueue.
        queue.add(jsonRequest);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.




    }

}

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
