package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
       // this.cartRepository = cartRepository;
    }

    @Override
    public PurchaseResponse checkout(PurchaseData purchaseData) {
        return null;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseData purchaseData) {
        Cart cart = purchaseData.getCart();
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        Set<CartItem> cartItems = purchaseData.getCartItems();
        cartItems.forEach(cart::add);
        Customer customer = purchaseData.getCustomer();
        customer.add(cart);
        //customerRepository.save(customer);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);

    }



    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }


}
