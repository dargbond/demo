package org.property.demo.data.payloads;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.property.demo.businessobjects.Address;
import org.property.demo.businessobjects.HomeParameters;
import org.property.demo.businessobjects.User;

@Data
@RequiredArgsConstructor
public class AddHomeEntityRequest {
    @NonNull
    private final Address address;
    @NonNull
    private final HomeParameters homeParameters;
    @NonNull
    private final User user;
}
