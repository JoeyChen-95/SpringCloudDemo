package net.biancheng.c.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BaseException extends RuntimeException{
    /**
     * 错误状态码
     */
    private int errorCode;

    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public BaseException(int errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     * @param cause   根异常类（可以存入任何异常）
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
