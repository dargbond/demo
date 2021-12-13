package org.property.demo.businessobjects;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Business Object representing a HomeEntity.
 */
@Data
@RequiredArgsConstructor
public class HomeEntity {
    @NonNull
    private final HomeEntityId propertyId;
    @NonNull
    private final Address address;
    @NonNull
    private final HomeParameters parameters;
}
