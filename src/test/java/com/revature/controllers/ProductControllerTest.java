package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.revature.models.Product;
import com.revature.services.ProductService;

public class ProductControllerTest {

    HttpSession session = Mockito.mock(HttpSession.class);
    ProductService productService = Mockito.mock(ProductService.class);
    ProductController productController = new ProductController(productService);

    @Test
    void testDeleteProduct() {
        Integer productId = 1;
        Product product = new Product(1, 15, 40.00, "Special coat", "coat.png", "Special Coat v2");

        Mockito.when(productService.findById(productId)).thenReturn(Optional.of(product));

        Assertions.assertEquals(ResponseEntity.ok(product), productController.deleteProduct(productId));

        Mockito.verify(productService, Mockito.times(1)).delete(productId);
    }

    @Test
    void testGetInventory() {
        List<Product> product_list_response = new ArrayList<Product>();
        Mockito.when(productService.findAll()).thenReturn(product_list_response);

        Assertions.assertEquals(ResponseEntity.ok(product_list_response), productController.getInventory());
    }

    @Test
    void testGetProductById() {
        Integer productId = 1;


    }

    @Test
    void testPurchase() {

    }

    @Test
    void testUpsert() {

    }
}
