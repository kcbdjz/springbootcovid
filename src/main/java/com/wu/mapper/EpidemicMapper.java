package com.wu.mapper;

import com.wu.pojo.Epidemic;
import com.wu.pojo.HealthCheckIn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EpidemicMapper {
    @Select("select count(*) from epidemic")
    long count ();

    @Select("select * from epidemic limit #{start},#{pageSize};")
    List<Epidemic> findAll(Integer start , Integer pageSize);

    @Insert("INSERT INTO epidemic (id ,name, sex, idcard,idate, place, phonenum,status , depart , register) VALUES (#{id},#{name}, #{sex}, #{idcard}, #{idate}, #{place}, #{phonenum}, #{status},#{depart}, #{register})")
    void insert(Epidemic emp);
}
