package top.api;

import top.constants.Constant;

/**
 * 通用返回实体类
 * @author 9527
 */
public class CommonResult<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 自定义内容
     */
    private T object;

    public static <T> CommonResult<T> success(){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(Constant.SUCCESS);
        result.setMsg("success");
        return result;
    }

    public static <T> CommonResult<T> success(T object){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(Constant.SUCCESS);
        result.setMsg("success");
        result.setObject(object);
        return result;
    }

    public static <T> CommonResult<T> success(String msg){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(Constant.SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static <T> CommonResult<T> error(){
        return error(Constant.FAIL, "fail");
    }

    public static <T> CommonResult <T> error(String msg){
        return error(Constant.FAIL, msg);
    }

    public static <T> CommonResult<T> error(int code, String msg){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
