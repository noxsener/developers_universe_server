package com.codenfast.developersuniverse.common.converter;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.annotation.DtoConvertEager;
import com.codenfast.developersuniverse.annotation.DtoDontConvert;
import com.codenfast.developersuniverse.annotation.StringForceLowercase;
import com.codenfast.developersuniverse.annotation.StringForceUppercase;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.utils.StringConstant;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class EntityToDto<T> {

    public List <T>  convertToDtoCollection(List <EntityModel>  entityList, Class <T>  dtoClass) throws CodenfastException {
        List <T>  result = new java.util.ArrayList<>(entityList.size());
        for (Object t : entityList) {
            result.add(convertToDto(t, dtoClass));
        }
        return result;
    }

    public List <T>  convertToDtoCollection(List <EntityModel>  entityList, Class <T>  dtoClass, List<String> propertyList) throws CodenfastException {
        List <T>  result = new java.util.ArrayList<>(entityList.size());
        for (Object t : entityList) {
            result.add(convertToDto(t, dtoClass, propertyList));
        }
        return result;
    }

    public T convertToDto(Object entity, Class <T>  dtoClass) throws CodenfastException {
        try {
            if(entity == null) {
                return null;
            }

            T dto = getContstructor(dtoClass);
            for (Field field : entity.getClass().getDeclaredFields()) {
                if (field.getName().startsWith("$")
                        || field.isAnnotationPresent(DtoDontConvert.class)
                        || (field.isAnnotationPresent(ManyToOne.class)
                        || field.isAnnotationPresent(OneToOne.class)
                        || field.isAnnotationPresent(OneToMany.class)
                        || field.isAnnotationPresent(ManyToMany.class))
                        && !field.isAnnotationPresent(DtoConvertEager.class)) {
                    continue;
                }
                Object propertyNewValue = null;
                try {
                    propertyNewValue = getter(entity, field.getName());
                } catch (Exception e) {
                    // Entity ve DTO üzerinde olmayan property (muhtemel hibernate)
                    continue;
                }
                if (propertyNewValue == null) {
                    continue;
                }
                if (field.isAnnotationPresent(StringForceUppercase.class) && propertyNewValue instanceof String && StringUtils.isNotBlank(propertyNewValue.toString())) {
                    propertyNewValue = propertyNewValue.toString().toUpperCase();
                }
                if (field.isAnnotationPresent(StringForceLowercase.class) && propertyNewValue instanceof String && StringUtils.isNotBlank(propertyNewValue.toString())) {
                    propertyNewValue = propertyNewValue.toString().toLowerCase();
                }
                setter(dto, field.getName(), propertyNewValue);
            }
            return dto;
        } catch (Exception e) {
            log.error("{} {}",entity, dtoClass);
            log.error(e.getMessage(), e);
            throw new CodenfastException(e);
        }
    }

    private T getContstructor(Class<T> dtoClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return ConstructorUtils.invokeConstructor(dtoClass);
    }

    public T convertToDto( Object entity, Class <T>  dtoClass, List<String> propertyList) throws CodenfastException {
        try {
            if(entity == null) {
                return null;
            }
            T dto = convertToDto(entity, dtoClass);
            if (CollectionUtils.isEmpty(propertyList)) {
                return dto;
            }

            for (String propertyName : propertyList) {
                extractData(entity, dto, propertyName);
            }
            return dto;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e);
        }
    }

    public T convertToDto( Object entity, T  dtoClass, List<String> propertyList) throws CodenfastException {
        try {
            if (CollectionUtils.isEmpty(propertyList)) {
                return convertToDto(entity, (Class<T>) dtoClass.getClass());
            }

            for (String propertyName : propertyList) {
                extractData(entity, dtoClass, propertyName);
            }
            return dtoClass;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e);
        }
    }

    private void extractData( Object entity, Object dto, String propertyName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, CodenfastException, InstantiationException {
        try {
            if (!propertyName.contains(".")) {
                Class<?> subType = entity.getClass().getDeclaredField(propertyName).getType();
                if (subType.getPackageName().contains("common.entity")) {
                    Class<?> subDto = Class.forName(subType.getPackageName().replace("common.entity", "entitydto") + "." + subType.getSimpleName() + "Dto");
                    EntityToDto subEntityToSubDto = new EntityToDto();
                    Object subDtoInstance = subEntityToSubDto.convertToDto(getter(entity, propertyName), subDto);
                    setter(dto, propertyName, subDtoInstance);
                } else {
                    if (entity.getClass().getDeclaredField(propertyName).isAnnotationPresent(StringForceUppercase.class)
                            && getter(entity, propertyName) instanceof String && StringUtils.isNotBlank(getter(entity, propertyName).toString())) {
                        setter(dto, propertyName, ((String) getter(entity, propertyName)).toUpperCase());
                    } else {
                        setter(dto, propertyName, getter(entity, propertyName));
                    }
                }
            } else {
                int seperator = propertyName.indexOf('.');
                String joinProperty = propertyName.substring(0, seperator);
                String joinPropertyProperty = propertyName.substring(seperator + 1);
//            Object subObj = MethodUtils.invokeMethod(dto, getGetterMethodName(joinProperty));
//            if (subObj == null) {
//                subObj = ConstructorUtils.invokeConstructor(dto.getClass().getDeclaredField(joinProperty).getType());
//                setter(dto, joinProperty, subObj);
//            }
                Class<?> subType = entity.getClass().getDeclaredField(joinProperty).getType();
                if (subType.getPackageName().contains("common.entity")) {
                    EntityToDto subEntityToSubDto = new EntityToDto();
                    Object subDtoInstance = null;
                    if (getter(dto, joinProperty) == null) {
                        Class<?> subDto = Class.forName(subType.getPackageName().replace("common.entity", "entitydto") + "." + subType.getSimpleName() + "Dto");
                        subDtoInstance = subEntityToSubDto.convertToDto(getter(entity, joinProperty), subDto, Collections.singletonList(joinPropertyProperty));
                    } else {
                        subDtoInstance = subEntityToSubDto.convertToDto(getter(entity, joinProperty), getter(dto, joinProperty), Collections.singletonList(joinPropertyProperty));
                    }
                    setter(dto, joinProperty, subDtoInstance);
                } else {
                    setter(dto, joinProperty, getter(entity, propertyName));
                }
            }
        } catch (Exception e) {
            log.error("{} {} {}",entity, dto, propertyName);
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private Object setter(Object object,String property, Object value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return MethodUtils.invokeMethod(object, getSetterMethodName(property), value);
    }

    private Object getter(Object object, String property) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return MethodUtils.invokeMethod(object, getGetterMethodName(property));
    }

    private String getGetterMethodName(String propertyName) {
        return StringConstant.GET + StringUtils.capitalize(propertyName);
    }

    private String getSetterMethodName(String propertyName) {
        return StringConstant.SET + StringUtils.capitalize(propertyName);
    }

    private Class <?>  getPropertyClass(Object entity, String property) throws NoSuchFieldException {
        return entity.getClass().getDeclaredField(property).getType();
    }

    private Class <?>  getDtoClass(Class <?>  clazz) throws ClassNotFoundException {
        return Class.forName(clazz.getPackageName().replace("common.entity","entitydto")+"."+clazz.getSimpleName()+"Dto");
    }
}
