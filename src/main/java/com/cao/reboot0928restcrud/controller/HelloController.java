package com.cao.reboot0928restcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {



//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Map<String,Object> map){
        map.put("hello","你好");
        map.put("users", Arrays.asList("曹琮皓","李心怡","刘晶旭"));
        return "success";
    }


}
