package com.products.catalog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private String sku;
    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private String size;
    @Column
    private float price;

    @OneToMany(targetEntity = ProductImage.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "product_sku", referencedColumnName = "sku")
    private Set<ProductImage> images;

    public Product(){
        super();
    }

    public Product(String sku, String name, String brand, String size, Float price, Set<ProductImage> images) {
        super();
        this.sku = sku;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.images = images;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<ProductImage> getImages() {
        return images;
    }

    public void setImages(Set<ProductImage> images) {
        //this.images.addAll(images);

        if(this.images == null){
            this.images = images;
        } else {
            this.images.retainAll(images);
            this.images.addAll(images);
        }
    }
}
