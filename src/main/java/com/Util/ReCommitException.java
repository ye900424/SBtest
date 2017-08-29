package com.Util;

/**
 * Created by zhouzongkun on 2017/4/28.
 */
public class ReCommitException extends RuntimeException{
    public ReCommitException() {}

    public ReCommitException(String message) {
        super(message);
    }

    public ReCommitException(String message, Throwable cause) {
        super(message, cause);
    }

}
