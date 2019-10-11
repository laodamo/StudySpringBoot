package com.cao.reboot0928restcrud.controller;

import com.cao.reboot0928restcrud.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler{

//    @ResponseBody
//    @ExceptionHandler(UserNotExitException.class)
//    public Map<String,Object> handlerException(Exception e){
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("code","usernotexit");
//        map.put("message","my  "+e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExitException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        request.setAttribute("javax.servlet.error.status_code",511);
        map.put("code","usernotexit");
        map.put("message","我的错误信息");
        //转发给错误处理器，由错误处理器添加到错误信息中
        request.setAttribute("etc",map);
        return "forward:/error";
    }

}
