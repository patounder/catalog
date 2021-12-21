package com.products.catalog.service;

import com.products.catalog.model.Product;
import com.products.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Optional<Product> findBySku(String sku){
        return this.productRepository.findById(sku);
    }

    public Product create(Product product){
        return this.productRepository.save(product);
    }

    public Product update(Product product){
        Optional<Product> existingProduct = this.productRepository.findById(product.getSku());

        if(existingProduct.isEmpty()){
            throw new IllegalArgumentException();
        }

        existingProduct.get().setName(product.getName());
        existingProduct.get().setBrand(product.getBrand());
        existingProduct.get().setSize(product.getSize());
        existingProduct.get().setPrice(product.getPrice());
        existingProduct.get().setImages(product.getImages());
        return this.productRepository.save(product);
    }

    public void deleteBySku(String sku){
        Optional<Product> existingProduct = this.productRepository.findById(sku);

        if(existingProduct.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.productRepository.deleteById(sku);
    }

}
