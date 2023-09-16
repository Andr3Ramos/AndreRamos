package com.example.demo;

import com.example.demo.Data.ClientRepository;
import com.example.demo.Data.ProductRepository;
import com.example.demo.Model.Client;
import com.example.demo.Model.Product;
import com.example.demo.Services.ClientService;
import com.example.demo.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientTest {
    @Autowired
    ClientService clientService;
    @Autowired
    ClientRepository clientRepository;


    @Test
    void findAll(){

        Client client = clientService.save("Test");
        Client secondClient = clientService.save("Test1");

       List<Client> clientList = clientService.findAll();
       int expectedNumOfProducts = 2;

       assertNotNull(clientList);
       assertEquals(expectedNumOfProducts, clientList.size());
    }

    @Test

    void save(){
        Client client = clientService.save("Test");

        assertNotNull(client);
        assertEquals("Test", client.getName());

    }

    @Test
    void findById(){
        Client client = clientService.save("Test");
        int clientId =1;
        client.setId(clientId);
        Client findClientById = clientService.findById(1);

        assertNotNull(findClientById);
        assertEquals(client.getId() , findClientById.getId());

    }





}
