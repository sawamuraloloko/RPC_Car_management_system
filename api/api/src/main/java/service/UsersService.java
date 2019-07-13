package service;

import model.UsersModel;

import java.util.List;

public interface UsersService {
    Boolean loginUs(String uid,String pwd,String city);
    String getName(String uid);
    List<UsersModel> getUsrInfo(String uid);

    List<UsersModel> getUs();
    int updateUs(String uid,String pwd,String city,String phnum,String address,String name);
    int deleteUs(String uid);
    int addUs(String uid,String pwd,String city,String phnum,String address,String name);
}
