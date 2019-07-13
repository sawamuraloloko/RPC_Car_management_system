package com.zxh.kcsj.sh.controller;


import com.zxh.kcsj.sh.service.CarsService;
import model.CarsModel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/CarsSH")
public class CarsControllerSH {
    private final CarsService carsService;

    public CarsControllerSH(CarsService carsService) {
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
