package com.ecin520.client.util;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;


/**定义全局异常处理类
 * @author NICE*/
@RestControllerAdvice
public class ExceptionHandle {

    /**
     * 无权限抛出的异常
     * */
    @ExceptionHandler
    public String errorHandler(AuthorizationException e){
        return "Sorry,you don't have permission.";
    }

    @ExceptionHandler
    public HashMap<Integer, String> unknownAccountException(UnknownAccountException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Unknown Account.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> incorrectCredentialsException(IncorrectCredentialsException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Password Wrong.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> lockedAccountException(LockedAccountException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Account Locked.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> excessiveAttemptsException(ExcessiveAttemptsException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Too Much Input Wrong.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> authenticationException (AuthenticationException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Username Or Password Wrong.");
        return map;
    }
}
