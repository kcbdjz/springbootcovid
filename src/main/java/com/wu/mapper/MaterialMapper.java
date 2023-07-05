package com.wu.mapper;

import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.MaterialManage;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface MaterialMapper {
    @Select("select count(*) from material_manage")
    long count ();

    @Select("select * from material_manage limit #{start},#{pageSize};")
    List<MaterialManage> findAll(Integer start , Integer pageSize);

    @Insert("INSERT INTO material_manage (id , name , count , type , isImp , charge , cnum , updateTime) VALUES (#{id} , #{name} , #{count} , #{type} , #{isImp} , #{charge} , #{cnum} , #{updateTime} )" )
    void insert(MaterialManage emp);

    @Select("select * from material_manage where id = #{id}")
    MaterialManage selectById(Integer id);

    @Update("UPDATE material_manage  SET name = #{id} , count= #{id} , type= #{id} ,isImp= #{id} , charge= #{id} , cnum= #{id} , updateTime = #{updateTime}, updateTimeWHERE id = #{id}")
    void updateById(MaterialManage emp);

    @Delete("DELETE from material_manage WHERE id = #{id} ")
    void deleteById(long id);

    @Select("select * from material_manage where ${searchkey} = #{stext}")
    List<MaterialManage> search(String searchkey, String stext);
}
