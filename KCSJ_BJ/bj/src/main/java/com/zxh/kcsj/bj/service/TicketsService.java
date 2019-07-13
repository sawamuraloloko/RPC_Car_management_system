package com.zxh.kcsj.bj.service;


import com.zxh.kcsj.bj.mapper.TicketsMapper;
import model.TicketsModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@org.springframework.stereotype.Service
public class TicketsService implements service.TicketsService {
    private final TicketsMapper ticketsMapper;

    @Autowired
    public TicketsService(TicketsMapper ticketsMapper) {
        this.ticketsMapper = ticketsMapper;
    }

    public List<TicketsModel> getAllTct() {
        return ticketsMapper.getAllTct();
    }

    public List<TicketsModel> getUserTct(String uid) {
        return ticketsMapper.getUsrTct(uid);
    }

    public List<TicketsModel> getUTNow(String uid) { return ticketsMapper.getUTNow(uid); }

    public List<TicketsModel> getUTHistory(String uid) { return ticketsMapper.getUTHistory(uid); }

    public int addTct(String reason, String time, int charge, String cid, String pid, String state, String city,String uid) {
        return ticketsMapper.addTicket(reason, time, charge, cid, pid, state, city, uid);
    }

    public int updateTct(int id, String reason, String time, int charge, String cid, String pid, String state, String city) {
        return ticketsMapper.updateTicket(id, reason, time, charge, cid, pid, state, city);
    }
}
