package com.codenfast.developersuniverse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableModel<T> {
    private List<T> data;
    private int count;
    private boolean loading = Boolean.FALSE;

    public TableModel(List<T> data, int count) {
        this.data = data;
        this.count = count;
    }
}
