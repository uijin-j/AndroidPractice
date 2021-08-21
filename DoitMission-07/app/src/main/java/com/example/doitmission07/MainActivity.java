package com.example.doitmission07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("menu", "고객 관리"); //인텐트에 부가 데이터 넣기!
                setResult(RESULT_OK, intent); //이전 액티비티(여기선 메인)로 인텐트를 전달

                finish(); //현재 액티비티 없애기
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("menu", "매출 관리"); //인텐트에 부가 데이터 넣기!
                setResult(RESULT_OK, intent); //이전 액티비티(여기선 메인)로 인텐트를 전달

                finish(); //현재 액티비티 없애기
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("menu", "상품 관리"); //인텐트에 부가 데이터 넣기!
                setResult(RESULT_OK, intent); //이전 액티비티(여기선 메인)로 인텐트를 전달

                finish(); //현재 액티비티 없애기
            }
        });
    }
}