package com.example.hp.railway;

/**
 * Created by hp on 8/20/2017.
 */

public class Status {

    private String marrival;
    private String mdept;
    private String mplace;
    private String mlate;
    private String mact_arr;
    private String mact_dept;
    public Status(String arrival, String dept,String place,String late,String act_arr,String act_dept) {
        marrival = arrival;
       mdept = dept;
        mplace=place;
        mlate=late;
        mact_arr=act_arr;
        mact_dept=act_dept;
    }

    public String getArrival() {
        return marrival;
    }

    public String getDept() {
        return mdept;
    }

    public String getMplace() {
        return mplace;
    }

    public String getMlate() {
        return mlate;
    }

    public String getMact_arr() {
        return mact_arr;
    }

    public String getMact_dept() {
        return mact_dept;
    }
}
