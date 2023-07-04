package com.wu.service.impl.impl;

import com.wu.mapper.EpidemicMapper;
import com.wu.pojo.Epidemic;
import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.PageBean;
import com.wu.service.impl.EpidemicService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpidemicServiceImol implements EpidemicService {

    @Autowired
    EpidemicMapper epidemicMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

        //      计算信息总数；
        long count = epidemicMapper.count();

        //        获取结果列表
        Integer start = page * size;
        List<Epidemic> list = epidemicMapper.findAll(start, size);
        for (Epidemic i : list) {
            if (i.getSex().equals("1")) {
                i.setSex("男");
            } else i.setSex("女");
        }
        //        封装进pageBeam
        PageBean pageBean = new PageBean(count,list);

        return pageBean;
    }

    @Override
    public int insert(Epidemic emp) {
        try {
            if(emp.getSex().equals("男")){
                emp.setSex("1");
            }else emp.setSex("0");
            epidemicMapper.insert(emp);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }
}
