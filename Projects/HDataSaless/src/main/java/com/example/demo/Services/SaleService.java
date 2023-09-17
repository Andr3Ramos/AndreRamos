package com.example.demo.Services;

import com.example.demo.Data.ClientRepository;
import com.example.demo.Data.ProductRepository;
import com.example.demo.Data.SaleRepository;
import com.example.demo.Data.StoreRepository;
import com.example.demo.Model.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class SaleService {


    SaleRepository saleRepository;

    ClientRepository clientRepository;

    StoreRepository storeRepository;
    ProductRepository productRepository;


    public SaleService(SaleRepository saleRepository, ClientRepository clientRepository, StoreRepository storeRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.clientRepository = clientRepository;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }


    public SaleService() {
    }


    @Transactional
    public Sale saveSale(Client client, Store store, List<SaleItem> saleItems) {
        Sale sale = new Sale(client, store, saleItems);
        try {
            return saleRepository.save(sale);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale findById(long id) {
        return saleRepository.findById(id);
    }


    public Sale addSale(Long clientId, Long storeId, List<Product> products) {
        // Create a new Sale instance
        Sale sale = new Sale();
        Store store = storeRepository.findById(storeId).orElse(null);
        Client client = clientRepository.findById(clientId).orElse(null);
        // Set client and store
        sale.setClient(client);
        sale.setStore(store);

        // Create SaleItem instances and associate them with the Sale
        List<SaleItem> saleItems = new ArrayList<>();

        for (Product product : products) {
            SaleItem saleItem = new SaleItem();
            saleItem.setSale(sale);
            saleItem.setProduct(product);
            saleItem.setQuantitySold(product.getStockSold());
            saleItem.setTotalCost(product.getSellPrice() * product.getStockSold());

            // Update product's stock
            double newStock = product.getStock() - product.getStockSold();
            product.setStock(newStock);
            saleItems.add(saleItem);
            // Update the product in the database
            productRepository.save(product);
        }

        // Set the SaleItems in the Sale
        sale.setItems(saleItems);
        saleRepository.save(sale);
        return sale;
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
  /*  public Optional<Client> getClientWithMostStockSold() {  //TEST
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
    }*/
}




