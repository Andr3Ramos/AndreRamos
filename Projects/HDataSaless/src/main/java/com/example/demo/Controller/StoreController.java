package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import com.example.demo.Services.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/store")
public class StoreController {

    StoreService storeService;

    public StoreController(StoreService storeService) {
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


    @PutMapping(path ="/add-product/{storeId}/{productId}")
    public ResponseEntity<String> addProductToStore(@PathVariable long productId, @PathVariable long storeId){
       storeService.addProductToStore(productId,storeId);
       return ResponseEntity.ok("Product ID:"+ productId + " Added Successfully to Store " + storeId);
       }


    //Get the products of a specific store

    @RequestMapping(path = "{storeId}/product")
    public List<Product> showStoreProducts(@PathVariable long storeId){
        return storeService.showStoreProducts(storeId);


    }
    // Add a product to a specific store

    //Get the store with the most stock sold WORKING BUT NOT DISPLAYING CORRECT

    // Falta resolver a Sale para depois voltar aqui <------------------------------------------------
    @GetMapping("/most-stock-sold")
    public ResponseEntity<StoreService> getStoreWithMostStockSold() {

         storeService.getStoreWithMostStockSold();
         return ResponseEntity.ok(storeService);
    }

    //Get Store with the most sales :: NOT WORKING
    @GetMapping("/most-sales")
    public ResponseEntity<Store> getStoreWithMostSales() {
        Store getStoreWithMostSales = storeService.getStoreWithMostSales();
        return ResponseEntity.ok(getStoreWithMostSales);
    }
}
