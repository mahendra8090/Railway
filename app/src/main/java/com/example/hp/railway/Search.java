package com.example.hp.railway;

/**
 * Created by hp on 8/21/2017.
 */

public class Search {


    private  String mtrain_no_s;
    private  String mtrain_name_s;
    private  String mtrain_arrival_s;
    private  String mtrain_dept_s;
    private  String mtrain_time_s;

    public Search(String mtrain_arrival_s, String mtrain_dept_s, String mtrain_name_s, String mtrain_no_s,String mtrain_time_s) {
        this.mtrain_arrival_s = mtrain_arrival_s;
        this.mtrain_dept_s = mtrain_dept_s;
        this.mtrain_name_s = mtrain_name_s;
        this.mtrain_no_s = mtrain_no_s;
        this.mtrain_time_s = mtrain_time_s;
    }

    public String getMtrain_arrival_s() {
        return mtrain_arrival_s;
    }

    public String getMtrain_dept_s() {
        return mtrain_dept_s;
    }

    public String getMtrain_name_s() {
        return mtrain_name_s;
    }

    public String getMtrain_no_s() {
        return mtrain_no_s;
    }

    public String getMtrain_time_s() {
        return mtrain_time_s;
    }
}
