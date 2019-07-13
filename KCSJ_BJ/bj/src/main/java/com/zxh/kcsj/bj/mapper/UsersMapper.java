package com.zxh.kcsj.bj.mapper;

import model.UsersModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    @Select("select pwd from users where uid = #{uid} and city = #{city}")
    String getPwd(@Param("uid")String uid,@Param("city")String city);

    @Select("select name from users where uid = #{uid}")
    String getName(@Param("uid")String uid);

    @Select("select * from users")
    List<UsersModel> getAllUsers();

    @Select("select * from users where uid = #{uid}")
    List<UsersModel> getUsrInfo(@Param("uid")String uid);

    @Insert("insert into users (uid, pwd, city, phnum, address, name)" +
            "values(#{uid}, #{pwd}, #{city}, #{phnum}, #{address}, #{name})")
    int addUser(@Param("uid")String uid,@Param("pwd")String pwd,@Param("city")String city,
                @Param("phnum")String phnum,@Param("address")String address,@Param("name")String name);

    @Update("update Users set pwd = #{pwd},city = #{city},phnum = #{phnum}," +
            "address = #{address},name = #{name} where uid = #{uid}")
    int updateUser(@Param("uid")String uid,@Param("pwd")String pwd,@Param("city")String city,
                   @Param("phnum")String phnum,@Param("address")String address,@Param("name")String name);

    @Delete("delete from Users where uid = #{uid}")
    int deleteUser(@Param("uid")String uid);
}
