package com.example.demo;

import com.example.demo.Data.SaleRepository;
import com.example.demo.Model.Client;
import com.example.demo.Model.Product;
import com.example.demo.Model.Sale;
import com.example.demo.Model.Store;
import com.example.demo.Services.ClientService;
import com.example.demo.Services.SaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SaleTest {
    @Autowired
    SaleService saleService;
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ClientService clientService;

    @Test
    void findAll(){
        Client client = clientService.save("Test");
        Product product = new Product("TestName","TestCategory",10,5,30);
        Product product1 = new Product("TestName","TestCategory",10,5,30);
        Store store = new Store("TestStore",123,"TestAddress");
        long clientId = client.getId();
        long storeId = store.getId();
       List<Product> productList = new ArrayList<>();
       productList.add(product);
       productList.add(product1);



        Sale sale = saleService.addSale(clientId,storeId,productList);

        assertNotNull(sale);

    }
}
