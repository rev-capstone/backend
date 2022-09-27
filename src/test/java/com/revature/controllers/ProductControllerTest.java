package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
//import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.revature.dtos.ProductInfo;
import com.revature.models.Product;
import com.revature.services.ProductService;

public class ProductControllerTest {

    HttpSession session = Mockito.mock(HttpSession.class);
    ProductService productService = Mockito.mock(ProductService.class);
    ProductController productController = new ProductController(productService);
    //Iterator<Product> productIterator = Mockito.mock(Iterator.class);
    //ArrayList<Product> productList = Mockito.mock(ArrayList.class);

    Product p1 = new Product(1, 15, 40.00, "Special coat", "coat.png", "Special Coat v2");
    Product p2 = new Product(2, 45, 13.00, "Magic Socks", "socks.png", "Magic Socks");
    Product p3 = new Product(3, 4, 370.00, "Iron T-Shirt", "tshirt.png", "Iron plate T-Shirt");
    List<Product> productList = new ArrayList<Product>(){
        {
            add(p1);
            add(p2);
            add(p3);
        }
    };
    ArrayList<ProductInfo> metadata = new ArrayList<ProductInfo>(){
        {
            add(new ProductInfo(1,3));
            add(new ProductInfo(2,15));
            add(new ProductInfo(3,1));
        }
    };

    @Test
    void testDeleteProductSuccess() {
        Integer productId = 1;
        Product product = p1;

        Mockito.when(productService.findById(productId)).thenReturn(Optional.of(product));

        assertEquals(ResponseEntity.ok(product), productController.deleteProduct(productId));

        Mockito.verify(productService, Mockito.times(1)).delete(productId);
    }

    @Test
    void testDeleteProductFail() {
        Integer productId = 1;

        Mockito.when(productService.findById(productId)).thenReturn(Optional.empty());

        assertEquals(ResponseEntity.notFound().build(), productController.deleteProduct(productId));
    }

    @Test
    void testGetInventory() {
        List<Product> product_list_response = new ArrayList<Product>();
        Mockito.when(productService.findAll()).thenReturn(product_list_response);

        assertEquals(ResponseEntity.ok(product_list_response), productController.getInventory());
    }

    @Test
    void testGetProductByIdSuccess() {
        Integer productId = 1;
        Product product = p1;
        Mockito.when(productService.findById(productId)).thenReturn(Optional.of(product));

        assertEquals(ResponseEntity.ok(product), productController.getProductById(productId));
    }

    @Test
    void testGetProductByIdFail(){
        Integer productId = 1;
        Mockito.when(productService.findById(productId)).thenReturn(Optional.empty());
        assertEquals(ResponseEntity.notFound().build(), productController.getProductById(productId));
    }

    @Test
    void testPurchaseProductsFoundAndSaved() {
        ProductInfo currentMeta;
        Integer currentId;
        for(int i = 0; i < metadata.size(); i++){
            currentMeta = metadata.get(i);
            currentId = metadata.get(i).getId();
            Mockito.when(productService.findById(currentId)).thenReturn(Optional.of(productList.get(i)));
            assertEquals(Optional.of(productList.get(i)), productService.findById(currentId));
            Optional<Product> p = productService.findById(currentId);
            assertTrue(p.get().getQuantity() - currentMeta.getQuantity() > 0);
        }
        Mockito.when(productService.saveAll(productList, metadata)).thenReturn(productList);
        assertEquals(productList, productService.saveAll(productList, metadata));  
    }

    @Test
    void testUpsert() {
        Product product = new Product(1, 15, 40.00, "Special coat", "coat.png", "Special Coat v2");
        Mockito.when(productService.save(product)).thenReturn(product);

        assertEquals(ResponseEntity.ok(product), productController.upsert(product));

        Mockito.verify(productService, Mockito.times(1)).save(product);
    }
}
