package org.property.demo.dataaccess;

import org.property.demo.businessobjects.Address;
import org.property.demo.businessobjects.HomeEntityId;

/**
 * Interface for HomeEntityId
 */
public interface HomeEntityIdProvider {
    public HomeEntityId getPropertyId(final Address address);
}
