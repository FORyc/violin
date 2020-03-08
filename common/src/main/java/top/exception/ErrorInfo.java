package top.exception;

/**
 * @author master
 */
public interface ErrorInfo {
    /**
     * 获取异常的状态码
     *
     * @return 返回状态码
     */
    int getErrorCode();

    /**
     * 获取异常的描述信息
     *
     * @return 异常的描述信息
     */
    String getErrorMessage();

    /**
     * 设置自定义异常描述信息
     *
     * @param message 自定义的异常描述信息
     * @return 异常类
     */
    ErrorInfo setErrorInfo(String message);
}
