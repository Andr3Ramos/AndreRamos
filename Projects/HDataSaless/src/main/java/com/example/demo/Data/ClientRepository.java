package com.example.demo.Data;

import com.example.demo.Model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {


    List<Client> findAll();

    Client findById(long id);



}
