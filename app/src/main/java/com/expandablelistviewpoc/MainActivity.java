package com.expandablelistviewpoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.expandablelistviewpoc.adapters.ExpLvAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> name;
    private List<String> aalishan;
    private List<String> aakash;
    private List<String> ankur;
    private HashMap<String, List<String>> data;
    private ExpandableListView mExpandableListView;
    private ExpLvAdapter mExpLvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandableListView = (ExpandableListView) findViewById(R.id.exp_list_view);
        name = new ArrayList<>();
        aalishan = new ArrayList<>();
        aakash = new ArrayList<>();
        ankur = new ArrayList<>();
        data = new HashMap<String, List<String>>();


        String[] name = getResources().getStringArray(R.array.names);
        String[] city = getResources().getStringArray(R.array.aalishan_heading);
        String[] mobile = getResources().getStringArray(R.array.aakash_heading);
        String[] company = getResources().getStringArray(R.array.ankur_heading);


        for (String name1 : name
                ) {
            this.name.add(name1);

        }
        for (String city1 : city
                ) {
            this.aalishan.add(city1);

        }
        for (String moblie1 : mobile
                ) {
            this.aakash.add(moblie1);

        }
        for (String company1 : company
                ) {
            this.ankur.add(company1);

        }
        data.put(this.name.get(0), this.aalishan);
        data.put(this.name.get(1), this.aakash);
        data.put(this.name.get(2), this.ankur);


        mExpLvAdapter = new ExpLvAdapter(this, this.name, data);
        mExpandableListView.setAdapter(mExpLvAdapter);

    }
}
