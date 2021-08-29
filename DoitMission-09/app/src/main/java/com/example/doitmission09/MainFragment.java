package com.example.doitmission09;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainFragment extends Fragment {
    EditText editTextDate;
    Date selectedDate;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일"); //날짜 포맷 설정

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        editTextDate = (EditText) rootView.findViewById(R.id.editTextDate);
        Date curDate = new Date(); //현재 날짜 받아오기
        setSelectedDate(curDate); //현재 날짜를 editTextDate에 설정
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "저장버튼을 눌렀습니다!", Toast.LENGTH_LONG).show(); //프래그먼트에서는 getActivity().getApplicationContext() 사용!
            }
        });

        return rootView;
    }

    private void showDateDialog() {
        String birthDateStr = editTextDate.getText().toString(); //지금 선택된 생년월일 받아오기

        Calendar calendar = Calendar.getInstance();
        Date curBirthDate = new Date();
        try {
            curBirthDate = dateFormat.parse(birthDateStr); //현재 적혀진 생일을 알맞은 포맷으로 바꾸기
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        calendar.setTime(curBirthDate); //현재 시간으로 캘린더에 표시

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getContext(),  birthDateSetListener,  curYear, curMonth, curDay); //selectListener()와 띄울 날짜를 설정히여 dialog 생성
        dialog.show(); //dialog 띄우기
    }

    //날짜를 선택했을 때
    private DatePickerDialog.OnDateSetListener birthDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.set(Calendar.YEAR, year); //선택한 년도 캘린더에 표시하기
            selectedCalendar.set(Calendar.MONTH, monthOfYear); //선택한 월 캘린더에 표시하기
            selectedCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth); //선택한 날짜 캘린더에 표시하기

            Date curDate = selectedCalendar.getTime(); //선택한 Date객체 가져오기
            setSelectedDate(curDate); //선택한 생년월일을 알맞은 포맷으로 editTextDate에 설정!
        }
    };

    private void setSelectedDate(Date curDate) {
        selectedDate = curDate; //선택한 생년월일 받아오기

        String selectedDateStr = dateFormat.format(curDate); //알맞은 포맷으로 설정
        editTextDate.setText(selectedDateStr); //editTextDate에 보여주기
    }

}