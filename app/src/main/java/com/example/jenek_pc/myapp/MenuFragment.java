package com.example.jenek_pc.myapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;


/**
 * Created by Jenek-pc on 2/3/2017.
 */

public class MenuFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_fragment,container,false);
    }
}
