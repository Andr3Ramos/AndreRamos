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

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(String name){
        Client newClient = new Client();
        newClient.setName(name);
        clientRepository.save(newClient);
           }

    public Client findById(long id) {
       return  clientRepository.findById(id);
    }
}
