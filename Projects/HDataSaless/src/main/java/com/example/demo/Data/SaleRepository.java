package com.example.demo.Data;

import com.example.demo.Model.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale,Long> {

    List<Sale> findAll();

    Sale findById(long id);


}
