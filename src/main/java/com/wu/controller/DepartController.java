package com.wu.controller;
import com.wu.pojo.Result;
import com.wu.service.impl.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    DepartService service;

    @GetMapping("/findAll")
    private Result findAll() {
        return Result.success(service.getAll());
    }
}
