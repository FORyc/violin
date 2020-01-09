package util;

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

    /**
     * 不带参数的post请求
     * @param url 请求的url
     * @return 默认返回String字符串
     */
    public static String doPost(String url){
        return doPost(url, String.class);
    }

    /**
     *  发送无参数的post请求，并返回指定类型的数据对象
     * @param url 请求的url
     * @param tClass 所要返回的对象类型
     * @return 指定类型的数据对象
     */
    public static <T> T doPost(String url, Class<T> tClass){
        return doPostBodyParams(url, tClass, null);
    }

    /**
     * 带参数的post请求，参数在请求体中
     * @param url 请求的url
     * @param tClass 所要返回的对象类型
     * @param params 参数列表
     * @return 指定类型的数据对象
     */
    public static <T> T doPostBodyParams(String url, Class<T> tClass, Map<String, ?> params){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, params, tClass);
    }

    /**
     * 带参数的post请求，请求体参数为一个实体
     * @param url 请求的url
     * @param tClass 所要返回的对象类型
     * @param object 作为参数传递的实体类
     * @return 指定类型的数据对象
     */
    public static <T> T doPostBodyParams(String url, Class<T> tClass, Object object){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, object, tClass);
    }

    /**
     * 带蚕食的post请求，参数在url中
     * @param url 请求的url
     * @param tClass 所要返回的对象类型
     * @param params 参数列表
     * @return 指定类型的数据对象
     */
    public static <T> T doPostUrlParams(String url, Class<T> tClass, Map<String, ?> params){
        if(params != null && params.size() > 0){
            StringBuilder sb = new StringBuilder();
            sb.append("?");
            for (Map.Entry<String, ?> next : params.entrySet()) {
                sb.append(next.getKey()).append("=").append(next.getValue()).append("&");
            }
            url += sb.toString();
            if(params.size() > 1){
                url = url.substring(0, url.lastIndexOf("&"));
            }
        }
        return doPost(url, tClass);
    }

}
