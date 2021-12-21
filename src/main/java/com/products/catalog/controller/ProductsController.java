package com.products.catalog.controller;

import com.products.catalog.model.Product;
import com.products.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping(value = "/{sku}")
    public Product findById(@PathVariable("sku") String sku){
        return this.productService.findBySku(sku).get();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return this.productService.create(product);
    }
}
