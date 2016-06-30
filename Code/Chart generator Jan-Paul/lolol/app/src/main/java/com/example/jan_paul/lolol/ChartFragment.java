package com.example.jan_paul.lolol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by jan-paul on 30-6-2016.
 */
public class ChartFragment extends Fragment {

    public static ChartFragment newInstance() {
        return new ChartFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_chart, container, false);
    }
}
