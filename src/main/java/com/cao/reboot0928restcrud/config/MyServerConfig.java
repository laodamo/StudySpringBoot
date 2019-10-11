package com.cao.reboot0928restcrud.config;

import com.cao.reboot0928restcrud.filter.MyFilter;
import com.cao.reboot0928restcrud.listener.MyListener;
import com.cao.reboot0928restcrud.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

    @Bean
    //注册三大组件 servlet
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
        return registrationBean;
    }

    @Bean
    //注册三大组件 filter
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return  registrationBean;
    }
    @Bean
    //注册三大组件 listener
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new MyListener());
        return registrationBean;
    }

    //配置嵌入式servlet配置
    @Bean
    public WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory>() {
            @Override
            public void customize(ConfigurableTomcatWebServerFactory factory) {
                factory.setPort(8083);
            }
        };

    }




}
