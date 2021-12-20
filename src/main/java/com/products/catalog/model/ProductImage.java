package com.products.catalog.model;

import javax.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean isPrincipal;
    @Column
    private String url;

    public ProductImage(){
        super();
    }

    public ProductImage(boolean isPrincipal, String url) {
        this.isPrincipal = isPrincipal;
        this.url = url;
    }

    public ProductImage(int id, boolean isPrincipal, String url) {
        this.id = id;
        this.isPrincipal = isPrincipal;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrincipal() {
        return isPrincipal;
    }

    public void setPrincipal(boolean principal) {
        isPrincipal = principal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
