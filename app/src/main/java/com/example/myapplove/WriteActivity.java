package com.example.myapplove;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


public class WriteActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_activity);

        Intent intent = getIntent();
        //Intent intent=new Intent(this.getIntent());

        String str = intent.getStringExtra("str");

    }
}