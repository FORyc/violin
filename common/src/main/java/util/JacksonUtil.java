package util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

/**
 * json 工具类
 * 主要使用Jackson的方式
 */
@Slf4j
public class JacksonUtil {


    private static final ObjectMapper mapper = new ObjectMapper();
    // 日起格式化
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // 初始化mapper对象的配置
    static {
        //对象的所有字段全部列入
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //取消默认转换timestamps形式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //忽略空Bean转json的错误
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
        mapper.setDateFormat(new SimpleDateFormat(DEFAULT_FORMAT));
        //mapper 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

    }

    /**
     *  object 转 jsonString
     * @param object 需要转换的对象
     * @return string
     */
    public static <T> String toJsonString(T object){
        Objects.requireNonNull(object);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Parse Object to String error", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  String 转指定类型的 bean
     * @param string 源字符串
     * @param tClass 需要被转换的数据类型
     * @return 指定类型的数据
     */
    public static <T> T string2Obj(String string, Class<T> tClass){
        try {
            return mapper.readValue(Objects.requireNonNull(string), Objects.requireNonNull(tClass));
        } catch (JsonProcessingException e) {
            log.error("Parse String to Object error", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  jsonString 转 指定类型的 list
     * @param string 待转换的jsonString
     * @param beanType 指定的数据类型
     * @return 指定数据类型的list列表
     */
    public static <T> List<T> jsonString2List(String string, Class<T> beanType){
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            return mapper.readValue(Objects.requireNonNull(string), javaType);
        } catch (JsonProcessingException e) {
            log.error("Parse String to List error", e);
            e.printStackTrace();
        }
        return null;
    }



}
