package com.bdqn.exception;

/**
 * @Author ldwjava
 * @Date 2019/5/14 14:09
 * @Desc TODO
 **/

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
