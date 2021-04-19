package com.example.myapplove;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private  String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ListView list = findViewById(R.id.main_listview);

        et_test = findViewById(R.id.et_test);

        List<String> data = new ArrayList<>();
        data.add("홈");
        data.add("리스트");
        data.add("달력");
        data.add("글쓰기");
        data.add("통계");
        data.add("이동하기");


        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                System.out.println("실행");

                str = et_test.getText().toString();//데이터값을 가지고 오는 역할 ???질문
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                intent.putExtra("str",str);
                startActivity(intent); //이동하기 위한 설정
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}