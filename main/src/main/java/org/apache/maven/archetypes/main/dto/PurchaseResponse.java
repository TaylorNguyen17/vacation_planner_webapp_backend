package org.apache.maven.archetypes.main.dto;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class PurchaseResponse {

    private final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

}
