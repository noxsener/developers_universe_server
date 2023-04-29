package com.codenfast.developersuniverse.model;

import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestGrid {
    private List<String> propertyList;
    private List<FilterParam> filters;
    private Integer page;
    private Integer pageSize;
    private String sortField;
    private Integer sortOrder;

    public static RequestGrid getById(String id) {
        RequestGrid requestGrid = new RequestGrid();
        List<FilterParam> filters = new java.util.ArrayList<>();
        filters.add(new FilterParam(StringConstant.ID, StringConstant.EQUAL, id));
        requestGrid.setPageSize(0);
        requestGrid.setPageSize(1);
        requestGrid.setFilters(filters);
        return requestGrid;
    }

    public static RequestGrid getByRefId(String referenceProperty, String id) {
        RequestGrid requestGrid = new RequestGrid();
        List<FilterParam> requestFilterList = new java.util.ArrayList<>();
        requestFilterList.add(new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE));
        Map<String, Object> filter = new HashMap<>();
        filter.put(StringConstant.ID, id);
        requestFilterList.add(new FilterParam(referenceProperty, StringConstant.EQUAL, filter));
        requestGrid.setFilters(requestFilterList);
        return requestGrid;
    }

    public static RequestGrid getByProperty(String property, Object propertyValue) {
        return getByProperty(property, StringConstant.EQUAL,propertyValue);
    }

    public static RequestGrid getByProperty(String property, String filterType ,Object propertyValue) {
        RequestGrid requestGrid = new RequestGrid();
        List<FilterParam> requestFilterList = new java.util.ArrayList<>();
        requestFilterList.add(new FilterParam(StringConstant.PASSIVE, filterType, Boolean.FALSE));
        requestFilterList.add(new FilterParam(property, filterType, propertyValue));
        requestGrid.setFilters(requestFilterList);
        return requestGrid;
    }
}
