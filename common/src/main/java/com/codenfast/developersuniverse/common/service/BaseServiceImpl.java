package com.codenfast.developersuniverse.common.service;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.annotation.DontUpdate;
import com.codenfast.developersuniverse.annotation.StringForceUppercase;
import com.codenfast.developersuniverse.annotation.validation.CannotBeNull;
import com.codenfast.developersuniverse.common.repository.BaseRepository;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.utils.StringConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Slf4j
public class BaseServiceImpl<T extends EntityModel> {

    public final static String usernameRegex = "^[a-z][a-z0-9_]{3,}$";
    public final static String passwordRegex = "^[a-zğüşiöçA-ZĞÜŞİÖÇ0-9!+&=*-_.@#]*$";
    public final static String integerRegex = "^[0-9]*$";
    public final static String booleanRegex = "^(true|false)$";
    public final static String emailRegex = "^[a-zA-Z][._a-zA-Z0-9]+[@][a-zA-Z][._a-zA-Z0-9]+[.][a-zA-Z0-9]{2,12}([.][a-zA-Z0-9]{2,12})?$";

    public void validate(T entity) throws CodenfastException {
        try {
            Class<?> clazz = entity.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                String getterMethodName = StringConstant.GET + StringUtils.capitalize(field.getName());

                if ((!field.isAnnotationPresent(Id.class) && field.isAnnotationPresent(Column.class) && !field.getAnnotation(Column.class).nullable() || field.isAnnotationPresent(CannotBeNull.class))
                        && MethodUtils.invokeMethod(entity, getterMethodName) == null) {
                    throw new CodenfastException(field.getName() + " cannot be null");
                }
            }
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    public void validate(List<T> entityList) throws CodenfastException {
        for (T entity : entityList) {
            validate(entity);
        }
    }

    public T save(T entity) throws CodenfastException {
        try {
            MethodUtils.invokeMethod(entity, "setCreateTime", LocalDateTime.now());
            MethodUtils.invokeMethod(entity, "setUpdateTime", LocalDateTime.now());
            return entity;
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    public List<T> save(List<T> entityList) throws CodenfastException {
        try {
            if (CollectionUtils.isNotEmpty(entityList)) {
                for (T entity : entityList) {
                    save(entity);
                }
            }
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    public T update(JpaRepository<T, String> repository, T entity) throws CodenfastException {
        try {
            String id = (String) MethodUtils.invokeMethod(entity, "getId");
            if(StringUtils.isBlank(id)) {
                return save(entity);
            }
            Optional<T> entityOptional = repository.findById(id);
            if (entityOptional.isEmpty() || (Boolean) MethodUtils.invokeMethod(entityOptional.get(), "getPassive")) {
                throw new CodenfastException(String.format("There is no entity: %s", id));
            }
            T ref = entityOptional.get();
//            if (islemYapan != null) {
//                MethodUtils.invokeMethod(entityOptional.get(), "setGuncelleyen", islemYapan);
//            }
            for (Field field : ref.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(DontUpdate.class) || field.isAnnotationPresent(Transient.class)) {
                    continue;
                }
                String setterMethodName = StringConstant.SET + StringUtils.capitalize(field.getName());
                String getterMethodName = StringConstant.GET + StringUtils.capitalize(field.getName());
                Object propertyNewValue = MethodUtils.invokeMethod(entity, getterMethodName);
                if (field.isAnnotationPresent(StringForceUppercase.class) && propertyNewValue instanceof String && StringUtils.isNotBlank(propertyNewValue.toString())) {
                    propertyNewValue = propertyNewValue.toString().toUpperCase();
                }
                MethodUtils.invokeMethod(ref, setterMethodName, propertyNewValue);
            }
            return ref;
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    public List<T> update(JpaRepository<T, String> repository, List<T> entityList) throws CodenfastException {
        try {
            if (CollectionUtils.isNotEmpty(entityList)) {
                for (T entity : entityList) {
                    update(repository, entity);
                }
            }
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    public T delete(JpaRepository<T, String> repository, String id) throws CodenfastException {
        try {
            Optional<T> entityOptional = repository.findById(id);
            if (entityOptional.isEmpty() || (Boolean) MethodUtils.invokeMethod(entityOptional.get(), "getPassive")) {
                throw new CodenfastException(String.format("There is no entity: %s", id));
            }
            T ref = entityOptional.get();
//            if (islemYapan != null) {
//                MethodUtils.invokeMethod(entityOptional.get(), "setGuncelleyen", islemYapan);
//            }
            MethodUtils.invokeMethod(entityOptional.get(), "setPassive", Boolean.TRUE);
            return ref;
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    public List<T> delete(JpaRepository<T, String> repository, List<T> entityList) throws CodenfastException {
        try {
            if (CollectionUtils.isNotEmpty(entityList)) {
                for (T entity : entityList) {
                    String id = (String) MethodUtils.invokeMethod(entity, "getId");
                    delete(repository, id);
                }
            }
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    @SuppressWarnings("java:S1172")

    public List<T> grid(Class<T> clazz, JpaRepository<T, String> repository, RequestGrid requestGrid) throws CodenfastException {
        try {
            return ((BaseRepository<T>) repository).grid(clazz, requestGrid.getPropertyList(), requestGrid.getPage(), requestGrid.getPageSize(), requestGrid.getSortField(), requestGrid.getSortOrder(), requestGrid.getFilters());
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }

    @SuppressWarnings("java:S1172")

    public TableModel<T> gridTableModel(Class<T> clazz, JpaRepository<T, String> repository, RequestGrid requestGrid) throws CodenfastException {
        try {
            TableModel<T> tableModel = new TableModel<>();
            BaseRepository<T> baseRepository = (BaseRepository<T>) repository;
            CompletableFuture<Void> listFuture = CompletableFuture.runAsync(() -> {
                try {
                    tableModel.setData(baseRepository.grid(clazz, requestGrid.getPropertyList(), requestGrid.getPage(), requestGrid.getPageSize(), requestGrid.getSortField(), requestGrid.getSortOrder(), requestGrid.getFilters()));
                } catch (Exception e) {
                    throw new CompletionException(e);
                }
            });
            CompletableFuture<Void> countFuture = CompletableFuture.runAsync(() -> {
                try {
                    int count = baseRepository.gridCount(clazz, requestGrid.getFilters()).intValue();
                    tableModel.setCount(count);
                } catch (Exception e) {
                    throw new CompletionException(e);
                }
            });
            CompletableFuture.allOf(listFuture, countFuture).join();
            return tableModel;
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }


    public void updateSubList(BaseService subService, EntityModel parentEntity, String parentProperty ,List newList) throws CodenfastException {
        try {
            RequestGrid requestGrid = RequestGrid.getByRefId("webSite", parentEntity.getId());
            List<EntityModel> willDeleteSubList = subService.grid(requestGrid);
            willDeleteSubList.removeAll(newList);
            subService.delete(willDeleteSubList);
            String setParentEntityMethodName = StringConstant.SET + StringUtils.capitalize(parentProperty);
            for (Object objectRef : newList) {
                MethodUtils.invokeMethod(objectRef, setParentEntityMethodName, parentEntity);
            }
            subService.update(newList);
        } catch (Exception e) {
            throw new CodenfastException(e);
        }
    }
}
