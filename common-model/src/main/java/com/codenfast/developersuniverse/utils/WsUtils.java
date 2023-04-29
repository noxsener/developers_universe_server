package com.codenfast.developersuniverse.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.TimeZone;


public class WsUtils {
    public static ObjectMapper getObjectMapper(TimeZone timeZone){
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = DateUtil.iso8601Format;
        simpleDateFormat.setTimeZone(timeZone);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper;
    }

    public static ObjectMapper getObjectMapperUTC(TimeZone timeZone){
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = DateUtil.iso8601FormatFromUTC;
        simpleDateFormat.setTimeZone(timeZone);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper;
    }

    public static ObjectMapper getObjectMapper(){
        return getObjectMapper(TimeZone.getTimeZone("UTC"));
    }

    public static ObjectMapper getObjectMapperUTC(){
        return getObjectMapperUTC(TimeZone.getTimeZone("UTC"));
    }
}
