package com.example.raisar.myapplication.utils;

/**
 * Created by raisar on 12/8/2017.
 */

public class EilutesObj {
    private String zod1, zod2, zod3;

    public EilutesObj(){

    }
     public EilutesObj(String z1, String z2,String z3){
         zod1 = z1;
         zod2 = z2;
         zod3 = z3;
     }

     public String getZod1(){
         return zod1;
     }

     public void setZod1(String z){
         zod1 = z;
     }

    public String getZod2(){
        return zod2;
    }

    public void setZod2(String z){
        zod2 = z;
    }

    public String getZod3(){
        return zod3;
    }

    public void setZod3(String z){
        zod3 = z;
    }
}
