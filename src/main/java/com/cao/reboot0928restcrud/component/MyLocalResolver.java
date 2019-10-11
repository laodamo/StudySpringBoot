package com.cao.reboot0928restcrud.component;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自己的本地解析器
 */
public class MyLocalResolver implements LocaleResolver{
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取链接的值
        String mes = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        System.out.println(mes);
        if(!StringUtils.isEmpty(mes)){
            String[] s = mes.split("_");
            //将信息注入到local中
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }
}
