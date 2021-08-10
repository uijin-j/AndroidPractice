package com.highfives.doitmission_03;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        Button upButton = (Button) findViewById(R.id.buttonUp);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageUp();
            }
        });

        Button downButton = (Button) findViewById(R.id.buttonDown);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageDown();
            }
        });

        moveImageUp();
    }

    private void moveImageUp() {
        imageView1.setImageResource(R.drawable.img); //이미지 변경
        imageView2.setImageResource(0); //이미지 제거

        imageView1.invalidate(); //이미지 뷰 갱신
        imageView2.invalidate();
    }

    private void moveImageDown() {
        imageView1.setImageResource(0);
        imageView2.setImageResource(R.drawable.img);

        imageView1.invalidate();
        imageView2.invalidate();
    }
}