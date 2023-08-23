// repositories - contains definition of functions to manipulate table data (CRUD).

package com.example.productapi.models.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.productapi.models.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

// Simple CRUD operation use CrudRepository.
// import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // Custom.
    List<Product> findByName(String name);
    List<Product> findByPrice(Double price);
}
