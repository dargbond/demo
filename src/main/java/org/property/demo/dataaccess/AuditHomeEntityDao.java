package org.property.demo.dataaccess;

import org.property.demo.businessobjects.HomeEntity;
import org.property.demo.businessobjects.User;

/**
 * Interface for Audit DAO to keep history of changes to the address.
 *
 * Implementation of this interface is out of scope for now.
 * Each update to a record will result in audit store update. Each entry should contain
 * 1. HomeEntityId
 * 2. UpdatedBy
 * 3. UpdatedTimestamp (UTC)
 * 4. Previous Record
 * 5. Updated Record
 *
 * For simplicity: storing this data in a NoSQL (DynamoDB) table is sufficient.
 */
public interface AuditHomeEntityDao {
    public void storeUpdate(final HomeEntity property, final User user);
}
