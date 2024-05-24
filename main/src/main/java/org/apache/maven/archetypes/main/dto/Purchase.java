package org.apache.maven.archetypes.main.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.maven.archetypes.main.entities.Cart;
import org.apache.maven.archetypes.main.entities.CartItem;
import org.apache.maven.archetypes.main.entities.Customer;

import java.util.Set;

@Data
public class Purchase {

    @JsonProperty("customer")
    private Customer customer;
    @JsonProperty("cart")
    private Cart cart;
    @JsonProperty("cartItems")
    private Set<CartItem> cartItems;

}
