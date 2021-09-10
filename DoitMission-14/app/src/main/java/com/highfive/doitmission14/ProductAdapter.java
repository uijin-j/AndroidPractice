package com.highfive.doitmission14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
                                implements OnProductItemClickListener {
    ArrayList<Product> items = new ArrayList<Product>(); //어댑터에서 관리하는 아이템 리스트

    OnProductItemClickListener listener;

    @NonNull
    @Override
    //(2) 어댑터 필수 구현 메서드 - 어댑터가 만들어질 때 자동 호출
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()); //인플레이터 참조
        View itemView = inflater.inflate(R.layout.product_item, viewGroup, false); //각 아이템을 위해 정의한 XML 레이아웃을 이용해 뷰 객체 생성

        return new ViewHolder(itemView, this); //뷰 객체를 새로운 뷰홀더 객체에 담아서 반환
    } //(참고) int viewType은 각 아이템을 위한 뷰를 여러 가지로 나누어 보여주고 싶을 때 사용

    @Override
    //(2) 어댑터 필수 구현 메서드 - 어댑터가 재사용될 때 자동 호출
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Product item = items.get(position);
        viewHolder.setItem(item); //기존 뷰 객체를 사용하되 데이터만 교체
    }

    @Override
    //(2) 어댑터 필수 구현 메서드 - 어댑터에서 관리하는 아이템의 개수 반환
    public int getItemCount() {
        return items.size();
    }

    //(3) 아이템 관련 메서드 정의
    public void addItem(Product item) {
        items.add(item);
    }

    //(3) 아이템 관련 메서드 정의
    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    //(3) 아이템 관련 메서드 정의
    public Product getItem(int position) {
        return items.get(position);
    }

    //(3) 아이템 관련 메서드 정의
    public void setItem(int position, Product item) {
        items.set(position, item);
    }

    //(4-3) 외부에서 리스너를 설정할 수 있도록 하는 메서드
    public void setOnItemClickListener(OnProductItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    //(4-3) 뷰홀더 클래스 안에서 뷰가 클릭되었을 때 호출되는 메서드
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position); //외부에서 설정된 메서드 호출
        }
    }

    //(1) ViewHolder 클래스를 static으로 정의
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;

        //생성자에 뷰 객체가 전달 + (4-2) 뷰홀더 객체에 리스너를 파라미터로 전달
        public ViewHolder(View itemView, final OnProductItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView); //뷰 객체 안에 있는 텍스트뷰 참조
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);

            //아이템 뷰에 OnClickListener 설정
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition(); //이 뷰홀더에 표시할 아이템의 인덱스 정보 반환

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position); //아이템 뷰 클릭 시 파라미터로 받은 리스너 호출
                    }
                }
            });
        }

        //뷰홀더에 있는 뷰 객체의 데이터를 다른 것으로 보이도록 하는 메서드
        public void setItem(Product item) {
            imageView.setImageResource(item.getImage());
            textView.setText(item.getName());
            textView2.setText(item.getPrice());
            textView3.setText(item.getInfo());
        }

    }
}
