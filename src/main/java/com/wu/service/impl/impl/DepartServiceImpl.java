package com.wu.service.impl.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wu.mapper.DepartMapper;
import com.wu.pojo.Department;
import com.wu.pojo.EmpIs;
import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.PageBean;
import com.wu.service.impl.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartMapper departMapper;
    @Override
    public List<String> getAll() {
        List<Department> list;
        List<String> name=new ArrayList<>();
        list= departMapper.selectList();
        for (Department de:list){
            name.add(de.getName());
        }
        return name;
    }

    @Override
    public int insert(Department emp) {
        try {
            departMapper.insert(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<Department> list() {
        //查询
        List<Department> empList = departMapper.selectList();

        return empList;
    }

    @Override
    public Department selectById(Integer id) {
        Department emp = departMapper.selectById(id);
        return emp;
    }

    @Override
    public int updateById(Department emp) {

        try {
            departMapper.updateById(emp);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(long id) {
        departMapper.deleteById(id);
    }

}
