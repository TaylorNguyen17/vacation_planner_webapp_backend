package org.apache.maven.archetypes.main.services;

import jakarta.transaction.Transactional;
import org.apache.maven.archetypes.main.dao.CartRepository;
import org.apache.maven.archetypes.main.dao.CustomerRepository;
import org.apache.maven.archetypes.main.dao.ExcursionRepository;
import org.apache.maven.archetypes.main.dao.VacationRepository;
import org.apache.maven.archetypes.main.dto.Purchase;
import org.apache.maven.archetypes.main.dto.PurchaseResponse;
import org.apache.maven.archetypes.main.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final VacationRepository vacationRepository;  // Add the Vacation repository
    private final ExcursionRepository excursionRepository;  // Add the Excursion repository

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository,
                               VacationRepository vacationRepository, ExcursionRepository excursionRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.vacationRepository = vacationRepository;
        this.excursionRepository = excursionRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Cart cart = purchase.getCart();

        // Debugging step: Print cart details before any processing
        System.out.println("Received Cart: " + cart);
        System.out.println("Received Cart Items: " + purchase.getCartItems());

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        for (CartItem item : cartItems) {
            // Fetch the managed instance of Vacation
            Vacation managedVacation = vacationRepository.findById(item.getVacation().getId()).orElseThrow(
                    () -> new RuntimeException("Vacation not found")
            );
            item.setVacation(managedVacation);

            // Fetch managed instances of Excursions
            Set<Excursion> managedExcursions = new HashSet<>();
            for (Excursion excursion : item.getExcursions()) {
                Excursion managedExcursion = excursionRepository.findById(excursion.getId()).orElseThrow(
                        () -> new RuntimeException("Excursion not found")
                );
                managedExcursions.add(managedExcursion);
            }
            item.setExcursions(managedExcursions);

            item.setCart(cart);  // Associate each CartItem with the Cart
            cart.getCartItems().add(item);  // Add each CartItem to the Cart's cartItems set
        }

        // Debugging step: Print cart details after adding cartItems
        System.out.println("Cart after adding items: " + cart);
        System.out.println("Cart Items after adding items: " + cart.getCartItems());

        // Fetch the existing customer from the repository
        Customer customer = purchase.getCustomer();
        Optional<Customer> existingCustomerOpt = customerRepository.findById(customer.getId());

        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();
            existingCustomer.add(cart);  // Populate existing customer with cart

            // Save the updated customer to the database
            customerRepository.save(existingCustomer);

            // Update cart status and save to the database
            cart.setStatus(StatusType.ordered);
            cartRepository.save(cart);

            // Debugging step: Verify cart and customer save
            System.out.println("Saved Customer: " + existingCustomer);
            System.out.println("Saved Cart: " + cart);
        } else {
            throw new RuntimeException("Customer with ID " + customer.getId() + " not found");
        }

        // Return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // Generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}