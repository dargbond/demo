package org.property.demo.data.payloads;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.property.demo.businessobjects.Address;
import org.property.demo.businessobjects.HomeParameters;

@RequiredArgsConstructor
public class GetHomeEntityResponse {
    @NonNull
    private final Address address;
    @NonNull
    private final HomeParameters homeParameters;
}
