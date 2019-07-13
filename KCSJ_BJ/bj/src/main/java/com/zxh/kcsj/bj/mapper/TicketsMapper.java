package com.zxh.kcsj.bj.mapper;

import model.TicketsModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TicketsMapper {
    @Select("select * from tickets")
    List<TicketsModel> getAllTct();

    @Select("select * from tickets where uid = #{uid}")
    List<TicketsModel> getUsrTct(@Param("uid")String uid);

    @Select("select * from tickets where uid = #{uid} and state = '未缴费'")
    List<TicketsModel> getUTNow(@Param("uid") String uid);

    @Select("select * from tickets where uid = #{uid} and state = '已缴费'")
    List<TicketsModel> getUTHistory(@Param("uid") String uid);

    @Insert("insert into tickets (reason,time,charge,cid,pid,state,city,uid) " +
            "values(#{reason}, #{time}, #{charge}, #{cid}, #{pid}, #{state}, #{city}, #{uid})")
    int addTicket(@Param("reason")String reason,@Param("time")String time,@Param("charge")int charge,
                  @Param("cid")String cid,@Param("pid")String pid,@Param("state")String state,@Param("city")String city,
                  @Param("uid")String uid);

    @Update("update tickets set reason = #{reason},time = #{time},charge = #{charge},cid = #{cid},pid = #{pid}," +
            "state = #{state},city = #{city} where id = #{id}")
    int updateTicket(@Param("id")int id,@Param("reason")String reason,@Param("time")String time,@Param("charge")int charge,
                     @Param("cid")String cid,@Param("pid")String pid,@Param("state")String state,@Param("city")String city);
}
