package com.zxh.kcsj.sh.mapper;

import model.CarsModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface CarsMapper {
    @Select("select uid from Cars where cid = #{cid}")
    String findOwner(@Param("cid") String cid);

    @Select("select * from Cars where uid = #{uid}")
    List<CarsModel> getUserCars(@Param("uid") String uid);

    @Insert("insert into Cars (cid, city, uid, color)" +
            "values(#{cid}, #{city}, #{uid}, #{color})")
    int addCar(@Param("cid") String cid, @Param("city") String city, @Param("uid") String uid, @Param("color") String color);
}
