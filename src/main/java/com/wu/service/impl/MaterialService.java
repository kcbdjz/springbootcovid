package com.wu.service.impl;

import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.MaterialManage;
import com.wu.pojo.PageBean;

import java.util.List;

public interface MaterialService {

    PageBean findAll(Integer page, Integer size);

    int insert(MaterialManage emp);

    MaterialManage selectById(Integer id);

    int updateById(MaterialManage emp);

    void deleteById(Long id);

    List<MaterialManage> search(String searchkey, String stext);
}
