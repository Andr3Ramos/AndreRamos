package com.example.demo.Services;

import com.example.demo.Data.ClientRepository;
import com.example.demo.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() { //TESTED
        return clientRepository.findAll();
    }

    public Client save(String name){ //TESTED
        Client newClient = new Client();
        newClient.setName(name);
        clientRepository.save(newClient);
        return newClient;
           }

    public Client findById(long id) { //TESTED
       return  clientRepository.findById(id);
    }
}
