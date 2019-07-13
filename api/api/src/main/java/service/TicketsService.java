package service;

import model.TicketsModel;

import java.util.List;

public interface TicketsService {
    List<TicketsModel> getAllTct();
    List<TicketsModel> getUserTct(String uid);

    List<TicketsModel> getUTNow(String uid);
    List<TicketsModel> getUTHistory(String uid);

    int addTct(String reason,String time,int charge,String cid,String pid,String state,String city,String uid);
    int updateTct(int id,String reason,String time,int charge,String cid,String pid,String state,String city);

}
