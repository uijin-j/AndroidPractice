package com.highfive.doitmission14;

public class Product {
    int image; //상품 이미지
    String name; //상품명
    String price; //상품 가격
    String info; //상품 설명

    public Product(int image, String name, String price, String info) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public Product(String name, String price, String info) {
        this.image = R.drawable.ic_launcher_foreground;
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
