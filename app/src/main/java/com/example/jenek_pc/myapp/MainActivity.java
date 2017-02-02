package com.example.jenek_pc.myapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

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
        setContentView(R.layout.activity_main);

        final ArrayList<MenuPart> MenuPartArray = new ArrayList< MenuPart>();

        MenuPart first = new MenuPart("first");
        MenuPartArray.add(first);
        MenuPart second = new MenuPart("second");
        MenuPartArray.add(second);
        MenuPart end = new MenuPart("end");
        MenuPartArray.add(end);


        Context context = getApplicationContext();

        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, get_names(MenuPartArray));

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast toast = Toast.makeText(getApplicationContext(),
                        MenuPartArray.get(position).tag, Toast.LENGTH_SHORT);
                toast.show();;
        }
        });

        lvMain.setAdapter(adapter);
    }
}
