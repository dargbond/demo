package org.property.demo.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.property.demo.dataaccess.AuditHomeEntityDao;
import org.property.demo.dataaccess.HomeEntityDao;
import org.property.demo.dataaccess.HomeEntityIdProvider;
import org.property.demo.exceptions.AddressValidationException;
import org.property.demo.exceptions.AlreadyExistsException;
import org.property.demo.exceptions.ServiceDependencyException;
import org.property.demo.service.address.AddressNormalizer;
import org.property.demo.service.validation.AddressValidator;
import org.property.demo.businessobjects.*;

import java.util.Optional;

/**
 * First iteration on service layer for storing and retrieving data.
 *
 * As the application, we may want to separate store and get into separate services.
 */
@Slf4j
@RequiredArgsConstructor
public class HomeEntityService {
    @NonNull
    private final HomeEntityDao homeDataAccess;
    @NonNull
    private final AuditHomeEntityDao auditDataAccess;
    @NonNull
    private final AddressNormalizer addressNormalizer;
    @NonNull
    private final HomeEntityIdProvider propertyIdRetriever;

    /**
     * Stores HomeEntity information passed to it.
     * @param address - valid address of the HomeEntity.
     * @param homeParameters - metadata for HomeEntity
     * @param user - user creating or updating the storage.
     */
    public Address createHomeEntity(final Address address, final HomeParameters homeParameters, final User user)
            throws AlreadyExistsException, AddressValidationException {
        final Address normalizedAddress = addressNormalizer.normalizeAddress(address);
        final HomeEntityId propertyId = propertyIdRetriever.getPropertyId(normalizedAddress);
        final HomeEntity toBeStored = new HomeEntity(propertyId, normalizedAddress, homeParameters);

        //TODO: assuming we are receiving data from user directly, I'd also store raw data (json) as is in a key-value storage (DynamoDB, S3).

        //TODO: this method can throw exceptions. Propagate them to controller and handle them there.
        homeDataAccess.storeProperty(toBeStored);

        //TODO: depending on the use case, this likely should be allowed to fail without failing the call
        // The implementation should log a warning and emit relevant metrics, but allow request to go through
        auditDataAccess.storeUpdate(toBeStored, user);

        return normalizedAddress;
    }

    public HomeEntity retrieveHomeEntityByAddress(final Address address) throws ServiceDependencyException, AddressValidationException {
        final Address normalizedAddress = addressNormalizer.normalizeAddress(address);

        final HomeEntityId propertyId = propertyIdRetriever.getPropertyId(normalizedAddress);

        Optional<HomeEntity> optionalHomeEntity = homeDataAccess.getProperty(propertyId);

        return optionalHomeEntity.orElseThrow(() -> new ServiceDependencyException(
                "Unable to retrieve homeEntity by address: " + address));

    }
}
