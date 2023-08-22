// services - contains business logical.

package com.example.productapi.services;

import com.example.productapi.models.repositories.ProductRepo;
import com.example.productapi.models.entities.Product;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    
    // Add product.
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    // Get all product.
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    // Get product by product id.
    public Product getProductById(long id) {
        return productRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Product isn't found with id " + id));
    }

    // Update product by product id.
    // Update same as create (using save), but the difference is when the id already exists, it will be an update.
    public Product editProductById(long id, Product product) {
        Product isExist = productRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Cannot update. Product isn't found with id " + id));
        isExist.setName(product.getName());
        isExist.setDescription(product.getDescription());
        isExist.setPrice(product.getPrice());

        return productRepo.save(isExist);
    }

    // Delete product by product id.
    public void deleteProductById(long id) {
        Product isExist = productRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Cannot delete. Product isn't found with id " + id));
        productRepo.delete(isExist);
    }

    // Find product by product name.
    public List<Product> getProductByName(String name) {
        return productRepo.findByName(name);
    }

    // Find product by product price.
    public List<Product> getProductByPrice(double price) {
        return productRepo.findByPrice(price);
    }
}
