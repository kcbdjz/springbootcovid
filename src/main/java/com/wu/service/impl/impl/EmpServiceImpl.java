package com.wu.service.impl.impl;

import com.wu.mapper.EmpMapper;
import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.PageBean;
import com.wu.pojo.Result;
import com.wu.service.impl.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

//      计算信息总数；
        long count = empMapper.count();

//        获取结果列表
        Integer start = page*size;
        List<HealthCheckIn> list = empMapper.findAll(start,size);
        for (HealthCheckIn i : list) {
                if (i.getSex().equals("1")){
                    i.setSex("男");
                }else i.setSex("女");
        }

//        封装进pageBeam
        PageBean pageBean = new PageBean(count,list);

        return pageBean;
    }

    @Override
    public int insert(HealthCheckIn emp) {
        try {
            empMapper.insert(emp);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public HealthCheckIn selectById(Integer id) {
        HealthCheckIn emp = empMapper.selectById(id);
        return emp;
    }

    @Override
    public int updateById(HealthCheckIn emp) {

        try {
            empMapper.updateById(emp);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(long id) {
        empMapper.deleteById(id);
    }

    @Override
    public List<HealthCheckIn> search(String searchkey, String stext) {
        List<HealthCheckIn> empList = null;
        if (searchkey.equals("name")){
            empList = empMapper.selectByName(stext);
        }else if (searchkey.equals("createTime")){
            empList = empMapper.selectByCreateTime(stext);
        }else if (searchkey.equals("health")){
            empList = empMapper.selectByHealth(stext);
        }
        return empList;
    }
}
