package com.highfive.doitmission14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2); //2개의 칼럼을 가진 격자 모양으로 설정하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager); //(1) 리싸이클러뷰에 레이아웃 매니저 객체 설정


        adapter = new ProductAdapter(); //어댑터 생성

        adapter.addItem(new Product("롱코트", "160,000원", "명절 기획상품입니다."));
        adapter.addItem(new Product("빈탄 와이셔츠", "80,000원", "특가상품입니다."));
        adapter.addItem(new Product("조깅화", "220,000원", "베스트상품입니다."));
        adapter.addItem(new Product("구O 썬글라스", "70,000원", "인기기품입니다."));

        recyclerView.setAdapter(adapter); //리싸이클러뷰가 어댑터와 상호작용하면서 리스트 모양으로 보여주게 됨

        //(2) 어댑터에 리스너 객체 설정
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position); //클릭 한 아이템의 Person 객체 참조

                Toast.makeText(getApplicationContext(), "상품 이름 : " + item.getName() + ", 상품 가격 : " + item.getPrice(), Toast.LENGTH_LONG).show();
            }
        });
    }
}