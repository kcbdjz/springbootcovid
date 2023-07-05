package com.wu.service.impl.impl;

import com.wu.mapper.MaterialMapper;
import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.MaterialManage;
import com.wu.pojo.PageBean;
import com.wu.service.impl.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service

public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

//      计算信息总数；
        long count = materialMapper.count();

//        获取结果列表
        Integer start = page*size;
        List<MaterialManage> list = materialMapper.findAll(start,size);

//        封装进pageBeam
        PageBean pageBean = new PageBean(count,list);

        return pageBean;
    }

    @Override
    public int insert(MaterialManage emp) {
        emp.setUpdateTime(new Date());
        try {
            materialMapper.insert(emp);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public MaterialManage selectById(Integer id) {
        MaterialManage emp = materialMapper.selectById(id);
        return emp;
    }

    @Override
    public int updateById(MaterialManage emp) {

        try {
            materialMapper.updateById(emp);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id){
        materialMapper.deleteById(id);
    }

    @Override
    public List<MaterialManage> search(String searchkey, String stext) {
        return materialMapper.search( searchkey,  stext) ;
    }

}
