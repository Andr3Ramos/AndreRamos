package com.example.demo.Controller;

import com.example.demo.Data.SaleRepository;
import com.example.demo.Model.Client;
import com.example.demo.Model.Sale;
import com.example.demo.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/sale")
public class SaleController {

    SaleService saleService;

   private final SaleRepository saleRepository;

    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }

    @Autowired
    public SaleController(SaleService saleService, SaleRepository saleRepository) {
        this.saleService = saleService;
        this.saleRepository = saleRepository;
    }

    //Get all the sales
    @GetMapping
    public Iterable<Sale> getSaleList(){
        return saleRepository.findAll();
    }

    //Get a Sale by id
    @RequestMapping(path = "/{id}")
    public Sale getSaleById(@PathVariable long id){
        return saleRepository.findSaleById(id);
    }



    // Add a Sale
  /*  @PostMapping(path = "/add")
    public ResponseEntity<String> createSale(
        @RequestParam int clientId,
        @RequestParam int storeId,
        @RequestParam List<Integer> productIds){
        saleService.makeSale(clientId,storeId,productIds);
    return  ResponseEntity.ok("Sale Created Sucefully");
    }

    // Get the specific client sales
    @GetMapping("/client/{clientId}/sales")
    public ResponseEntity<List<Sale>> getSalesByClientId(@PathVariable long clientId) {
        List<Sale> sales = saleService.getSalesByClientId(clientId);
        if (!sales.isEmpty()) {
            return ResponseEntity.ok(sales);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Get client with the most buys
   @GetMapping("/client/most-buys")
    public ResponseEntity<Client> getClientWithMostBuys() {
        Client clientWithMostBuys = saleRepository.getClientWithMostBuys();
        if (clientWithMostBuys != null) {
            return ResponseEntity.ok(clientWithMostBuys);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
*/

}
