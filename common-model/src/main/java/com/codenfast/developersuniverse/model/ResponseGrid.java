package com.codenfast.developersuniverse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseGrid<T> {
    private TableModel<T> tableModel;

    public ResponseGrid(TableModel<T> tableModel) {
        this.tableModel = tableModel;
    }
}
