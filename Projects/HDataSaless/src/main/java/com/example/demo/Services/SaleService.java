package com.example.demo.Services;

import com.example.demo.Data.ClientRepository;
import com.example.demo.Data.ProductRepository;
import com.example.demo.Data.SaleRepository;
import com.example.demo.Data.StoreRepository;
import com.example.demo.Model.*;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    private final ClientRepository clientRepository;

    private final StoreRepository storeRepository;
    
    private final ProductRepository productRepository;


    public SaleService(SaleRepository saleRepository, ClientRepository clientRepository, StoreRepository storeRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.clientRepository = clientRepository;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }


    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale findById(long id) {
        return saleRepository.findById(id);
    }



    //Create a Sale
       public void addSale(long clientId, long storeId, List<SaleItem> saleItems) { //TEST
            Client client = clientRepository.findById(clientId);
            Store store = storeRepository.findById(storeId);
            double totalPrice = 0.0;
            List<SaleItem> saleItemList = new ArrayList<>();
            for (SaleItem saleItem : saleItems ) {
               SaleItem setSaleItem = new SaleItem(saleItem.getProducts(),saleItem.getQuantitySold());
                    totalPrice += setSaleItem.getTotalCost();
            }
           Sale sale = new Sale(client,store,saleItems,totalPrice);

            saleRepository.save(sale);
             }



    //Get the sale by a specific client
    public List<Sale> getSalesByClientId(long clientId) { //TEST
        List<Sale> salesByClient = new ArrayList<>();

        for (Sale sale : saleRepository.findAll()) {
            if (sale.getClient().getId() == clientId) {
                salesByClient.add(sale);
            }
        }

        return salesByClient;
    }

    //Get the client with the most buys
    public Optional<Client> getClientWithMostStockSold() {  //TEST
        Map<Long, Integer> clientStockSoldMap = new HashMap<>();

        for (Sale sale : saleRepository.findAll()) {
            Client client = sale.getClient();
            int stockSold = sale.getItems().stream()
                    .mapToInt(SaleItem::getQuantitySold)
                    .sum();

            if (clientStockSoldMap.containsKey(client.getId())) {
                clientStockSoldMap.put(client.getId(), clientStockSoldMap.get(client.getId()) + stockSold);
            } else {
                clientStockSoldMap.put(client.getId(), stockSold);
            }
        }

        Long clientIdWithMostStockSold = Collections.max(clientStockSoldMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        return clientRepository.findById(clientIdWithMostStockSold);
    }


    //Get the client with the most purchases
    public Product getProductWithMostPurchases() { //TEST
        Map<Long, Integer> productPurchaseCount = new HashMap<>();

        for (Sale sale : saleRepository.findAll()) {
            for (SaleItem saleItem : sale.getItems()) {
                long productId = saleItem.getProducts().getId();
                productPurchaseCount.put(productId, productPurchaseCount.getOrDefault(productId, 0) + 1);
            }
        }

        long mostPurchasedProductId = Collections.max(productPurchaseCount.entrySet(), Map.Entry.comparingByValue()).getKey();

        return productRepository.findById(mostPurchasedProductId);
    }

}


