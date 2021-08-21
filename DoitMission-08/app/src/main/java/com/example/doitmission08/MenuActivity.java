package com.example.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU1 = 201;
    public static final int REQUEST_CODE_MENU2 = 202;
    public static final int REQUEST_CODE_MENU3 = 203;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerMenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, REQUEST_CODE_MENU1);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalesMenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, REQUEST_CODE_MENU2);
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerMenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, REQUEST_CODE_MENU3);
            }
        });

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String password = intent.getStringExtra("password");

        Toast.makeText(getBaseContext(), "id : " + id + ", password : " + password, Toast.LENGTH_LONG).show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_MENU1) {
            if (intent != null) {
                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", 고객 관리에서 넘어옴.", Toast.LENGTH_LONG);
                toast.show();
            }
        } else if(requestCode == REQUEST_CODE_MENU2) {
            if (intent != null) {
                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", 매출 관리에서 넘어옴.", Toast.LENGTH_LONG);
                toast.show();
            }
        } else if(requestCode == REQUEST_CODE_MENU3) {
            if (intent != null) {
                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", 상품 관리에서 넘어옴.", Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

}