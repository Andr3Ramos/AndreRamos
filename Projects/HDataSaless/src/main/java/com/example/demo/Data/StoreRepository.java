package com.example.demo.Data;

import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store,Long> {


    List<Store> findAll();

    Store findById(long id);
            }
