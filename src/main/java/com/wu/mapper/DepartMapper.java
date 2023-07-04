package com.wu.mapper;

import com.wu.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartMapper {

    @Select("select * from department")
    List<Department> selectList() ;
}
