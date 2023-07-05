package com.wu.service.impl.impl;

import com.wu.mapper.EpidemicMapper;
import com.wu.pojo.*;
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

    @Override
    public LineVO lineVOList() {
        LineVO lineVOList ;
        List<VO> voList= epidemicMapper.lineVOList();
        System.out.println(voList);
        String [] strings = new String[13];
        String [] [] strings1 = new String[13][5];
        for (int i = 6; i >= 0; i--) {

        }
//        1.把月份求出放到数组；
//        2.把健康状态放到数组；
//        3.封装
        return null;
    }

    @Override
    public Epidemic selectById(Integer id) {
        return epidemicMapper.selectById(id);
    }

    @Override
    public int updateById(Epidemic empIden) {
        try {
            if(empIden.getSex().equals("男")){
                empIden.setSex("1");
            }else empIden.setSex("0");
            epidemicMapper.updateById(empIden);
        }catch (Exception exception){
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        epidemicMapper.deleteById(id);
    }

    @Override
    public List<Epidemic> search(String searchkey, String stext) {
        return epidemicMapper.search( searchkey,  stext);
    }
}
