package org.property.demo.service.validation;

import org.property.demo.businessobjects.Address;
import org.property.demo.exceptions.AddressValidationException;

/**
 * Interface for address validation.
 * In our application we want to make sure that addresses we are storing
 * 1. Are normalized (upper/lower case, don't use invalid characters etc)
 * 2. Are valid (point to real locations)
 *
 * Depending on the stage of the project and how important this validation is, we could either have a simple validator
 * that checks the string format only, use a third party library/tool for validation or have internal implementation.
 *
 */
public interface AddressValidator {
    public void validate(final Address address) throws AddressValidationException;
}
