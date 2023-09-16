package com.example.demo;

import com.example.demo.Data.StoreRepository;
import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.StoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StoreTest {
    @Autowired
    StoreService storeService;
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ProductService productService;
@Test
    void findAll(){
    Store store = storeService.save("test", 123,"Address");
    Store store1 = storeService.save("test1", 1234,"Address");
    Store store3 = storeService.save("test3", 12356,"Address");

    List<Store> storeList = storeService.findAll();

    int numOfStores = 3;

    assertNotNull(storeList);
    assertEquals(numOfStores , storeList.size());

}

@Test
void findById(){
    Store store = storeService.save("test", 123,"Address");
    Store store1 = storeService.save("test1", 1234,"Address");
    Store store2 = storeService.save("test3", 12356,"Address");
    store.setId(1);
    store1.setId(2);
    store2.setId(3);
    int idStore = 3;

    assertNotNull(store);
    assertNotNull(store1);
    assertNotNull(store2);
    assertEquals(idStore , store2.getId());
}
@Test
    void saveStore(){
    Store store = storeService.save("test", 123,"Address");
    Store store1 = storeService.save("test1", 1234,"Address");
    Store store2 = storeService.save("test3", 12356,"Address");


    assertNotNull(store);
    assertNotNull(store1);
    assertNotNull(store2);
    assertEquals("test" , store.getName());
    assertEquals(123 , store.getNif());
    assertEquals("Address" , store.getAddress());
}


@Test
    void deleteById(){
    Store store = storeService.save("test", 123,"Address");
    Store store1 = storeService.save("test1", 1234,"Address");
    Store store2 = storeService.save("test3", 12356,"Address");


    storeService.deleteById(1);
    storeService.deleteById(2);
    storeService.deleteById(3);

    assertNull(storeRepository.findById(1));
    assertNull(storeRepository.findById(2));
    assertNull(storeRepository.findById(3));
}

@Test
void addProductToStore(){
    Product product = productService.save("TestProduct","product",10,5,20);
    Product product2 = productService.save("TestProduct2","product2",100,50,200);
    Store store = storeService.save("TestStore" , 123,"abc");

    store.addProduct(product);
    store.addProduct(product2);



    assertTrue(store.getProductList().contains(product));
    assertTrue(store.getProductList().contains(product2));


}

@Test
    void showStoreProducts(){


    Product product1 = productService.save("TestProduct1", "product1", 10, 5, 20);
    Product product2 = productService.save("TestProduct2", "product2", 100, 50, 200);

    Store store = storeService.save("TestStore", 123, "abc");
    store.addProduct(product1);
    store.addProduct(product2);
    storeRepository.save(store);

    long storeId = store.getId();

    Store receivedStore = storeRepository.findById(storeId);

    List<Product> productList = storeService.showStoreProducts(receivedStore.getId());

    // Assert that the productList contains the expected products
    assertTrue(productList.contains(product1));
    assertTrue(productList.contains(product2));
}

@Test
    void getStoreWithMoreStockSold(){


}


}
