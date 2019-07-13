package com.zxh.kcsj.sh.service;

import com.zxh.kcsj.sh.mapper.PolicesMapper;
import model.PoliceModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class PolicesService implements service.PolicesService {
    private final PolicesMapper policesMapper;

    @Autowired
    public PolicesService(PolicesMapper policesMapper) {
        this.policesMapper = policesMapper;
    }


    public Boolean loginPo(String pid, String pwd) {
        return pwd.equals(policesMapper.getPwd(pid));
    }


    public List<PoliceModel> getPo() {
        return policesMapper.getAllPo();
    }

    public List<PoliceModel> getPoInfo(String pid) { return policesMapper.getPoInfo(pid); }


    public int updatePo(String pid, String pwd, String city) {
        return policesMapper.updatePo(pid, pwd, city);
    }


    public int deletePo(String pid) {
        return policesMapper.deletePo(pid);
    }


    public int addPo(String pid, String pwd, String city) {
        return policesMapper.addPo(pid, pwd, city);
    }
}
