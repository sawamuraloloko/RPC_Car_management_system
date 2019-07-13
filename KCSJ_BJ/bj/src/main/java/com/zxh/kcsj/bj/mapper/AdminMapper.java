package com.zxh.kcsj.bj.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {
    @Select("select pwd from admin where id = #{id}")
    String getPwd(@Param("id")int id);

}
