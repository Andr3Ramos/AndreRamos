package com.example.demo;

import com.example.demo.Data.*;
import com.example.demo.Model.*;
import com.example.demo.Services.ClientService;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.SaleService;
import com.example.demo.Services.StoreService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SaleTest {
    @Autowired
    SaleService saleService;
    @Autowired
    ProductService productService;
    @Autowired
    StoreService storeService;
    @Autowired
    ClientService clientService;
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    SaleItemRepository saleItemRepository;


    @Test
    void findAll(){

        SaleService saleService = new SaleService(saleRepository, clientRepository, storeRepository, productRepository);
        Product product1 = productService.save("banana", "fruta", 11, 12, 13);
        Product product2 = productService.save("Morango", "fruta", 11, 12, 13);

        Store store = storeService.save("TestStore", 123, "TestAddress");
        Client client = clientService.save("TestClient");
        SaleItem saleItem = new SaleItem(product1,5);
        SaleItem saleItem1 = new SaleItem(product2 , 10);
        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem1);

        List<SaleItem> saleItemList=new ArrayList<>();
        saleItemList.add(saleItem);
        saleItemList.add(saleItem1);

        Sale sale = saleService.saveSale(client,store,saleItemList);
        saleItemList.get(0).setSale(sale);
        saleItemList.get(1).setSale(sale);
        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem1);

        List<Sale> allSales = saleService.findAll();

           for (SaleItem item : saleItemList) {
            assertNotNull(item);
        }
        assertNotNull(allSales);
        assertNotNull(sale);
        assertEquals(product1.getId(),sale.getItems().get(0).getId());
        assertEquals(product2.getId(),sale.getItems().get(1).getId());
    }

    @Test
    void getClientsById(){
        SaleService saleService = new SaleService(saleRepository, clientRepository, storeRepository, productRepository);
        Product product1 = productService.save("banana", "fruta", 11, 12, 13);
        Product product2 = productService.save("Morango", "fruta", 11, 12, 13);

        Store store = storeService.save("TestStore", 123, "TestAddress");
        Client client = clientService.save("TestClient");
        SaleItem saleItem = new SaleItem(product1,5);
        SaleItem saleItem1 = new SaleItem(product2 , 10);
        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem1);

        List<SaleItem> saleItemList=new ArrayList<>();
        saleItemList.add(saleItem);
        saleItemList.add(saleItem1);

        Sale sale = saleService.saveSale(client,store,saleItemList);
        saleItemList.get(0).setSale(sale);
        saleItemList.get(1).setSale(sale);
        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem1);
        long clientId = client.getId();
        List<Sale> salesByClient = saleService.getSalesByClientId(clientId);

        System.out.println(salesByClient);

        assertNotNull(salesByClient);
        assertEquals(1, salesByClient.size());
    }

    @Test
    void testClientWithMostBuys(){
        SaleService saleService = new SaleService(saleRepository, clientRepository, storeRepository, productRepository);
        Product product1 = productService.save("banana", "fruta", 11, 12, 13);
        Product product2 = productService.save("Morango", "fruta", 11, 12, 13);

        Store store = storeService.save("TestStore", 123, "TestAddress");
        Client client = clientService.save("TestClient");
        SaleItem saleItem = new SaleItem(product1,5);
        SaleItem saleItem1 = new SaleItem(product2 , 10);
        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem1);

        List<SaleItem> saleItemList=new ArrayList<>();
        saleItemList.add(saleItem);
        saleItemList.add(saleItem1);

        Sale sale = saleService.saveSale(client,store,saleItemList);
        saleItemList.get(0).setSale(sale);
        saleItemList.get(1).setSale(sale);
        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem1);

        Client clientWithMostBuys = saleService.getClientWithMostStockSold();
        clientRepository.save(clientWithMostBuys);

        assertNotNull(clientWithMostBuys);




    }
}
