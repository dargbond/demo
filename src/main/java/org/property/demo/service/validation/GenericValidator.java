package org.property.demo.service.validation;

/**
 * Utility class to handle validation of pojos
 */
public class GenericValidator {
    private static final int MIN_YEAR = 0;
    private static final int MAX_YEAR = 3000; // May want to restrict to current year.

    public static void validateYear(final int year) {
        if (!org.apache.commons.validator.GenericValidator.isInRange(year, MIN_YEAR, MAX_YEAR)) {
            throw new IllegalArgumentException(String.format("Invalid `year` passed: " +
                    "expected value within range [%s, %s], actual: %s", MIN_YEAR, MAX_YEAR, year));
        }
    }

    public static void validatePositiveInteger(final String parameterName, final int parameterValue) {
        if (!org.apache.commons.validator.GenericValidator.minValue(parameterValue, 0)) {
            throw new IllegalArgumentException(String.format("%s value %s can't be <0", parameterName, parameterValue));
        }
    }
}
