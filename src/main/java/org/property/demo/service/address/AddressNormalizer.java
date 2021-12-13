package org.property.demo.service.address;

import org.property.demo.businessobjects.Address;
import org.property.demo.exceptions.AddressValidationException;

public interface AddressNormalizer {
    /**
     * Method that takes in an address and normalizes it.
     * @param address
     * @return
     */
    public Address normalizeAddress(final Address address) throws AddressValidationException;
}
