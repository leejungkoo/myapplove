package com.example.myapplove;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ListView list = findViewById(R.id.main_listview);

        List<String> data = new ArrayList<>();
        data.add("홈");
        data.add("리스트");
        data.add("달력");
        data.add("글쓰기");
        data.add("통계");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
