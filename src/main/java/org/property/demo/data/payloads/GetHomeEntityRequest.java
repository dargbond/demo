package org.property.demo.data.payloads;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.property.demo.businessobjects.Address;

@Data
@RequiredArgsConstructor
public class GetHomeEntityRequest {
    @NonNull
    private final Address address;
}
