package com.example.springboot2.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

public final class JsonUtils {


    private static final SerializerFeature[] featuresWithNullValue = {SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty};

    /**
     * <B>方法名称：</B>将JSON字符串转换为实体对象<BR>
     * <B>概要说明：</B>将JSON字符串转换为实体对象<BR>
     *
     * @param data  JSON字符串
     * @param clzss 转换对象
     * @return T
     */
    public static <T> T convertJSONToObject(String data, Class<T> clzss) {
        T t = JSON.parseObject(data, clzss);
        return t;
    }

    /**
     * <B>方法名称：</B>将JSONObject对象转换为实体对象<BR>
     * <B>概要说明：</B>将JSONObject对象转换为实体对象<BR>
     *
     * @param data  JSONObject对象
     * @param clzss 转换对象
     * @return T
     */
    public static <T> T convertJSONToObject(JSONObject data, Class<T> clzss) {
        T t = JSONObject.toJavaObject(data, clzss);
        return t;
    }

    /**
     * <B>方法名称：</B>将JSON字符串数组转为List集合对象<BR>
     * <B>概要说明：</B>将JSON字符串数组转为List集合对象<BR>
     *
     * @param data  JSON字符串数组
     * @param clzss 转换对象
     * @return List<T>集合对象
     */
    public static <T> List<T> convertJSONToArray(String data, Class<T> clzss) {
        List<T> t = JSON.parseArray(data, clzss);
        return t;
    }

    /**
     * <B>方法名称：</B>将List<JSONObject>转为List集合对象<BR>
     * <B>概要说明：</B>将List<JSONObject>转为List集合对象<BR>
     *
     * @param data  List<JSONObject>
     * @param clzss 转换对象
     * @return List<T>集合对象
     */
    public static <T> List<T> convertJSONToArray(List<JSONObject> data, Class<T> clzss) {
        List<T> t = new ArrayList<T>();
        for (JSONObject jsonObject : data) {
            t.add(convertJSONToObject(jsonObject, clzss));
        }
        return t;

    }

    /**
     * <B>方法名称：</B>将对象转为JSON字符串<BR>
     * <B>概要说明：</B>将对象转为JSON字符串<BR>
     *
     * @param obj 任意对象
     * @return JSON字符串
     */
    public static String convertObjectToJSON(Object obj) {
        String text = JSON.toJSONString(obj);
        return text;
    }

    /**
     * <B>方法名称：</B>将对象转为(JSON字符串)<BR>
     * <B>概要说明：</B>将对象转为(JSON字符串)<BR>
     *
     * @param obj 任意对象
     * @return JSON字符串
     */
    public static String convertObjectToJSONBracket(Object obj) {
        String text = JSON.toJSONString(obj);
        return "(" + text + ")";
    }

    /**
     * <B>方法名称：</B>将对象转为JSONObject对象<BR>
     * <B>概要说明：</B>将对象转为JSONObject对象<BR>
     *
     * @param obj 任意对象
     * @return JSONObject对象
     */
    public static JSONObject convertObjectToJSONObject(Object obj) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
        return jsonObject;
    }


    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     *
     * @param obj
     * @return
     */
    public static String convertObjectToJSONWithNullValue(Object obj) {

        String text = JSON.toJSONString(obj, featuresWithNullValue);
        return text;

    }

    public static void main(String[] args) {
        System.err.println(System.getProperties());
    }
}
