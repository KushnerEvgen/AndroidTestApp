package com.example.jenek_pc.myapp;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenek-pc on 2/2/2017.
 */


public class MenuPart {

    public String tag = "Default";

    public static void Notify(Context context,String info)
    {
        Toast toast = Toast.makeText(context,
                "Default" + info, Toast.LENGTH_SHORT);
        toast.show();
    }

    public MenuPart(String tag,ArrayList<MenuPart> x)
    {
        x.add(this);
        this.tag = tag;
    }

}
