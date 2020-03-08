package top.exception;

import lombok.NoArgsConstructor;

/**
 * 业务异常基类
 *
 * @author master
 */
@NoArgsConstructor
public class BusinessException extends RuntimeException implements ErrorInfo {

    private ErrorInfo errorInfo;

    public BusinessException(ErrorInfo errorInfo, String message) {
        super(message);
        this.errorInfo = errorInfo;
        this.errorInfo.setErrorInfo(message);
    }

    public BusinessException(EmBusinessException exception) {
        super(exception.getErrorMessage());
        this.errorInfo = exception;
    }


    @Override
    public int getErrorCode() {
        return this.errorInfo.getErrorCode();
    }

    @Override
    public String getErrorMessage() {
        return this.errorInfo.getErrorMessage();
    }

    @Override
    public ErrorInfo setErrorInfo(String message) {
        return this.errorInfo.setErrorInfo(message);
    }
}
