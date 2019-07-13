package com.zxh.kcsj.sh.controller;


import model.CarsModel;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.CarsService;

import java.util.List;

@RestController
@RequestMapping(value = "/CarsBJ")
public class CarsControllerBJ {
    @Reference(version = "1.0.0", url = "dubbo://47.93.249.126:20880")
    private final CarsService carsService;

    public CarsControllerBJ(CarsService carsService) {
        this.carsService = carsService;
    }

    @RequestMapping(value = "/getUserCars")
    @ResponseBody
    public List<CarsModel> getUserCar(String uid){
        return carsService.getUserCar(uid);
    }

    @RequestMapping(value = "/addCar")
    @ResponseBody
    public Boolean addCar(String cid,String city,String uid,String color){
        if(carsService.addCar(cid, city, uid, color)>0)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/isExist")
    @ResponseBody
    public String isCarExist(String cid){
        return carsService.isCarExist(cid);
    }


}
