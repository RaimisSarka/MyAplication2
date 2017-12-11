package com.example.raisar.myapplication.utils;

/**
 * Created by raisar on 12/7/2017.
 */

public class Utilitys {

    public static String VARDAS = "vardas";
    public static String PAVARDE = "pavarde";

    public String mVardas;
    public String mPavarde;


    public Utilitys(){
        mVardas = "";
        mPavarde = "";
    }

    public String getName (String poz) {
        String ats = "";
        if (poz == VARDAS) {
            ats = mVardas;
        } else if (poz == PAVARDE) {
            ats = mPavarde;
        }
        return ats;
    }

    public void setName(String v, String p){
        mVardas = v;
        mPavarde = p;
    }

}
