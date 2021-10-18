package com.bjpowdernode.exception;

/**
 * @author gjd
 * @create 2021/10/14  10:57:02
 */

//当年龄有问题，抛出的异常
public class AgeException extends MyUserException{

    public AgeException() {

    }

    public AgeException(String message) {
        super(message);
    }
}
