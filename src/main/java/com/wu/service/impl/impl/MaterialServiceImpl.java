package com.wu.service.impl.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wu.mapper.MaterialMapper;
import com.wu.pojo.Epidemic;
import com.wu.pojo.Material;
import com.wu.pojo.PageBean;
import com.wu.service.impl.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

        //设置分页参数
        PageHelper.startPage(page, size);

        //查询
        List<Material> empList = materialMapper.list();
        Page<Material> p = (Page<Material>) empList;
        //封装到PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    /*
//      计算信息总数；
        long count = materialMapper.count();

//        获取结果列表
        Integer start = page * size;
        List<Material> list = materialMapper.findAll(start, size);

//        封装进pageBeam
        PageBean pageBean = new PageBean(count,list);

        return pageBean;*/
    }

    @Override
    public int insert(Material emp) {
        emp.setUpdateTime(new Date());
        try {
            materialMapper.insert(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public Material selectById(Integer id) {
        Material emp = materialMapper.selectById(id);
        return emp;
    }

    @Override
    public int updateById(Material emp) {

        try {
            materialMapper.updateById(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id){
        materialMapper.deleteById(id);
    }

    @Override
    public List<Material> search(String searchkey, String stext) {
        return materialMapper.search(searchkey, stext);
    }

}
