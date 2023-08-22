package com.example.productapi.controllers;

import com.example.productapi.models.entities.Product;
import com.example.productapi.services.ProductService;
import com.example.productapi.utils.ApiResponse.GetResponse;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class ProductController {
    GetResponse getResponse = new GetResponse();
    
    @Autowired
    // Flows: controller calls service, service calls repository.
    private ProductService productService;

    // Method: POST
    @PostMapping("/products")
    public String postProductHandler(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully";
    }

    // Method: GET
    @GetMapping("/products")
    public List<Product> getProductsHandler() {
        return productService.getProducts();
    }

    // Method: GET
    @GetMapping("/products/{id}")
    public Product getProductByIdHandler(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    // Method: PUT
    @PutMapping("/products/{id}")
    public String putProductByIdHandler(@PathVariable("id") long id, @RequestBody Product product) {
        productService.editProductById(id, product);
        return "Product with id " + id + " updated successfully";
    }

    // Method: DELETE
    @DeleteMapping("/products/{id}")
    public String deleteProductByIdHandler(@PathVariable("id") long id) {
        productService.deleteProductById(id);
        return "Product with id " + id + " deleted successfully";
    }

}
