package org.property.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.property.demo.businessobjects.Address;
import org.property.demo.businessobjects.HomeEntity;
import org.property.demo.data.payloads.AddHomeEntityRequest;
import org.property.demo.data.payloads.AddHomeEntityResponse;
import org.property.demo.data.payloads.GetHomeEntityRequest;
import org.property.demo.data.payloads.GetHomeEntityResponse;
import org.property.demo.exceptions.AddressValidationException;
import org.property.demo.exceptions.AlreadyExistsException;
import org.property.demo.exceptions.ServiceDependencyException;
import org.property.demo.service.HomeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/home_entity")
public class HomeEntityController {

    @Autowired
    private HomeEntityService homeEntityService;

    @GetMapping("/add")
    public ResponseEntity addHomeEntity(@RequestBody AddHomeEntityRequest request) {
        try {
            final Address normalizedAddress = homeEntityService.createHomeEntity(
                    request.getAddress(),
                    request.getHomeParameters(),
                    request.getUser());
            final AddHomeEntityResponse homeEntityResponse = new AddHomeEntityResponse(normalizedAddress);
            return new ResponseEntity<>(homeEntityResponse, HttpStatus.CREATED);
        } catch  (IllegalArgumentException e) {
            log.error("Failure to retrieve HomeEntity for request: " + request, e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(String.format("Invalid request: %s. Error Message: %s", request, e.getMessage()));
        } catch (AlreadyExistsException e) {
            final String errorMessage = String.format("To create HomeEntity for request: %s. Entry with this address already exists.", request);
            log.error(errorMessage, e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(String.format(errorMessage));
        } catch (AddressValidationException e) {
            final String errorMessage =  String.format("Unable to create HomeEntity for request: %s. Unable to normalize address.", request);
            log.error(errorMessage, e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(String.format(errorMessage));
        }
        // TODO: handle other failures (write to storage etc)
    }

    @GetMapping("/get")
    public ResponseEntity getHomeEntity(@RequestBody GetHomeEntityRequest request) {
        try {
            final HomeEntity homeEntity = homeEntityService.retrieveHomeEntityByAddress(request.getAddress());
            GetHomeEntityResponse homeEntityResponse = new GetHomeEntityResponse(homeEntity.getAddress(), homeEntity.getParameters());

            return new ResponseEntity<>(homeEntityResponse, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            log.error("Failure to retrieve HomeEntity for request: " + request, e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(String.format("Invalid request: %s. Error Message: %s", request, e.getMessage()));
        } catch (ServiceDependencyException e) {
            log.error("Failure to retrieve HomeEntity for request: " + request, e);
            return ResponseEntity
                    .status(HttpStatus.FAILED_DEPENDENCY)
                    .body((String.format("Unable to get data for request `%s` due to dependency issue.", request)));
        } catch (AddressValidationException e) {
            //TODO: handle

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

}