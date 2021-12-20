package com.products.catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog/products")
public class ProductsController {

    @GetMapping
    public List<String> getAll(){
        List<String> products = new ArrayList<>();
        products.add("asd");
        products.add("123");
        return products;
    }

    @GetMapping(value = "/{sku}")
    public String findById(@PathVariable("sku") String sku){

        return sku;
    }
}
