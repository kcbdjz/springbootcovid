package com.wu.service.impl.impl;

import com.wu.mapper.EmpIsMapper;
import com.wu.pojo.EmpIs;
import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.PageBean;
import com.wu.service.impl.EmpIsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpIsServiceImpl implements EmpIsService {

    @Autowired
    EmpIsMapper empIsMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

//      计算信息总数；
        long count = empIsMapper.count();

//        获取结果列表
        Integer start = page*size;
        List<EmpIs> list = empIsMapper.findAll(start,size);
        for (EmpIs i : list) {
            if (i.getSex().equals("1")){
                i.setSex("男");
            }else i.setSex("女");
        }

//        封装进pageBeam
        PageBean pageBean = new PageBean(count,list);

        return pageBean;
    }

    @Override
    public int insert(EmpIs empis) {
        try {
            if(empis.getSex().equals("男")){
                empis.setSex("1");
            }else empis.setSex("0");
            empIsMapper.insert(empis);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public EmpIs selectById(Integer id) {
        return empIsMapper.selectById(id);
    }

    @Override
    public int updateById(EmpIs emp) {
        try {
            empIsMapper.updateById(emp);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        empIsMapper.deleteById(id);
    }

    @Override
    public List<EmpIs> search(String searchkey, String stext) {
        return empIsMapper.search( searchkey,  stext) ;
    }
}
