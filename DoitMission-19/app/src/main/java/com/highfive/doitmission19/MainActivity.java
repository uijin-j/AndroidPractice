package com.highfive.doitmission19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    WebView webView;

    String url;

    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        webView = (WebView) findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); // 웹페이지 자바스크립트 허용 여부

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext()); //요청 큐 생성
        }
    }

    public void makeRequest() {
        url = editText.getText().toString();

        //요청 객체 생성
        StringRequest request = new StringRequest(
                Request.Method.GET, //파라미터1, 요청 방식
                url, //파라미터2, 웹 사이트 주소
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { //응답 받으면 자동으로 호출
                        processResponse(response);
                    }
                }, //파라미터3, 응답받을 리스너
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {}
                } //파라미터4, 오류 리스너
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                return params;
            }
        };

        request.setShouldCache(false); //캐쉬를 사용하지 않도록 설정
        requestQueue.add(request); //요청 객체를 요청 큐에 넣기
    }

    public void processResponse(String response) {
        textView.setText(response);
        webView.loadUrl(url); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
    }
}