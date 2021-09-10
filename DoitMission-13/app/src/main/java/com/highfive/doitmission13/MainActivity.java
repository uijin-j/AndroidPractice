package com.highfive.doitmission13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomerAdapter adapter;

    EditText editText;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager); //(1) 리싸이클러뷰에 레이아웃 매니저 객체 설정


        adapter = new CustomerAdapter(); //어댑터 생성

        adapter.addItem(new Customer("정의진", "2000-05-31", "010-3066-2820")); //어댑터에 Customer객체 추가

        recyclerView.setAdapter(adapter); //리싸이클러뷰가 어댑터와 상호작용하면서 리스트 모양으로 보여주게 됨

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(adapter.getItemCount()+"명");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String birth = editText2.getText().toString();
                String mobile = editText3.getText().toString();

                adapter.addItem(new Customer(name, birth, mobile));
                textView2.setText(adapter.getItemCount()+"명");
            }
        });
    }
}