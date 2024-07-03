package com.neusoft.nepm.common.utils;

import java.util.List;
import java.util.Map;

import com.neusoft.nepm.po.Mail;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.json.JsonMapper;


public class JsonUtil {

    private static final JsonMapper MAPPER = new JsonMapper();

    private static final JsonMapper MAPPER_NON_NULL = new JsonMapper();

    static {
        // 配置忽略未知属性
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER_NON_NULL.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 设置为不含为null的属性
        MAPPER_NON_NULL.setSerializationInclusion(Include.NON_NULL);
    }

    /**
     * 将对象转换成json字符串
     *
     * @param obj 对象数据
     * @return json字符串
     */
    public static String objToStr(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象转换成json字符串（不含为null的属性）
     *
     * @param obj 对象数据
     * @return json字符串
     */
    public static String objToStrNonNull(Object obj) {
        try {
            return MAPPER_NON_NULL.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象转换成byte数组
     *
     * @param obj 对象数据
     * @return byte数组
     */
    public static byte[] objToBytes(Object obj) {
        try {
            return MAPPER.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象转换成byte数组（不含为null的属性）
     *
     * @param obj 对象数据
     * @return byte数组
     */
    public static byte[] objToBytesNonNull(Object obj) {
        try {
            return MAPPER_NON_NULL.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json字符串转化为普通对象
     *
     * @param str json字符串数据
     * @param cls 对象类型
     * @return 转化的普通对象
     */
    public static <T> T strToPojo(String str, Class<T> cls) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return MAPPER.readValue(str, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json字符串转化为Map对象
     *
     * @param str json字符串数据
     * @return Map对象
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> strToMap(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return MAPPER.readValue(str, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json字符串转换成pojo对象list
     *
     * @param str json字符串数据
     * @param cls 对象泛型类型
     * @return List 返回对象集合
     */
    public static <T> List<T> strToList(String str, Class<T> cls) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, cls);
            return MAPPER.readValue(str, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json字符串转换成type指定类型的对象
     *
     * @param <T> 泛型参数
     * @param str json字符串
     * @param type 对象类型
     * @return 转化的对象
     * @author chzhou@iflytek.com
     * @since 1.7
     * @date 2021/8/14 12:49
     */
    public static <T> T strToObj(String str, Class<Mail> type) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return (T) MAPPER.readValue(str, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
