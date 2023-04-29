package com.codenfast.developersuniverse.common.service;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;

import java.util.List;

public interface BaseService<T extends EntityModel> {

    T save(T entity) throws CodenfastException;

    T update(T entity) throws CodenfastException;

    T delete(String id) throws CodenfastException;

    List<T> save(List<T> entityList) throws CodenfastException;

    List<T> update(List<T> entityList) throws CodenfastException;

    List<T> delete(List<T> entityList) throws CodenfastException;

    List<T> grid(RequestGrid requestGrid) throws CodenfastException;

    TableModel<T> gridTableModel(RequestGrid requestGrid) throws CodenfastException;
}
