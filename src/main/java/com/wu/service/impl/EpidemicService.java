package com.wu.service.impl;

import com.wu.pojo.Epidemic;
import com.wu.pojo.PageBean;

public interface EpidemicService {
    PageBean findAll(Integer page, Integer size);

    int insert(Epidemic empIden);
}
