package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;


import javax.validation.Valid;
import java.util.Set;

public interface CheckoutService {
    @Valid
    PurchaseResponse checkout(@Valid PurchaseData purchaseData);

    PurchaseResponse placeOrder(@Valid PurchaseData purchaseData);

}
