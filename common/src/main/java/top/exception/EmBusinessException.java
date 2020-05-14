package top.exception;

import lombok.AllArgsConstructor;
import top.constants.Constant;

/**
 * 自定义异常枚举类
 *
 * @author master
 */
@AllArgsConstructor
public enum EmBusinessException implements ErrorInfo {
    // 通用错误
    DEFAULT_EXCEPTION(Constant.FAIL, "fail"),
    PARAMS_NOT_COMPLETE(Constant.FAIL, "参数不完整"),
    USER_NOT_FOUND(Constant.FAIL, "为查询到相关用户"),
    ;

    private int errCode;
    private String errMsg;

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errMsg;
    }

    @Override
    public ErrorInfo setErrorInfo(String message) {
        this.errMsg = message;
        return this;
    }
}
