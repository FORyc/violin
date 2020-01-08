package util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 95271
 *
 * http 请求工具类
 */
public class HttpUtil {


    /**
     * 发送无参数的get请求
     * @param url 请求的url
     * @return 默认返回String字符串
     */
    public static String doGet(String url){
        return doGet(url, String.class);
    }

    /**
     * 发送无参数的get请求，并返回指定类型的数据对象
     * @param url 请求的url
     * @param tClass 所要返回的对象类型
     * @return 指定类型的的数据对象
     */
    public static <T> T doGet(String url, Class<T> tClass){
        return doGetParams(url, tClass, new HashMap<>());
    }

    /**
     * 发送带参数的get请求，并返回指定类型的数据对象
     * @param url 请求的url
     * @param tClass 所要返回的对象类型
     * @param params 参数列表
     * @return 指定类型的数据对象
     */
    public static <T> T doGetParams(String url, Class<T> tClass, Map<String, ?> params){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, tClass, params);
    }

    public static String doPost(String url){
        return doPost(url, String.class);
    }

    public static <T> T doPost(String url, Class<T> tClass){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, null, tClass);
    }

}
