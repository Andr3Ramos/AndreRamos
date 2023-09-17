package com.example.demo.Data;

import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store,Long> {


    List<Store> findAll();

            }
