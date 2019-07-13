package com.zxh.kcsj.sh.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {
    @Select("select pwd from Admin where id = #{id}")
    String getPwd(@Param("id")int id);

}
