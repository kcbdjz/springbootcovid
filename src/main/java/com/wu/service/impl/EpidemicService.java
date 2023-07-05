package com.wu.service.impl;

import com.wu.pojo.Epidemic;
import com.wu.pojo.LineVO;
import com.wu.pojo.PageBean;
import com.wu.pojo.PieVo;

import java.text.SimpleDateFormat;
import java.util.*;

public interface EpidemicService {
    PageBean findAll(Integer page, Integer size);

    int insert(Epidemic empIden);

    LineVO lineVOList();

    Epidemic selectById(Integer id);

    int updateById(Epidemic empIden);

    void deleteById(Long id);

    List<Epidemic> search(String searchkey, String stext);

    List<PieVo> pieVOMap();
}
