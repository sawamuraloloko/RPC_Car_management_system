package com.zxh.kcsj.sh.controller;



import model.PoliceModel;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.PolicesService;

import java.util.List;

@RestController
@RequestMapping(value = "/PoliceBJ")
public class PolicesControllerBJ {
    @Reference(version = "1.0.0", url = "dubbo://47.93.249.126:20880")
    private final PolicesService policesService;

    public PolicesControllerBJ(PolicesService policesService) {
        this.policesService = policesService;
    }

    @RequestMapping(value = "/Login")
    @ResponseBody
    public Boolean PoliceBJLogin(String pid,String pwd){
        return policesService.loginPo(pid, pwd);
    }

    @RequestMapping(value = "/getPolices")
    @ResponseBody
    public List<PoliceModel> getPolices(){
        return policesService.getPo();
    }

    @RequestMapping(value = "/getPoInfo")
    @ResponseBody
    public List<PoliceModel> getPoInfo(String pid){
        return policesService.getPoInfo(pid);
    }

    @RequestMapping(value = "/updatePolice")
    @ResponseBody
    public Boolean updatePo(String pid,String pwd,String city){
        if(policesService.updatePo(pid, pwd, city)>0)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/addPolice")
    @ResponseBody
    public Boolean addPo(String pid,String pwd,String city){
        if(policesService.addPo(pid, pwd, city)>0)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/deletePolice")
    @ResponseBody
    public Boolean deletePo(String pid){
        if(policesService.deletePo(pid)>0)
            return true;
        else
            return false;
    }


}
