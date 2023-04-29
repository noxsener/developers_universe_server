package com.codenfast.developersuniverse.common.repository;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.model.FilterParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Predicate;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface BaseRepository<T extends EntityModel> {
    EntityManager getEntityManager();

    T detach(T value);

    List<T> grid(Class<T> clazz, List<String> propertyList, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    List<T> grid(Class<T> clazz, List<String> propertyList, String sortField, Integer sortOrder, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    List<T> grid(Class<T> clazz, List<String> propertyList, Integer page, Integer pageSize, String sortField, Integer sortOrder, List<FilterParam> filters) throws NoSuchFieldException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    Long gridCount(Class<T> clazz, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    Predicate getFilterCondition(Class<T> clazz, CriteriaBuilder cb, From<T, ?> from, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException;

    Predicate getFilterCondition(Class<T> clazz, CriteriaBuilder cb, From<T, ?> from, List<FilterParam> filters, List<Predicate> specialPredicateList) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    Boolean delete(Class<T> clazz, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    Boolean update(Class<T> clazz, Map<String, Object> params, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
