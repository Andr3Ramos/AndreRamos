package com.example.demo.Controller;

import com.example.demo.Data.ProductRepository;
import com.example.demo.Data.SaleRepository;
import com.example.demo.Requests.ProductRequest;
import com.example.demo.Requests.SaleRequest;
import com.example.demo.Model.*;
import com.example.demo.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path="api/sale")
public class SaleController {

    SaleService saleService;

   private final SaleRepository saleRepository;
   private final ProductRepository productRepository;

    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }

    @Autowired
    public SaleController(SaleService saleService, SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleService = saleService;
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    //Get all the sales
    @GetMapping
    public List<Sale> getSaleList(){
        return saleService.findAll();
    }

    //Get a Sale by id

    @PostMapping(path = "/add")
           public ResponseEntity<String> createSale(@RequestBody SaleRequest saleRequest) {
            Long clientId = saleRequest.getClientId();
            Long storeId = saleRequest.getStoreId();
            List<ProductRequest> productRequests = saleRequest.getProducts();

            List<Product> products = new ArrayList<>();

            for (ProductRequest productRequest : productRequests) {
                Long productId = productRequest.getProductId();
                double quantitySold = productRequest.getQuantitySold();

                Product product = productRepository.findById(productId).orElse(null);
                if (product != null) {
                    product.setStockSold(product.getStockSold() + quantitySold);
                    product.setStock(product.getStock()-quantitySold);
                    products.add(product);
                }
            }
            saleService.addSale(clientId, storeId, products);

            return ResponseEntity.ok("Sale created successfully.");
        }

    // Get the specific client sales
   /* @GetMapping("/client/{clientId}/sales")
    public ResponseEntity<List<Sale>> getSalesByClientId(@PathVariable long clientId) {
        List<Sale> sales = saleService.getSalesByClientId(clientId);
        if (!sales.isEmpty()) {
            return ResponseEntity.ok(sales);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
*/
    //Get client with the most buys
   @GetMapping("/client/most-buys")
    public ResponseEntity<Client> getClientWithMostBuys() {
        Client clientWithMostBuys = saleService.getClientWithMostStockSold();
        if (clientWithMostBuys != null) {
            return ResponseEntity.ok(clientWithMostBuys);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
