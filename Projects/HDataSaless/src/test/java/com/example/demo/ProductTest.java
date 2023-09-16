package com.example.demo;

import com.example.demo.Data.ProductRepository;
import com.example.demo.Model.Product;
import com.example.demo.Services.ProductService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductTest {

		@Autowired
		ProductService productService;
		@Autowired
		ProductRepository productRepository;

		@Test
		void findAll(){

			Product product1 = productService.save("banana", "fruta", 11, 12, 13);
			Product product2 = productService.save("Morango", "fruta", 11, 12, 13);

			List<Product> productList = productService.findAll();
			int numOfProductsInTheList = 2;



			assertNotNull(productList);
			assertEquals(numOfProductsInTheList,productList.size());


		}
		@Test
		void findProductById(){

			Product newProduct = productService.save("banana", "fruta", 11, 12, 13);
			newProduct.setId(3);

			assertEquals(3,newProduct.getId());
		}


		@Test
		void saveProduct () {
			Product newProduct = productService.save("banana", "fruta", 11, 12, 13);


			assertNotNull(newProduct);
			assertNotNull(newProduct.getName());
			assertEquals("banana", newProduct.getName());
			assertEquals("fruta", newProduct.getCategory());
			assertEquals(11, newProduct.getSellPrice());
			assertEquals(12, newProduct.getBuyPrice());
			assertEquals(13,newProduct.getStock());


		}

		@Test
		void deleById(){

			Product newProduct = productService.save("banana", "fruta", 11, 12, 13);
			long productId = newProduct.getId();
			productRepository.save(newProduct);

			productService.deleteById(productId);

			assertNull(productRepository.findById(productId));
		}

		@Test
		void addStockToProductId(){
			Product product = productService.save("banana", "fruta", 11, 12, 13);
			long productId = product.getId();
			double initialStock = product.getStock();

			// Call the method
			productService.addStockToProductById(productId, 40);

			// Retrieve the updated product from the database
			Product updatedProduct = productRepository.findById(productId);

			// Verify that the stock was updated correctly
			assertEquals(initialStock + 40, updatedProduct.getStock());
		}


		 @Test

		void productWithMostSells(){
			Product lowestSellProduct = productService.save("banana", "fruta", 11, 12, 13);
			Product highestSellProduct = productService.save("Morango", "fruta", 11, 12, 13);
			lowestSellProduct.setStockSold(30);
			highestSellProduct.setStockSold(60);

			productRepository.save(lowestSellProduct);
			productRepository.save(highestSellProduct);

			Product resultProduct = productService.productWithMostSells();

			assertNotNull(resultProduct);
			assertEquals(highestSellProduct.getId(),resultProduct.getId());
		 }


		 @Test
	void getMostExpensiveProduct(){
			 Product cheap = productService.save("banana", "fruta", 99, 12, 13);
			 Product expensive = productService.save("morango", "fruta", 110, 12, 20);

			 Product mostExpensiveProduct = productService.getMostExpensiveProduct();

			 assertEquals(expensive.getId() , mostExpensiveProduct.getId());
		 }

	}
