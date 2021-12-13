package org.property.demo.dataaccess;

import org.property.demo.businessobjects.HomeEntity;
import org.property.demo.businessobjects.HomeEntityId;
import org.property.demo.exceptions.AlreadyExistsException;

import java.util.Optional;

/**
 * Interface for storing and retrieving home entity information.
 */
public interface HomeEntityDao {

    public void storeProperty(final HomeEntity property) throws AlreadyExistsException;

    public Optional<HomeEntity> getProperty(final HomeEntityId propertyId);
}
