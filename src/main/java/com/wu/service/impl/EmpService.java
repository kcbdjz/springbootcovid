package com.wu.service.impl;

import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.PageBean;
import com.wu.pojo.Result;

import java.util.List;

public interface EmpService {
    PageBean findAll(Integer page , Integer size);

    int insert(HealthCheckIn emp);

    HealthCheckIn selectById(Integer id);

    int updateById(HealthCheckIn emp);

    void deleteById(long id);

    List<HealthCheckIn> search(String searchkey, String stext);
}
