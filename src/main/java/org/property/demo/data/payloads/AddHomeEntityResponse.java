package org.property.demo.data.payloads;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.property.demo.businessobjects.Address;
import org.property.demo.businessobjects.HomeEntity;

@Data
@RequiredArgsConstructor
public class AddHomeEntityResponse {
    private final Address normalizedAddress;
}
