package com.example.demo.Services;

import com.example.demo.Data.ProductRepository;
import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(long id) {//TESTED
        try {
            return productRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product save(String name,String category,double sellPrice,double buyPrice,double stock){//TESTED
        Product newProduct = new Product(name,category,sellPrice,buyPrice,stock);
        try {
          return productRepository.save(newProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteById(long productId) { //TESTED
        try {
            productRepository.deleteById(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addStockToProductById(long productId, double stockToAdd) { //TESTED
        Product updateProduct = productRepository.findById(productId);
        try {
            updateProduct.setStock(updateProduct.getStock()+stockToAdd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        productRepository.save(updateProduct);
    }


    public List<Product> findAll() {//TESTED
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product productWithMostSells() { //TESTED
        List<Product> products = productRepository.findAll();
        Optional<Product> maxProduct = products.stream()
                .max(Comparator.comparingDouble(Product::getStockSold));
        return maxProduct.orElse(null);
    }

    public Product getMostExpensiveProduct() { //TESTED
        List<Product> products = productRepository.findAll();
        Optional<Product> mostExpensiveProduct = products.stream().max(Comparator.comparingDouble(Product::getSellPrice));
        return mostExpensiveProduct.orElse(null);
    }


}
