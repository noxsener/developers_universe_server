package com.codenfast.developersuniverse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FilterParam {
    private String propertyName;
    private String filterType;
    private Object[] filterValue;

    public FilterParam(String propertyName, String filterType, Object filterValue) {
        this.propertyName = propertyName;
        this.filterType = filterType;
        this.filterValue = new Object[]{filterValue};
    }

    public FilterParam(String propertyName, String filterType, Object... filterValues) {
        this.propertyName = propertyName;
        this.filterType = filterType;
        this.filterValue = filterValues;
    }
}
