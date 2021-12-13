package org.property.demo.dataaccess.impl;

import org.property.demo.businessobjects.Address;
import org.property.demo.businessobjects.HomeEntityId;
import org.property.demo.dataaccess.HomeEntityIdProvider;

import java.util.StringJoiner;

/**
 * Implementation of PropertyIdRetriever that creates the ID from the address.
 * Note: skips PostalCode since apparently it may change from time to time
 *
 * Benefits of this approach:
 * - Relative simplicity: can create ID from the address.
 * - Easier to handle duplicated updates
 * Disadvantages:
 * - Assumes that addresses are normalized
 * - Change in address format requires a full migration
 */
public class AddressBasedPropertyIdProvider implements HomeEntityIdProvider {
    @Override
    public HomeEntityId getPropertyId(final Address address) {
        StringJoiner stringJoiner = new StringJoiner("+");
        stringJoiner.add(address.getStreetAddress());
        stringJoiner.add(address.getCity());
        stringJoiner.add(address.getCountry());
        return new HomeEntityId(stringJoiner.toString());
    }
}
