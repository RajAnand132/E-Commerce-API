package com.projectRaj.eCommerceAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.ListIterator;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinColumn(name = "fk_user_id")
    private List<User> users;

    @ManyToMany
    @JoinColumn(name = "fk_product_id")
    private List<Product> products;

    @ManyToMany
    @JoinColumn(name = "fk_address_id")
    private List<Address> addresses;

    @NotNull(message = "Product quantity is required")
    @Min(value = 1, message = "Product quantity must be at least 1")
    private Integer productQuantity;
}

