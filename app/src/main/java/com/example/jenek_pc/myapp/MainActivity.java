package com.example.jenek_pc.myapp;

import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    public String[] get_names( ArrayList<MenuPart> x)
    {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < x.size(); i++)
        {
           list.add(x.get(i).tag);
        }
        return list.toArray(new String[0]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getApplicationContext();

        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction= fm.beginTransaction();

        final MenuFragment mf = new MenuFragment();

        transaction.setCustomAnimations(R.anim.slide_from_left,R.anim.exit_to_left);

        transaction.add(R.id.menu,mf);

        transaction.commit();

        final ArrayList<MenuPart> MenuPartArray = new ArrayList< MenuPart>();

        MenuPart first = new MenuPart("first",MenuPartArray);
        MenuPart second = new MenuPart("second",MenuPartArray);
        MenuPart end = new MenuPart("end",MenuPartArray);


        final ListView lvMain = (ListView) findViewById(R.id.lvMain);

        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.slide_from_left);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        adapter.addAll(get_names(MenuPartArray));

        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                adapter.add(adapter.getItem(position));
                lvMain.startAnimation(anim);
        }

        });

        lvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long id) {
                adapter.remove(adapter.getItem(position));

                return true;
            }
        });
    }
}
