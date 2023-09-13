package com.example.demo.Services;

import com.example.demo.Data.ProductRepository;
import com.example.demo.Data.StoreRepository;
import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    StoreRepository storeRepository;

    ProductRepository productRepository;


    public StoreService(StoreRepository storeRepository, ProductRepository productRepository) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    public List<Store> findAll() {
       return storeRepository.findAll();
         }

    public Store findById(long id) {
        try {
            return storeRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String name, Integer nif, String address) {
        Store store =new Store(name,nif,address);
        try {
            storeRepository.save(store);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long storeId) {
        try {
            storeRepository.deleteById(storeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void addProductToStore(long productId, long storeId) {

        Product productRepositoryById = productRepository.findById(productId);
        Store storeRepositoryById = storeRepository.findById(storeId);
        storeRepositoryById.addProduct(productRepositoryById);

        try {
            storeRepository.save(storeRepositoryById);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> showStoreProducts(long storeId) {
        Store store = storeRepository.findById(storeId);
        List<Product> products = store.getProductList();
        return products;
    }

    public Store getStoreWithMostStockSold() { //TEST
        List<Store> stores = storeRepository.findAll();
      
         Optional<Store> store = stores.stream().max(Comparator.comparingDouble(Store::getTotalStockSold));
         Store storeWithTheMostStockSold = store.orElse(null);
                 
         return storeWithTheMostStockSold;
    }


    public Store getStoreWithMostSales() { //TEST
        List<Store> stores = storeRepository.findAll();

        Optional<Store> store = stores.stream().max(Comparator.comparingDouble(Store::getTotalSales));
        Store storeWithMostSales = store.orElse(null);

        return storeWithMostSales;

    }
}
