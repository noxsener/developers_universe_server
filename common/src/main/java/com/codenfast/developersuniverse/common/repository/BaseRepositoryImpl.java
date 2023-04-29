package com.codenfast.developersuniverse.common.repository;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.utils.StringConstant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Data
public class BaseRepositoryImpl<T extends EntityModel> implements BaseRepository<T> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly=true)
    @Override
    public Long gridCount(Class<T> clazz, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<T> c = query.from(clazz);
        query.select(cb.count(c.get(FieldUtils.getFieldsListWithAnnotation(clazz, jakarta.persistence.Id.class).get(0).getName())));
        query.where(getFilterCondition(clazz, cb, c, filters));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public T detach(T value) {
        entityManager.detach(value);
        return value;
    }

    @Override
    public List<T> grid(Class<T> clazz, List<String> propertyList, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return grid(clazz, propertyList, null, null, null, null, filters);
    }

    @Override
    public List<T> grid(Class<T> clazz, List<String> propertyList, String sortField, Integer sortOrder, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return grid(clazz, propertyList, null, null, sortField, sortOrder, filters);
    }


    @Transactional(readOnly=true)
    @Override
    public List<T> grid(Class<T> clazz, List<String> propertyList, Integer page, Integer pageSize, String sortField, Integer sortOrder, List<FilterParam> filters) throws NoSuchFieldException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<?> query = null;
        Root<T> c = null;
        Map<String, Join> leftJoin = new HashMap<>();
        if (CollectionUtils.isNotEmpty(propertyList)) {

            query = cb.createQuery(Object[].class);
            c = query.from(clazz);
            List<Selection<?>> selectionList = new ArrayList<>();
            for (String propertyName : propertyList) {
                if (propertyName.contains(".")) {
                    addSubSelectionList(clazz, c, leftJoin, selectionList, propertyName);
                    continue;
                }
                selectionList.add(c.get(propertyName));
            }
            query.multiselect(selectionList);
        } else {
            query = cb.createQuery(clazz);
            c = query.from(clazz);
        }

        Predicate predicate = getFilterCondition(clazz, cb, c, leftJoin, filters);
        query.where(predicate);

        if (sortField != null && sortOrder != null) {
            query.orderBy(sortOrder > 0 ? cb.asc(c.get(sortField)) : cb.desc(c.get(sortField)));
        } else {
            query.orderBy(cb.desc(c.get(StringConstant.CREATE_TIME)));
        }

        TypedQuery typedQuery = entityManager.createQuery(query);
        if (page != null && pageSize != null) {
            typedQuery = typedQuery.setFirstResult(page).setMaxResults(pageSize);
        }
        if (CollectionUtils.isNotEmpty(propertyList)) {
            List<T> result = new ArrayList<>();
            List<Object> queryResultList = typedQuery.getResultList();
            if (propertyList.size() == 1) {
                for (Object queryResultRow : queryResultList) {
                    Object resultEntity = ConstructorUtils.invokeConstructor(clazz);
                    extractValueFromQuery(propertyList.get(0),resultEntity,  queryResultRow);
                    result.add((T) resultEntity);
                }
            } else {
                for (Object queryResultRow : queryResultList) {
                    Object resultEntity = ConstructorUtils.invokeConstructor(clazz);
                    Object[] row = (Object[]) queryResultRow;
                    for (int col = 0; col < propertyList.size() && row != null; col++) {
                        extractValueFromQuery(propertyList.get(col), resultEntity, row, col);
                    }
                    result.add((T) resultEntity);
                }
            }
            return result;
        } else {
            return typedQuery.getResultList();
        }
    }

    private void extractValueFromQuery(String propertyName, Object resultEntity, Object value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        if (!propertyName.contains(".")) {
            Object[] valueArr = (Object[]) value;
            MethodUtils.invokeMethod(resultEntity, getSetterMethodName(propertyName), valueArr[0]);
        } else {
            int seperator = propertyName.indexOf('.');
            String joinProperty = propertyName.substring(0, seperator);
            String joinPropertyProperty = propertyName.substring(seperator + 1);

            if(joinPropertyProperty.contains(".")) {
                Object subObj = MethodUtils.invokeMethod(resultEntity, getGetterMethodName(joinProperty));
                if (subObj == null) {
                    subObj = ConstructorUtils.invokeConstructor(resultEntity.getClass().getDeclaredField(joinProperty).getType());
                }
                MethodUtils.invokeMethod(resultEntity, getSetterMethodName(joinProperty), subObj);
                extractValueFromQuery(joinPropertyProperty, subObj, value);
                return;
            }

            Object subObj = MethodUtils.invokeMethod(resultEntity, getGetterMethodName(joinProperty));
            if (subObj == null) {
                subObj = ConstructorUtils.invokeConstructor(resultEntity.getClass().getDeclaredField(joinProperty).getType());
            }
            MethodUtils.invokeMethod(subObj, getSetterMethodName(joinPropertyProperty), value);
            MethodUtils.invokeMethod(resultEntity, getSetterMethodName(joinProperty), subObj);
        }
    }

    private void extractValueFromQuery(String propertyName, Object resultEntity, Object[] row, int col) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        if (!propertyName.contains(".")) {
            MethodUtils.invokeMethod(resultEntity, getSetterMethodName(propertyName), row[col]);
        } else {
            int seperator = propertyName.indexOf('.');
            String joinProperty = propertyName.substring(0, seperator);
            String joinPropertyProperty = propertyName.substring(seperator + 1);

            if(joinPropertyProperty.contains(".")) {
                Object subObj = MethodUtils.invokeMethod(resultEntity, getGetterMethodName(joinProperty));
                if (subObj == null) {
                    subObj = ConstructorUtils.invokeConstructor(resultEntity.getClass().getDeclaredField(joinProperty).getType());
                }
                MethodUtils.invokeMethod(resultEntity, getSetterMethodName(joinProperty), subObj);
                extractValueFromQuery(joinPropertyProperty, subObj, row, col);
                return;
            }

            Object subObj = MethodUtils.invokeMethod(resultEntity, getGetterMethodName(joinProperty));
            if (subObj == null) {
                subObj = ConstructorUtils.invokeConstructor(resultEntity.getClass().getDeclaredField(joinProperty).getType());
            }
            MethodUtils.invokeMethod(subObj, getSetterMethodName(joinPropertyProperty), row[col]);
            MethodUtils.invokeMethod(resultEntity, getSetterMethodName(joinProperty), subObj);
        }
    }

    private void addSubSelectionList(Class<?> clazz, From<T, ?> c, Map<String, Join> leftJoin, List<Selection<?>> selectionList, String propertyName) throws NoSuchFieldException {
        addSubSelectionList(clazz, c, leftJoin, selectionList, propertyName, "");
    }

    private void addSubSelectionList(Class<?> clazz, From<T, ?> c, Map<String, Join> leftJoin, List<Selection<?>> selectionList, String propertyName, String parentProperty) throws NoSuchFieldException {
        Join join = null;
        if (propertyName.contains(".")) {
            int seperator = propertyName.indexOf('.');
            String joinProperty = propertyName.substring(0, seperator);
            String joinPropertyProperty = propertyName.substring(seperator + 1);
            parentProperty = StringUtils.isNotBlank(parentProperty) ? parentProperty+"."+joinProperty : joinProperty;

            if (!leftJoin.containsKey(parentProperty)) {
                join = c.join(joinProperty, JoinType.LEFT);
                leftJoin.put(parentProperty, join);
            } else {
                join = leftJoin.get(parentProperty);
            }

            if(joinPropertyProperty.contains(".")) {
                Class<?> fclazzSub = clazz.getDeclaredField(joinProperty).getType();
                addSubSelectionList(fclazzSub, join, leftJoin, selectionList, joinPropertyProperty, parentProperty);
                return;
            }
            selectionList.add(join.get(joinPropertyProperty));
        } else if (clazz.getDeclaredField(propertyName).isAnnotationPresent(ManyToOne.class) && !leftJoin.containsKey(propertyName)) {
            join = c.join(propertyName, JoinType.LEFT);
            leftJoin.put(propertyName, join);
            selectionList.add(join);
        }
    }


    @Override
    public Predicate getFilterCondition(Class<T> clazz, CriteriaBuilder cb, From<T, ?> from, List<FilterParam> filters, List<Predicate> specialPredicateList) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Predicate predicate = getFilterCondition(clazz, cb, from, filters);
        for (Predicate predicateIndex : specialPredicateList) {
            predicate = cb.and(predicate, predicateIndex);
        }
        return predicate;
    }


    @Transactional
    @Override
    public Boolean delete(Class<T> clazz, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if (filters == null || filters.isEmpty()) {
            return Boolean.FALSE;
        }
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> query = cb.createCriteriaDelete(clazz);
        Root<T> c = query.from(clazz);
        query.where(getFilterCondition(clazz, cb, c, filters));
        Integer result = entityManager.createQuery(query).executeUpdate();
        return result != null && result > 0;
    }

    @SuppressWarnings("squid:S3776")

    @Transactional
    @Override
    public Boolean update(Class<T> clazz, Map<String, Object> params, List<FilterParam> filters) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if (params == null || params.size() < 1) {
            return Boolean.FALSE;
        }
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<T> query = cb.createCriteriaUpdate(clazz);
        Root<T> c = query.from(clazz);
        query.where(getFilterCondition(clazz, cb, c, filters));
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            Class<?> fclazz = clazz.getDeclaredField(entry.getKey()).getType();
            if (fclazz.equals(String.class)) {
                query.set(c.get(entry.getKey()), entry.getValue() != null ? entry.getValue().toString() : null);
            } else if (fclazz.equals(Date.class) && entry.getValue() != null && entry.getValue().toString().matches("[0-9]*")) {
                query.set(c.get(entry.getKey()),
                        entry.getValue() != null ? new Date(Long.parseLong(entry.getValue().toString())) : null);
            } else {

                query.set(c.get(entry.getKey()),
                        entry.getValue() != null ? entry.getValue() : null);
            }
        }
        int result = entityManager.createQuery(query).executeUpdate();
        return result > 0;
    }


    private String getGetterMethodName(String propertyName) {
        return StringConstant.GET + StringUtils.capitalize(propertyName);
    }

    private String getSetterMethodName(String propertyName) {
        return StringConstant.SET + StringUtils.capitalize(propertyName);
    }

    public Predicate getFilterCondition(Class<T> clazz, CriteriaBuilder cb, From<T, ?> from, List<FilterParam> filters) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return getFilterCondition(clazz, cb, from, null, filters);
    }

    public Predicate getFilterCondition(Class<T> clazz, CriteriaBuilder cb, From<T, ?> from, Map<String, Join> leftJoin, List<FilterParam> filters) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Predicate conj = cb.equal(cb.literal(1), cb.literal(1));
        if (CollectionUtils.isEmpty(filters)) {
            return conj;
        }
        if (leftJoin == null) {
            leftJoin = new HashMap<>();
        }

        for (FilterParam filterParam : filters) {
            if (!filterParam.getPropertyName().contains(".")) {
                conj = filterParamToPredicate(clazz, conj, cb, from, filterParam);
                continue;
            }
            String propertyName = filterParam.getPropertyName();
            int seperator = propertyName.indexOf('.');
            String joinProperty = propertyName.substring(0, seperator);
            String joinPropertyProperty = propertyName.substring(seperator + 1);
            Join join = null;
            if (!leftJoin.containsKey(joinProperty)) {
                join = from.join(joinProperty, JoinType.LEFT);
                leftJoin.put(joinProperty, join);
            } else {
                join = leftJoin.get(joinProperty);
            }
            Class joinClass = clazz.getDeclaredField(joinProperty).getType();

            if(joinPropertyProperty.contains(".")) {
                FilterParam subFilterParam = new FilterParam();
                subFilterParam.setPropertyName(joinPropertyProperty);
                subFilterParam.setFilterType(filterParam.getFilterType());
                subFilterParam.setFilterValue(filterParam.getFilterValue());
                conj = getFilterCondition(joinClass, cb, join, leftJoin, Collections.singletonList(subFilterParam));
                continue;
            }

            FilterParam subFilterParam = new FilterParam();
            subFilterParam.setPropertyName(joinPropertyProperty);
            subFilterParam.setFilterType(filterParam.getFilterType());
            subFilterParam.setFilterValue(filterParam.getFilterValue());
            conj = filterParamToPredicate(joinClass, conj, cb, join, subFilterParam);
        }
        return conj;
    }

    private Predicate filterParamToPredicate(Class<T> clazz, Predicate conj, CriteriaBuilder cb, From<T, ?> from, FilterParam filterParam) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        if (filterParam.getFilterType().equals("isNull")) {
            conj = cb.and(conj, cb.isNull(from.get(filterParam.getPropertyName())));
            return conj;
        } else if (filterParam.getFilterType().equals("isNotNull")) {
            conj = cb.and(conj, cb.isNotNull(from.get(filterParam.getPropertyName())));
            return conj;
        }

        Class<?> fclazz = clazz.getDeclaredField(filterParam.getPropertyName()).getType();

        if (filterParam.getFilterType().equals(StringConstant.IN)) {
            conj = cb.and(conj, from.get(filterParam.getPropertyName()).in(filterParam.getFilterValue()));
        } else if (fclazz.equals(Date.class)) {
            if (filterParam.getFilterType().equals("between")) {
                conj = cb.and(conj, cb.between(from.get(filterParam.getPropertyName()),
                        new Date(NumberUtils.createLong(filterParam.getFilterValue()[0].toString())),
                        new Date(NumberUtils.createLong(filterParam.getFilterValue()[1].toString()))));
            } else {
                Date date = new Date(NumberUtils.createLong(filterParam.getFilterValue()[0].toString()));
                conj = cb.and(conj, (Expression<Boolean>) MethodUtils.invokeMethod(cb, filterParam.getFilterType(), date));
            }
        } else if (fclazz.getPackage().getName().contains("com.codenfast.developersuniverse.common")) {
            Object entity = ConstructorUtils.invokeConstructor(fclazz);
            MethodUtils.invokeMethod(entity, getSetterMethodName(StringConstant.ID), ((Map) filterParam.getFilterValue()[0]).get(StringConstant.ID));
            conj = cb.and(conj, (Expression<Boolean>) MethodUtils.invokeMethod(cb, filterParam.getFilterType(), from.get(filterParam.getPropertyName()), entity));
        }
        else {
            if (filterParam.getFilterValue().length == 1) {
                conj = cb.and(conj, (Expression<Boolean>) MethodUtils.invokeMethod(cb, filterParam.getFilterType(), from.get(filterParam.getPropertyName()), filterParam.getFilterValue()[0]));
            } else {
                conj = cb.and(conj, (Expression<Boolean>) MethodUtils.invokeMethod(cb, filterParam.getFilterType(), from.get(filterParam.getPropertyName()), filterParam.getFilterValue()));
            }
        }
        return conj;
    }
}
