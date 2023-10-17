package com.example.demo.controllers;

import com.example.demo.services.CheckoutService;
import com.example.demo.services.PurchaseData;
import com.example.demo.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController

@RequestMapping(value = "/api/checkout", method = RequestMethod.GET)
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService)
    {
       this.checkoutService = checkoutService;
   }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody PurchaseData purchaseData) {
       PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchaseData);
        return purchaseResponse;
  }
}
