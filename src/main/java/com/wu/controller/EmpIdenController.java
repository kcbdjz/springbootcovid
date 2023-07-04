package com.wu.controller;


import com.wu.pojo.Epidemic;
import com.wu.pojo.PageBean;
import com.wu.pojo.Result;
import com.wu.service.impl.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empiden")
public class EmpIdenController {

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

//    @GetMapping("/LineVO")
//    public LineVO getLineVO(){
//        return this.chartService.lineVOList();
//    }
//    @GetMapping("/PieVO")
//    public List<PieVo> getPieVO(){
//        return this.chartService.pieVOMap();
//    }
//    @GetMapping("/findById/{id}")
//    public Epidemic findById(@PathVariable("id") Integer id){
//        return mapper.selectById(id);
//    }
//
//    @PutMapping("/update")
//    public String update(@RequestBody Epidemic empIden){
//
//        int result=mapper.updateById(empIden);
//        if (result==1){
//            return "success";
//        }else {
//            return "error";
//        }
//    }
//
//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable("id")Long id){
//        mapper.deleteById(id+"L");
//    }
//
//    @GetMapping("/search/{searchkey}/{stext}")
//    public List<Epidemic> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
//        QueryWrapper<Epidemic> userQueryWrapper = Wrappers.query();
//        userQueryWrapper.like(searchkey,stext);
//        return mapper.selectList(userQueryWrapper);
//    }
}

