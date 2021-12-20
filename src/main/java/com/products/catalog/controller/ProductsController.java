package com.products.catalog.controller;

import com.products.catalog.model.Product;
import com.products.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping(value = "/{sku}")
    public String findById(@PathVariable("sku") String sku){
        return sku;
    }
}
