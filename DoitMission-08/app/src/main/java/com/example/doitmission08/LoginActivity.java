package com.example.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 1001;

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText = (EditText) findViewById(R.id.idInput);
        editText2 = (EditText) findViewById(R.id.passwordInput);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText.getText().toString();
                String password = editText2.getText().toString();

                //아이디 또는 비밀번호가 비었는지 확인
                if((!id.equals(""))&&(!password.equals(""))) {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    intent.putExtra("id", id);
                    intent.putExtra("password", password);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                } else {
                    Toast.makeText(getApplicationContext(), "아이디 또는 비번를 입력해주세요:)" ,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        if(msg!=null){
            Toast.makeText(getBaseContext(), "msg : "+ msg, Toast.LENGTH_LONG).show();
        }
    }
}