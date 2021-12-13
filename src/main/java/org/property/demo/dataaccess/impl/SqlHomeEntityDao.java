package org.property.demo.dataaccess.impl;

import org.property.demo.businessobjects.HomeEntity;
import org.property.demo.businessobjects.HomeEntityId;
import org.property.demo.dataaccess.HomeEntityDao;

import java.util.Optional;

/**
 * Implementation of EntityDao that stores data to a relational database
 * Assumptions:
 * - Infrequent writes
 * - Frequent reads
 * - Data is structured
 *
 * To begin with, HomeEntity fields only contain metadata on the field. The data is structured and fits fine a single table
 * Based on how much data we decide to store for HomeEntity, we could split it into several tables that are related by Id
 * 1. Addresses (relational Data)
 * 2. Metadata (information, that is often used in filters/searches) - relational
 **/

public class SqlHomeEntityDao implements HomeEntityDao {
    @Override
    public void storeProperty(HomeEntity property) {
        //TODO: to be added
    }

    @Override
    public Optional<HomeEntity> getProperty(HomeEntityId propertyId) {
        //TODO: to be added
        return Optional.empty();
    }
}
