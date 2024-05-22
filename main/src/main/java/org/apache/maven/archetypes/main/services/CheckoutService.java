package org.apache.maven.archetypes.main.services;

import org.apache.maven.archetypes.main.dto.Purchase;
import org.apache.maven.archetypes.main.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
