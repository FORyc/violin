package top.exception;

import top.constants.Constant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 自定义异常枚举类
 *
 * @author master
 */
@AllArgsConstructor
@NoArgsConstructor
public enum EmBusinessException implements ErrorInfo {
    // 通用错误
    DEFAULT_EXCEPTION(Constant.FAIL, "fail"),
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
