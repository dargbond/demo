package org.property.demo.dataaccess;

import org.property.demo.businessobjects.Address;
import org.property.demo.businessobjects.HomeParameters;

public interface RawHomeEntityDao {
    public void storeRawHomeEntity(final Address address, final HomeParameters parameters);
}
