package com.codenfast.developersuniverse.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class YesNoConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute ? "Y" : "N";
    }

    @SuppressWarnings("squid:S2447")
    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData == null || (!dbData.equals("Y") && !dbData.equals("N"))) {
            return null;
        }
        return dbData.equalsIgnoreCase("Y");
    }
}
