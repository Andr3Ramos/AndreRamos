package com.example.demo.Controller;

import com.example.demo.Data.ProductRepository;
import com.example.demo.Data.StoreRepository;
import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import com.example.demo.Services.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/store")
public class StoreController {



    private final ProductRepository productRepository;

    private final StoreRepository storeRepository;

    StoreService storeService;

    public StoreController(ProductRepository productRepository, StoreRepository storeRepository, StoreService storeService) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.storeService = storeService;
    }


    @GetMapping
    public List<Store> listStores(){
        try {
            return storeService.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // Example:
    @RequestMapping(path = "/{id}")
    public Store getClientById(@PathVariable long id){

        try {
            return  storeService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    // Add a store
    @PostMapping(path = "/add")
    public ResponseEntity<String> createStore(
                @RequestParam String name,
                @RequestParam Integer nif,
                @RequestParam String address)
        {

                storeService.save(name,nif,address);

            return  ResponseEntity.ok("Store Created Successfully");
    }

    // Remove a specific store
    @DeleteMapping("/delete/{storeId}")
    public ResponseEntity<String> removeStore(@PathVariable long storeId) {

        storeService.deleteById(storeId);

        return ResponseEntity.ok("Store Deleted Successfully");
    }

/*
    @PutMapping(path ="/add-product/{storeId}/{productId}")
    public ResponseEntity<String> addProductToStore(@PathVariable long productId, @PathVariable long storeId){
        Optional<Store> optionalStore = storeRepository.findById(storeId);
        Product optionalProduct = productRepository.findById(productId);

       if(optionalStore.isPresent() && optionalProduct.equals(productId)){
           Store store = optionalStore.get();
            //store.addProduct(product);
           storeRepository.save(store);
           return ResponseEntity.ok("Product ID:"+ productId + " Added Successfully to Store " + storeId);
       }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store  or Products Not found");
    }

    //Get the products of a specific store
    //needs a query
    @RequestMapping(path = "{storeId}/product")
    public ResponseEntity<List<Product>> showStoreProducts(@PathVariable long storeId){
        Optional<Store> store = storeRepository.findById(storeId);
        if(store==null){
            return ResponseEntity.notFound().build();
        }

       List<Product> products = store.get().getProductList();

        return ResponseEntity.ok(products);

    }
    // Add a product to a specific store

    //Get the store with the most stock sold WORKING BUT NOT DISPLAYING CORRECT

    // Falta resolver a Sale para depois voltar aqui <------------------------------------------------
    @GetMapping("/most-stock-sold")
    public ResponseEntity<Store> getStoreWithMostStockSold() {
        Store storeWithMostStockSold = storeService.getStoreWithMostStockSold();

        if (storeWithMostStockSold != null) {
            return ResponseEntity.ok(storeWithMostStockSold);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Get Store with the most sales :: NOT WORKING
    @GetMapping("/most-sales")
    public ResponseEntity<Store> getStoreWithMostSales() {
        Store storeWithMostSales = storeService.getStoreWithMostSales();

        if (storeWithMostSales != null) {
            return ResponseEntity.ok(storeWithMostSales);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

*/


}
