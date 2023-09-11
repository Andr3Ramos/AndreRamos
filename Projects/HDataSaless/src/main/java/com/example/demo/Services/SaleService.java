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

    private List<Sale> saleList;
//    private List<SaleItem> saleItemList;

    private final SaleRepository saleRepository;


    public SaleService(SaleRepository saleRepository, ProductRepository productRepository, ClientRepository clientRepository, StoreRepository storeRepository) {

        this.saleRepository = saleRepository;

        this.saleList = new ArrayList<>();


    }

    //Create a Sale
  /* public void makeSale(long clientId, long storeId, List<Integer> productIds) {
        Client client = clientRepository.findClientById(clientId);
        Store store = storeRepository.findStoreById(storeId);
        double totalPrice = 0.0;
        List<SaleItem> saleItemList = new ArrayList<>();
        for (Integer productId : productIds) {
            Product product = productRepository.findProductById(productId);
            saleItemList.add(new SaleItem(product, 1)); // Assuming quantity is 1
            totalPrice += product.getSellPrice();
        }
        Sale sale = new Sale(client, store, totalPrice, saleItemList);
        saleRepository.save(sale);
         }



    //Get the sale by a specific client
    public List<Sale> getSalesByClientId(long clientId) {
        List<Sale> clientSales = new ArrayList<>();
        for (Sale sale : saleList) {
            if (sale.getClient().getId() == clientId) {
                clientSales.add(sale);
            }
        }
        return clientSales;
    }

    //Get the client with the most buys
    public Client getClientWithMostBuys() {
        Map<Client, Integer> clientPurchaseCounts = new HashMap<>();

        for (Sale sale : saleList) {
            Client client = sale.getClient();
            clientPurchaseCounts.put(client, clientPurchaseCounts.getOrDefault(client, 0) + 1);
        }

        Client clientWithMostBuys = null;
        int maxBuys = 0;

        for (Map.Entry<Client, Integer> entry : clientPurchaseCounts.entrySet()) {
            if (entry.getValue() > maxBuys) {
                maxBuys = entry.getValue();
                clientWithMostBuys = entry.getKey();
            }
        }

        return clientWithMostBuys;
    }

    //Get the client with the most purchases
  /*  public Product getProductWithMostPurchases() {
        Map<Long, Integer> productPurchaseCount = new HashMap<>();

        for (Sale sale : saleList) {
            for (SaleItem saleItem : sale.getItems()) {
                long productId = saleItem.getProducts().getId();
                productPurchaseCount.put(productId, productPurchaseCount.getOrDefault(productId, 0) + 1);
            }
        }

        long mostPurchasedProductId = Collections.max(productPurchaseCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        return productServicerep.getProductById(mostPurchasedProductId);
    }
*/
}


