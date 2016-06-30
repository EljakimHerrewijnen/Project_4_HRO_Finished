package com.example.jan_paul.lolol;

/**
 * Created by Joostdw1 on 29-6-2016.
 */
public class Data {
    String naam;
    int value;

    public Data(String naam, int value){
        this.naam = naam;
        this.value = value;
    }

    public int getNaam(){
        return value;
    }

    public void setNaam(String data_naam){
        this.naam = data_naam;
    }

    public int getValue(){
        return value;
    }

    public void setValue( int data_value){
        this.value = data_value;
    }
}
