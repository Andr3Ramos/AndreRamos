package com.example.demo.Controller;
import com.example.demo.Data.ProductRepository;
import com.example.demo.Model.Product;
import com.example.demo.Services.SaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    ProductRepository productRepository;
    SaleService saleService;

    @Autowired
    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }


    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //List All Products
    @GetMapping
    public List<Product> listProduct() {

        return productRepository.findAll();
    }

    //Get Products by Id
    @RequestMapping(path = "/{id}")
    public Product getProductById(@PathVariable long id) {
        return productRepository.findProductById(id);
    }

    //Create Product
    @PostMapping(path = "/add")
    public ResponseEntity<String> createProduct(
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam double sellPrice,
            @RequestParam double buyPrice,
            @RequestParam double stock) {
        productRepository.saveProduct(name, category, sellPrice, buyPrice, stock);
        return ResponseEntity.ok("Product Created Sucefully");
    }

    //Delete Product
    @DeleteMapping(path = "/delete/{productId}")
    @Transactional
    public ResponseEntity<String> removeProduct(@PathVariable long productId) {
        productRepository.removeProductById(productId);
        return ResponseEntity.ok("Product Removed Sucefully");
    }


    //Add Stock to a product
    @PutMapping(path = "/{productId}/add-stock")
    @Transactional
    public ResponseEntity<String> addStockToProduct(
            @PathVariable long productId,
            @RequestParam double stockToAdd) {
        productRepository.addStockToProductById(productId, stockToAdd);
        return ResponseEntity.ok("Stock added to product id number "+ productId);
    }


/*
    //Get the product with the most purchases
    @GetMapping("/most-purchases")
    public Product getProductWithMostPurchases() {
    return  productRepository.productWithMostSells();
       }


    //Get Most expensive product
     @GetMapping("/most-expensive")
     public ResponseEntity<Product> getMostExpensiveProduct() {
        Product mostExpensiveProduct = productService.getMostExpensiveProduct();

        if (mostExpensiveProduct != null) {
            return ResponseEntity.ok(mostExpensiveProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
*/
}