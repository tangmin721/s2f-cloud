package com.gasq.cloud.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangmin
 * @version V1.0
 * @Title: JacksonUtils.java
 * @Package com.gasq.cloud.common.utils
 * @Description:
 * @date 2017-04-13 16:28:04
 */
public class JacksonUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private JacksonUtils() {

    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    /**
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JacksonUtils obj2json fail:", e);
        }
        return result;
    }

    /**
     * json string convert to javaBean
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz) {
        T t = null;
        try {
            objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            throw new RuntimeException("JacksonUtils json2pojo fail:", e);
        }
        return t;
    }

    /**
     * json string convert to map
     */
    public static <T> Map<String, Object> json2map(String jsonStr) {
        Map map = null;
        try {
            map = objectMapper.readValue(jsonStr, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("JacksonUtils json2map fail:", e);
        }
        return map;
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) {
        Map<String, Map<String, Object>> map = null;
        try {
            map = objectMapper.readValue(jsonStr, new TypeReference<Map<String, T>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("JacksonUtils json2map fail:", e);
        }
        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
        List<Map<String, Object>> list = null;
        try {
            list = objectMapper.readValue(jsonArrayStr,
                    new TypeReference<List<T>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException("JacksonUtils json2list fail:", e);
        }
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }

    /**
     * map convert to javaBean
     */
    public static <T> T map2pojo(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
}
