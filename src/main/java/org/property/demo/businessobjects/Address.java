package org.property.demo.businessobjects;

import lombok.Data;
import lombok.NonNull;

/**
 * Simple wrapper for an address.
 * Note: address format is fairly complicated and can vary a lot from country to country.
 * This POJO keeps validation to minimum: only enforce required fields. All business logic to validate the address lives in the service layer.
 */
@Data
public class Address {
    @NonNull private final String streetAddress; // E.g.: "Apt. 56B, Whitehaven Mansions", "221B Baker Street"
    @NonNull private final String city;
    @NonNull private final String postalCode;
    @NonNull private final String country;
}
