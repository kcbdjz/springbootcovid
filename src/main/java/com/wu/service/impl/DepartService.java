package com.wu.service.impl;

import com.wu.pojo.Department;
import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.PageBean;

import java.util.List;

public interface DepartService {
    List<String> getAll();

    Department selectById(Integer id);

    int updateById(Department emp);

    void deleteById(long id);

    int insert(Department emp);

    List<Department> list();
}
