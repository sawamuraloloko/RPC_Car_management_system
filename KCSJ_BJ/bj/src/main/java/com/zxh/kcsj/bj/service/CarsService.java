package com.zxh.kcsj.bj.service;

import com.zxh.kcsj.bj.mapper.CarsMapper;
import model.CarsModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class CarsService implements service.CarsService {
    private final CarsMapper carsMapper;

    @Autowired
    public CarsService(CarsMapper carsMapper) {
        this.carsMapper = carsMapper;
    }

    public String isCarExist(String cid) {
        if(carsMapper.findOwner(cid) != null)
            return carsMapper.findOwner(cid);
        else
            return null;
    }

    public List<CarsModel> getUserCar(String uid) {
        return carsMapper.getUserCars(uid);
    }

    public int addCar(String cid, String city, String uid, String color) {
        return carsMapper.addCar(cid, city, uid, color);
    }
}
