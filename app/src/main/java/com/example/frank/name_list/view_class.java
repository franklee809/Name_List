package com.example.frank.name_list;

/**
 * Created by frank on 24/7/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.frank.name_list.R.id.list_v;


public class view_class extends AppCompatActivity{
    String class_name;
    String student_name;
    ListView a;
    TextView b;
    List<String> arrayList;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_class);

        b = (TextView)findViewById(R.id.class_name);


        Intent intent = getIntent();
        Bundle bundleObject = getIntent().getExtras();
        class_name = bundleObject.getString("Class_Name");
        b.setText(class_name);

        ArrayList<String> classname = (ArrayList<String>) intent.getSerializableExtra("name");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,classname);
        a = (ListView)findViewById(list_v);
        a.setAdapter(adapter);



    }

}
