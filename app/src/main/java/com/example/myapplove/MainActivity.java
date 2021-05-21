package com.example.myapplove;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AdapterView;
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
        data.add("패스");
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

                //str = et_test.getText().toString();//이줄부터 이동처리하는 함수
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                //intent.putExtra("str",str);//글씨까지 이동하는 함수
                startActivity(intent); //이동하기 위한 설정 여기까지>
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                // 8. 클릭한 아이템의 문자열을 가져와서
                String selected_item = (String)adapterView.getItemAtPosition(position);

                System.out.println(selected_item);
                if (selected_item=="리스트"){

                    Intent intent = new Intent(MainActivity.this , SubActivity.class);
                    startActivity(intent); //이동하기 위한 설정 여기까지>
                }

                if (selected_item=="통계"){

                    Intent intent = new Intent(MainActivity.this , StatisticsActivity.class);
                    startActivity(intent);
                }
                if (selected_item=="글쓰기"){

                    Intent intent = new Intent(MainActivity.this ,WriteActivity.class);
                    startActivity(intent);
                }

                if (selected_item=="달력"){

                    Intent intent = new Intent(MainActivity.this ,CalendarActivity.class);
                    startActivity(intent);
                }

                // 9. 해당 아이템을 ArrayList 객체에서 제거하고
                //list.remove(selected_item);

                // 10. 어댑터 객체에 변경 내용을 반영시켜줘야 에러가 발생하지 않습니다.
                adapter.notifyDataSetChanged();
            }
        });
    }

}