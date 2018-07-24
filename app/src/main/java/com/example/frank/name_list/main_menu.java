package com.example.frank.name_list;

/**
 * Created by frank on 24/7/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class main_menu extends AppCompatActivity{

    public main_menu() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

    }

    public void btn_new_class(View view) {
        startActivity(new Intent(this, new_class.class));
    }


}
