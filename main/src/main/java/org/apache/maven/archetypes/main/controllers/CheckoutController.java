package org.apache.maven.archetypes.main.controllers;

import org.apache.maven.archetypes.main.dto.Purchase;
import org.apache.maven.archetypes.main.dto.PurchaseResponse;
import org.apache.maven.archetypes.main.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "http://localhost:4200")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        // Debugging step
//        System.out.println("Received Purchase: " + purchase);
        return checkoutService.placeOrder(purchase);
    }

}
