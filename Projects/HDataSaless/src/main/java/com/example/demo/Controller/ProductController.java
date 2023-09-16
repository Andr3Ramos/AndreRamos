package com.example.demo.Controller;
import com.example.demo.Model.Product;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.SaleService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {


    SaleService saleService;

    ProductService productService;


    public ProductController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    //List All Products
    @GetMapping
    public List<Product> listProduct() {
        return productService.findAll();
    }

    //Get Products by Id
    @RequestMapping(path = "/{id}")
    public Product getProductById(@PathVariable long id) {
       return productService.findById(id);
    }

    //Create Product
    @PostMapping(path = "/add")
    public ResponseEntity<String> createProduct(
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam double sellPrice,
            @RequestParam double buyPrice,
            @RequestParam double stock) {

        productService.save(name, category, sellPrice, buyPrice, stock);

        return ResponseEntity.ok("Product Created Sucefully");
    }

    //Delete Product
    @DeleteMapping(path = "/delete/{productId}")
    public ResponseEntity<String> removeProduct(@PathVariable long productId) {
        productService.deleteById(productId);

        return ResponseEntity.ok("Product Removed Sucefully");
    }


    //Add Stock to a product
    @PutMapping(path = "/add-stock/{productId}")
    @Transactional
    public ResponseEntity<String> addStockToProduct(
            @PathVariable long productId,
            @RequestParam double stockToAdd) {
        productService.addStockToProductById(productId, stockToAdd);
        return ResponseEntity.ok("Stock added to product id number ");
    }



    //Get the product with the most purchases
    @GetMapping("/most-purchases") //TEST
    public Product getProductWithMostPurchases() {
    return  productService.productWithMostSells();
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
}