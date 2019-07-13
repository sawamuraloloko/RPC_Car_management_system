package service;

import model.PoliceModel;

import java.util.List;

public interface PolicesService {
    Boolean loginPo(String pid,String pwd);

    List<PoliceModel> getPo();
    List<PoliceModel> getPoInfo(String pid);
    int updatePo(String pid,String pwd,String city);
    int deletePo(String pid);
    int addPo(String pid,String pwd,String city);

}
