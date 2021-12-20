package com.products.catalog.models;

import java.util.List;

public class Product {

    private String sku;
    private String name;
    private String brand;
    private String size;
    private float price;
    private String principalImage;
    private List<String> otherImages;

    public Product(){
        super();
    }

    public Product(String sku, String name, String brand, String size, float price, String principalImage,
                   List<String> otherImages) {
        super();
        this.sku = sku;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.principalImage = principalImage;
        this.otherImages = otherImages;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPrincipalImage() {
        return principalImage;
    }

    public void setPrincipalImage(String principalImage) {
        this.principalImage = principalImage;
    }

    public List<String> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", principalImage='" + principalImage + '\'' +
                ", otherImages=" + otherImages +
                '}';
    }
}
