package com.wu.controller;


import com.wu.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("Hello World");
        return Result.success();
    }
}
