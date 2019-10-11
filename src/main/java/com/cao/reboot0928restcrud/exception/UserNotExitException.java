package com.cao.reboot0928restcrud.exception;

import java.io.Serializable;

public class UserNotExitException extends RuntimeException implements Serializable {

    public UserNotExitException() {
        super("用户不存在");
    }
}
