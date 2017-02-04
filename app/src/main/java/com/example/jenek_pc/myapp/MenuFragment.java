package com.example.jenek_pc.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jenek-pc on 2/3/2017.
 */

public class MenuFragment extends Fragment {

        public String[] get_names(ArrayList<MenuPart> x) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < x.size(); i++) {
                list.add(x.get(i).tag);
            }
            return list.toArray(new String[0]);
        }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context context = getActivity().getApplicationContext();

        context.setTheme(R.style.AppTheme);

        View FragmentView =  inflater.inflate(R.layout.menu_fragment,container,false);

        ListView mlv = (ListView)FragmentView.findViewById(R.id.lvMenu);

       final ArrayList<MenuPart> MenuPartArray = new ArrayList< MenuPart>();

        MenuPart first = new MenuPart("fr1",MenuPartArray);
        MenuPart second = new MenuPart("fr2",MenuPartArray);
        MenuPart end = new MenuPart("fr3",MenuPartArray);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1);

        adapter.addAll(get_names(MenuPartArray));

        mlv.setAdapter(adapter);

        return FragmentView;
    }
}

