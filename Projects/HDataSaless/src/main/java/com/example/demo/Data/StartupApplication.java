package com.example.demo.Data;

import com.example.demo.Model.Client;
import com.example.demo.Model.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupApplication implements ApplicationListener<ApplicationReadyEvent> {


    private final ClientRepository clientRepository;

    private final StoreRepository storeRepository;

    private final SaleRepository saleRepository;

    private final ProductRepository productRepository;

    public StartupApplication(ClientRepository clientRepository, StoreRepository storeRepository, SaleRepository saleRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.storeRepository = storeRepository;
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Client> clients = this.clientRepository.findAll();
        clients.forEach(System.out::println);
       // Iterable<Store> stores = this.storeRepository.findAll();
       // stores.forEach(System.out::println);
       // Iterable<Sale> sales = this.saleRepository.findAll();
       // sales.forEach(System.out::println);
       //Iterable<Product> products = this.productRepository.findAll();
      //  products.forEach(System.out::println);

    }
}
