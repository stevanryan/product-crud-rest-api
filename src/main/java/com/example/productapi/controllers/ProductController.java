package com.example.productapi.controllers;

import com.example.productapi.models.entities.Product;
import com.example.productapi.services.ProductService;
import com.example.productapi.utils.response.PostResponse;
import com.example.productapi.utils.response.GetResponse;
import com.example.productapi.utils.response.PutResponse;
import com.example.productapi.utils.response.DeleteResponse;
import com.example.productapi.utils.response.FailResponse;

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
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    // Flows: controller calls service, service calls repository.
    private ProductService productService;

    // Method: POST
    @PostMapping("/products")
    public Object postProductHandler(@RequestBody Product product) {
        try {
            Product newProduct = productService.addProduct(product);
            return PostResponse.postResponse("Product added successfully", "productId", newProduct.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return FailResponse.failResponse("Failed to add product", HttpStatus.BAD_REQUEST);
        }
    }

    // Method: GET
    @GetMapping("/products")
    public Object getProductsHandler() {
        List<Product> products = productService.getProducts();
        return GetResponse.getAllResponse(products, HttpStatus.OK);
    }

    // Method: GET
    @GetMapping("/products/{id}")
    public Object getProductByIdHandler(@PathVariable("id") Long id) {
        try {
            Product foundProduct = productService.getProductById(id);
            return GetResponse.getResponse(foundProduct, HttpStatus.OK);
        } catch (Exception e) {
            return FailResponse.failResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        }   
    }

    // Method: PUT
    @PutMapping("/products/{id}")
    public Object putProductByIdHandler(@PathVariable("id") Long id, @RequestBody Product product) {
        try {
            productService.editProductById(id, product);
            return PutResponse.putResponse("Product data updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return FailResponse.failResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Method: DELETE
    @DeleteMapping("/products/{id}")
    public Object deleteProductByIdHandler(@PathVariable("id") Long id) {
        try {
            productService.deleteProductById(id);
            return DeleteResponse.deleteResponse("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return FailResponse.failResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
