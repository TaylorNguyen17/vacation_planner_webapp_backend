package org.apache.maven.archetypes.main.services;

import jakarta.transaction.Transactional;
import org.apache.maven.archetypes.main.dao.CustomerRepository;
import org.apache.maven.archetypes.main.dto.Purchase;
import org.apache.maven.archetypes.main.dto.PurchaseResponse;
import org.apache.maven.archetypes.main.entities.Cart;
import org.apache.maven.archetypes.main.entities.CartItem;
import org.apache.maven.archetypes.main.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Cart cart = purchase.getCart();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItem();
        cartItems.forEach(item -> cart.add(item));

        // populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        // save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
