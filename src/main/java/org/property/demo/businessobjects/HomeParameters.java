package org.property.demo.businessobjects;

import lombok.Builder;
import lombok.Data;

import org.property.demo.service.validation.GenericValidator;

import java.net.URL;

/**
 * POJO for home entity parameters.
 * Contains only a subset of fields for now and need to be expanded.
 */
@Data
@Builder
public class HomeParameters {
    private int builtInYear;
    private BuildingType type;
    private int areaInSqFt;
    private int numberOfBathrooms;
    private int numberOfBedrooms;
    private URL floorPlan;

    public void setBuiltInYear(final int builtInYear) {
        GenericValidator.validateYear(builtInYear);

        this.builtInYear = builtInYear;
    }

    public void setAreaInSqFt(final int areaInSqFt) {
        GenericValidator.validatePositiveInteger("Area in Sq. Ft.", areaInSqFt);

        this.areaInSqFt = areaInSqFt;
    }

    //TODO: setters with validation for other properties
}
