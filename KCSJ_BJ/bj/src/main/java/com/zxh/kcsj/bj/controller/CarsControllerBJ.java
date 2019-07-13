package com.zxh.kcsj.bj.controller;

import com.zxh.kcsj.bj.service.CarsService;
import model.CarsModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/CarsBJ")
public class CarsControllerBJ {
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
