package com.example.demo;

import com.example.demo.Data.StoreRepository;
import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.StoreService;
import org.junit.jupiter.api.*;
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
    Store store2 = storeService.save("test3", 12356,"Address");

    long countCreatedStores = 3;

    List<Store> storeList = storeService.findAll();

    assertNotNull(storeList);
    assertEquals(countCreatedStores , storeList.size());

}

@Test
void findById(){


    Store store = storeService.save("test", 123,"Address");
    Store store1 = storeService.save("test1", 1234,"Address");
    Store store2 = storeService.save("test3", 12356,"Address");
    Long storeId = store1.getId();

     Store storeById = storeRepository.findById(storeId).orElse(null);

    assertEquals(storeId ,storeById.getId());

}
@Test
    void saveStore(){
    Store store = storeService.save("test", 123,"Address");

    assertEquals("test" , store.getName());
    assertEquals(123 , store.getNif());
    assertEquals("Address" , store.getAddress());
}


@Test
    void deleteById(){
    Store store = storeService.save("test", 123,"Address");
    long storeId = store.getId();
    storeService.deleteById(storeId);

    assertNull(storeRepository.findById(storeId).orElse(null));

}

@Test
void addProductToStore(){
    Store store = storeService.save("test", 123,"Address");
    Product product = productService.save("TestProduct","product",10,5,20);

    store.addProduct(product);
    assertTrue(store.getProductList().contains(product));

}

@Test
    void showStoreProducts(){
    //Create Products
    Product product1 = productService.save("TestProduct1", "product1", 10, 5, 20);
    Product product2 = productService.save("TestProduct2", "product2", 100, 50, 200);
    //Create Store
    Store store = storeService.save("TestStore", 123, "abc");
    //Get store ID
    long storeId = store.getId();
    //Add Products to the Store
    store.addProduct(product1);
    store.addProduct(product2);
    //Saving Store
    storeRepository.save(store);

    //Getting the store from the repository
    Store receivedStore = storeRepository.findById(storeId).orElse(null);

    //Call the method
    assert receivedStore != null;
    List<Product> productList = storeService.showStoreProducts(receivedStore.getId());

    //Passing the products to a new list to test
    List<Product> expectedProductList = new ArrayList<>(store.getProductList());

    for (Product product : expectedProductList) {
        assertNotNull(product);
    }

    // Assert that the productList contains the expected products
    assertNotNull(expectedProductList);
    assertEquals(expectedProductList.size() , productList.size());//This test is passing
    assertEquals(expectedProductList.get(0).getName(),productList.get(0).getName());
    assertEquals(expectedProductList.get(0).getStock(),productList.get(0).getStock());
    assertEquals(expectedProductList.get(0).getSellPrice(),productList.get(0).getSellPrice());
    assertEquals(expectedProductList.get(0).getBuyPrice(),productList.get(0).getBuyPrice());
    assertEquals(expectedProductList.get(1).getName(),productList.get(1).getName());
    assertEquals(expectedProductList.get(1).getStock(),productList.get(1).getStock());
    assertEquals(expectedProductList.get(1).getSellPrice(),productList.get(1).getSellPrice());
    assertEquals(expectedProductList.get(1).getBuyPrice(),productList.get(1).getBuyPrice());

}

    @Test
    void getStoreWithMoreStockSold(){

    Store store = storeService.save("TestStore", 123, "abc");
    Store store1 = storeService.save("TestStore1", 321, "abcd");
    store.setTotalStockSold(25);
    store1.setTotalStockSold(30);
    storeRepository.save(store);
    storeRepository.save(store1);
    System.out.println(store1);
    System.out.println(store);
    Store storeWithMostStockSold = storeService.getStoreWithMostStockSold();
    assertNotNull(storeWithMostStockSold);
    assertEquals(store1.getId() ,storeWithMostStockSold.getId() );
}

    @Test
    void getStoreWithMoreSells(){
    Store store = storeService.save("TestStore", 123, "abc");
    Store store1 = storeService.save("TestStore1", 321, "abcd");
    store.setTotalSales(2000);
    store1.setTotalSales(5000);
    storeRepository.save(store);
    storeRepository.save(store1);

    Store storeWithMoreSells = storeService.getStoreWithMostSales();

    assertNotNull(storeWithMoreSells);
    assertEquals(store1.getId(),storeWithMoreSells.getId());
}



}
