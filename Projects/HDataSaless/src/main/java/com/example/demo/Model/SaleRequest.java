package com.example.demo.Model;

import java.util.List;

    public class SaleRequest {
        private Long clientId;
        private Long storeId;
        private List<ProductRequest> products;


        public Long getClientId() {
            return clientId;
        }

        public void setClientId(Long clientId) {
            this.clientId = clientId;
        }

        public Long getStoreId() {
            return storeId;
        }

        public void setStoreId(Long storeId) {
            this.storeId = storeId;
        }

        public List<ProductRequest> getProducts() {
            return products;
        }

        public void setProducts(List<ProductRequest> products) {
            this.products = products;
        }

    }



