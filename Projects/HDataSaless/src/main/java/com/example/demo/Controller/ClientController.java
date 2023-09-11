package com.example.demo.Controller;

import com.example.demo.Data.ClientRepository;
import com.example.demo.Model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Get List of Clients
    @GetMapping
    public List<Client> getClients() {
            return clientRepository.findAll();
    }

    //Get Client By Id
    @RequestMapping(path = "/{id}")
    public Client getClientById(@PathVariable long id){
      return clientRepository.findClientById(id);
    }

    //Adding a Client
    @PostMapping(path = "/add")
    public ResponseEntity<Client> createClient(@RequestParam String name) {
        Client newClient = new Client(name);
        clientRepository.save(newClient);
        return ResponseEntity.ok(newClient);
    }
}



