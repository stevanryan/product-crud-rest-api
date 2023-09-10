package com.example.productapi.controllers;

import com.example.productapi.models.entities.Product;
import com.example.productapi.services.ProductService;
import com.example.productapi.utils.response.PostResponse;
import com.example.productapi.utils.response.GetResponse;
import com.example.productapi.utils.response.PutResponse;
import com.example.productapi.utils.errorPrinter.ErrorPrinter;
import com.example.productapi.utils.response.DeleteResponse;
import com.example.productapi.utils.response.FailResponse;
import com.example.productapi.utils.response.ValidationErrorResponse;

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
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    
    @Autowired
    // Flow: controller calls service, service calls repository.
    private ProductService productService;

    // Method: POST
    @PostMapping("/products")
    public ResponseEntity<?> postProductHandler(@Valid @RequestBody Product product, Errors err) {
        if (err.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ValidationErrorResponse(HttpStatus.BAD_REQUEST, "Data validation error", ErrorPrinter.errorPrinter(err)));
        }
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new PostResponse(HttpStatus.CREATED, "Product added successfully", "productId", newProduct.getId()));
    }

    // Method: GET
    @GetMapping("/products")
    public ResponseEntity<Object> getProductsHandler() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(new GetResponse<Product>(HttpStatus.OK, "Successfully getting all products", products));
    }

    // Method: GET
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductByIdHandler(@PathVariable("id") Long id) {
        try {
            Product foundProduct = productService.getProductById(id);
            return ResponseEntity.ok(new GetResponse<Product>(HttpStatus.OK, "Successfully getting product with id " + id, foundProduct));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FailResponse(HttpStatus.NOT_FOUND, e.getMessage()));
        }   
    }

    // Method: PUT
    @PutMapping("/products/{id}")
    public ResponseEntity<?> putProductByIdHandler(@Valid @PathVariable("id") Long id, @RequestBody Product product, Errors err) {
        try {
            if (err.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ValidationErrorResponse(HttpStatus.BAD_REQUEST, "Data validation error", ErrorPrinter.errorPrinter(err)));
            }
            productService.editProductById(id, product);
            return ResponseEntity.ok(new PutResponse(HttpStatus.OK, "Product data with id " + id + " updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FailResponse(HttpStatus.NOT_FOUND, e.getMessage()));
        }
    }

    // Method: DELETE
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductByIdHandler(@PathVariable("id") Long id) {
        try {
            productService.deleteProductById(id);
            return ResponseEntity.ok(new DeleteResponse(HttpStatus.OK, "Product data with id " + id + " deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FailResponse(HttpStatus.NOT_FOUND, e.getMessage()));
        }
    }
}
