package com.highfive.doitmission13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
        ArrayList<Customer> items = new ArrayList<Customer>(); //어댑터에서 관리하는 아이템 리스트

        @NonNull
        @Override
        //(2) 어댑터 필수 구현 메서드 - 어댑터가 만들어질 때 자동 호출
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()); //인플레이터 참조
            View itemView = inflater.inflate(R.layout.customer_item, viewGroup, false); //각 아이템을 위해 정의한 XML 레이아웃을 이용해 뷰 객체 생성

            return new ViewHolder(itemView); //뷰 객체를 새로운 뷰홀더 객체에 담아서 반환
        } //(참고) int viewType은 각 아이템을 위한 뷰를 여러 가지로 나누어 보여주고 싶을 때 사용

        @Override
        //(2) 어댑터 필수 구현 메서드 - 어댑터가 재사용될 때 자동 호출
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            Customer item = items.get(position);
            viewHolder.setItem(item); //기존 뷰 객체를 사용하되 데이터만 교체
        }

        @Override
        //(2) 어댑터 필수 구현 메서드 - 어댑터에서 관리하는 아이템의 개수 반환
        public int getItemCount() {
            return items.size();
        }

        //(3) 아이템 관련 메서드 정의
        public void addItem(Customer item) {
            items.add(item);
        }

        //(3) 아이템 관련 메서드 정의
        public void setItems(ArrayList<Customer> items) {
            this.items = items;
        }

        //(3) 아이템 관련 메서드 정의
        public Customer getItem(int position) {
            return items.get(position);
        }

        //(3) 아이템 관련 메서드 정의
        public void setItem(int position, Customer item) {
            items.set(position, item);
        }

        //(1) ViewHolder 클래스를 static으로 정의
        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            TextView textView2;
            TextView textView3;

            //생성자에 뷰 객체가 전달 + (4-2) 뷰홀더 객체에 리스너를 파라미터로 전달
            public ViewHolder(View itemView) {
                super(itemView);

                textView = itemView.findViewById(R.id.textView); //뷰 객체 안에 있는 텍스트뷰 참조
                textView2 = itemView.findViewById(R.id.textView2);
                textView3 = itemView.findViewById(R.id.textView3);
            }

            //뷰홀더에 있는 뷰 객체의 데이터를 다른 것으로 보이도록 하는 메서드
            public void setItem(Customer item) {
                textView.setText(item.getName());
                textView2.setText(item.getBirth());
                textView3.setText(item.getMobile());
            }

        }
}
