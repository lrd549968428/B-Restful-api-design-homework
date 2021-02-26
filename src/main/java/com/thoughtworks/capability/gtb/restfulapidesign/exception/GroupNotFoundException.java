package com.thoughtworks.capability.gtb.restfulapidesign.exception;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/26 2:48 下午
 */
public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException() {
    }

    public GroupNotFoundException(String message) {
        super(message);
    }

    public GroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupNotFoundException(Throwable cause) {
        super(cause);
    }

    public GroupNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
