package com.wu.controller;

import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.MaterialManage;
import com.wu.pojo.PageBean;
import com.wu.pojo.Result;
import com.wu.service.impl.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Material")
public class MaterialController {

    @Autowired
    MaterialService materialService;
    @GetMapping("/findAll/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageBean pageBean = materialService.findAll(page,size);
        return Result.success(pageBean);
    }


    @PostMapping("/save")
    public String save(@RequestBody MaterialManage emp){
        int result = materialService.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public MaterialManage findById(@PathVariable("id") Integer id){
        return materialService.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody MaterialManage emp){
        int result=materialService.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Long id){
        materialService.deleteById(id);
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<MaterialManage> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        List<MaterialManage> empList = materialService.search(searchkey,stext);
        return empList;
    }
}
