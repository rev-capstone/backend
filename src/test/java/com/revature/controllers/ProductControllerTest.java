package com.revature.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.models.Product;
import com.revature.services.ProductService;

public class ProductControllerTest {

    HttpSession session = Mockito.mock(HttpSession.class);
    ProductService productService = Mockito.mock(ProductService.class);

    @Test
    void testDeleteProduct() {
        Integer productId = 1;
        Product product = new Product(1, 15, 40.00, "Special coat", "coat.png", "Special Coat v2");

        Mockito.when(productService.findById(productId)).thenReturn(Optional.of(product));

        productService.delete(productId);

        Mockito.verify(productService, Mockito.times(1)).delete(productId);
        
    }

    @Test
    void testGetInventory() {

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
