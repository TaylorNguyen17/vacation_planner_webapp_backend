package org.apache.maven.archetypes.main.dto;

import lombok.Data;
import org.apache.maven.archetypes.main.entities.Cart;
import org.apache.maven.archetypes.main.entities.CartItem;
import org.apache.maven.archetypes.main.entities.Customer;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItem;

}
