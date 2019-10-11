package com.cao.reboot0928restcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        //公共的错误信息
        map.put("name","曹琮皓");
        map.put("university","nuc");
        //获取到由相应的自定义信息

        Map<String,Object> etc = (Map<String, Object>) webRequest.getAttribute("etc",0);
        map.put("etc",etc);
        return map;
    }
}
