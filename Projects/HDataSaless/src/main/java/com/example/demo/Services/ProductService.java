package com.example.demo.Services;

import com.example.demo.Data.ProductRepository;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    List<Product> product;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product findById(long id) {
        try {
            return productRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String name,String category,double sellPrice,double buyPrice,double stock){
        Product newProduct = new Product(name,category,sellPrice,buyPrice,stock);
        try {
            productRepository.save(newProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteById(long productId) {
        try {
            productRepository.deleteById(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addStockToProductById(long productId, double stockToAdd) {
        Product updateProduct = productRepository.findById(productId);
        updateProduct.setStock(updateProduct.getStock()+stockToAdd);
         productRepository.save(updateProduct);
    }


    public List<Product> findAll() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
