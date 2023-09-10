// entities - contains schema of the table.

package com.example.productapi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity // Mandatory.
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto increment (unique for each id).
    private Long id;

    @NotBlank(message = "name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "description is required")
    @Size(min = 20, max = 300, message = "description length must be between 20 and 300 characters")
    @Column(nullable = false)
    private String description;

    @DecimalMin(value = "0.0", message = "price must be greater than or equal to 0.0")
    @Column(nullable = false)
    private Double price;
}
