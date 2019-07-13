package service;

import model.CarsModel;

import java.util.List;

public interface CarsService {
    List<CarsModel> getUserCar(String uid);
    int addCar(String cid,String city,String uid,String color);
    String isCarExist (String cid);

}
