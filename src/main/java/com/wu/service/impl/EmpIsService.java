package com.wu.service.impl;

import com.wu.pojo.EmpIs;
import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.PageBean;

import java.util.List;

public interface EmpIsService {
    PageBean findAll(Integer page, Integer size);

    int insert(EmpIs empis);

    EmpIs selectById(Integer id);

    int updateById(EmpIs emp);

    void deleteById(Long id);

    List<EmpIs> search(String searchkey, String stext);
}
