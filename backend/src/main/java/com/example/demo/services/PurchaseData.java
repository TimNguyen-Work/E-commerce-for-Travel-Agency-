package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class PurchaseData {
    @Valid
    @NotNull(message = "Cart cannot be null")
    private Cart cart;

    @Valid
    @NotNull(message = "Customer cannot be null")
    private Customer customer;

    @Valid
    private Set<CartItem> cartItems;



}
