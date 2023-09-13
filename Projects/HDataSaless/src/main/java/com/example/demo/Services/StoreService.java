package com.example.demo.Services;

import com.example.demo.Data.StoreRepository;
import com.example.demo.Model.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public List<Store> findAll() {
       return storeRepository.findAll();
         }

    public Store findById(long id) {
        try {
            return storeRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String name, Integer nif, String address) {
        Store store =new Store(name,nif,address);
        try {
            storeRepository.save(store);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long storeId) {
        try {
            storeRepository.deleteById(storeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
