package com.zxh.kcsj.sh.mapper;

import model.PoliceModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface PolicesMapper {
    @Select("select pwd from Polices where pid = #{pid}")
    String getPwd(@Param("pid") String pid);

    @Select("select * from Polices")
    List<PoliceModel> getAllPo();

    @Select("select * from Polices where pid = #{pid}")
    List<PoliceModel> getPoInfo(@Param("pid")String pid);

    @Insert("insert into Polices (pid, pwd, city)" + "values(#{pid}, #{pwd}, #{city})")
    int addPo(@Param("pid") String pid, @Param("pwd") String pwd, @Param("city") String city);

    @Delete("delete from Polices where pid = #{pid}")
    int deletePo(@Param("pid") String pid);

    @Update("update Polices set pwd = #{pwd},city = #{city} where pid = #{pid}")
    int updatePo(@Param("pid") String pid, @Param("pwd") String pwd, @Param("city") String city);
}
