package api;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import constants.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author master
 * 响应类
 */
public class Api {
    /**
     * 通用成功返回
     */
    public static final String SUCCESS_MESSAGE = "success";

    /**
     * 通用失败返回
     */
    public static final String FAIL_MESSAGE = "fail";

    public static String success() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", Constant.SUCCESS);
        map.put("message", SUCCESS_MESSAGE);
        return JSONObject.toJSONString(map);
    }

    public static String success(int status, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("message", SUCCESS_MESSAGE);
        map.put("data", data);
        return JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullBooleanAsFalse);
    }

    public static String success(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", Constant.SUCCESS);
        map.put("message", message);
        return JSONObject.toJSONString(map);
    }

    public static String success(Object data) {
        return success(Constant.SUCCESS, data);
    }

    public static String error() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", Constant.FAIL);
        map.put("message", FAIL_MESSAGE);
        return JSONObject.toJSONString(map);
    }

    public static String error(int status, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("message", message);
        return JSONObject.toJSONString(map);
    }

    public static String error(String message) {
        return error(Constant.FAIL, message);
    }


}
