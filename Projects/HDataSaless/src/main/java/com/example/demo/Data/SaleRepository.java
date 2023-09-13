package com.example.demo.Data;

import com.example.demo.Model.Sale;
import com.example.demo.Model.SaleItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale,Long> {

    List<Sale> findAll();

    Sale findById(long id);


}
