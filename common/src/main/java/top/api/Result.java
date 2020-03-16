package top.api;

import top.constants.Constant;

/**
 * 通用返回实体类
 * @author 9527
 */
public class Result {

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
    private Object object;

    public static Result success(){
        Result result = new Result();
        result.setCode(Constant.SUCCESS);
        result.setMsg("success");
        return result;
    }

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(Constant.SUCCESS);
        result.setMsg("success");
        result.setObject(object);
        return result;
    }

    public static Result success(String msg){
        Result result = new Result();
        result.setCode(Constant.SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static Result error(){
        return error(Constant.FAIL, "fail");
    }

    public static Result error(String msg){
        return error(Constant.FAIL, msg);
    }

    public static Result error(int code, String msg){
        Result result = new Result();
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
