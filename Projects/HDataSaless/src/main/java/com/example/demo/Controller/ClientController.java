package com.example.demo.Controller;

import com.example.demo.Data.ClientRepository;
import com.example.demo.Model.Client;
import com.example.demo.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/clients")
public class ClientController {

    private final ClientRepository clientRepository;


    private final ClientService clientService;

    @Autowired
    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    //Get List of Clients
    @GetMapping
    public List<Client> getClients() {
            return clientService.findAll();
    }

    //Get Client By Id
    @RequestMapping(path = "/{id}")
    public Client getClientById(@PathVariable long id){
      return clientService.findById(id);
    }

    //Adding a Client
    @PostMapping(path = "/add")
    public ResponseEntity<String> createClient(@RequestParam String name) {
        clientService.save(name);
       return ResponseEntity.ok("Client Created");
    }
}



