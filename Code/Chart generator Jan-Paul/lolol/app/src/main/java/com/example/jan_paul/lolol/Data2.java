package com.example.jan_paul.lolol;

/**
 * Created by Joostdw1 on 4-7-2016.
 */
public class Data2{
    String naam;
    int value1;
    int value2;

    public Data2(String naam, int value1, int value2){
        this.naam = naam;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getNaam(){
        return naam;
    }

    public void setNaam(String data_naam){
        this.naam = data_naam;
    }

    public int getValue1(){
        return value1;
    }

    public void setValue1( int data_value1){
        this.value1 = data_value1;
    }

    public int getValue2(){
        return value2;
    }

    public void setValue2( int data_value2){
        this.value1 = data_value2;
    }
}
