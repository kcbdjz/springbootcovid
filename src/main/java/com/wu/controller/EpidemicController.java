package com.wu.controller;


import com.wu.pojo.*;
import com.wu.service.impl.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empiden")
public class EpidemicController {

    @Autowired
    EpidemicService epidemicService;
//    分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageBean pageBean = epidemicService.findAll(page,size);
        return Result.success(pageBean);
    }


    @PostMapping("/save")
    public String save(@RequestBody Epidemic empIden){
        int result = epidemicService.insert(empIden);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/LineVO")
    public LineVO getLineVO(){
        return epidemicService.lineVOList();
    }
    @GetMapping("/PieVO")
    public List<PieVo> getPieVO(){
        return this.epidemicService.pieVOMap();
    }
    @GetMapping("/findById/{id}")
    public Epidemic findById(@PathVariable("id") Integer id){
        return epidemicService.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Epidemic empIden){

        int result=epidemicService.updateById(empIden);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Long id){
        epidemicService.deleteById(id);
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<Epidemic> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        return epidemicService.search(searchkey,stext);
    }
}

