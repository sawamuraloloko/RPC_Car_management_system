package com.zxh.kcsj.bj.service;

import com.zxh.kcsj.bj.mapper.UsersMapper;
import model.UsersModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class UsersService implements service.UsersService{
    private final UsersMapper usersMapper;

    @Autowired
    public UsersService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }


    public Boolean loginUs(String uid, String pwd, String city) {
        System.out.println(uid+pwd+city+"    "+usersMapper.getPwd(uid,city));
        return pwd.equals(usersMapper.getPwd(uid,city));
    }


    public String getName(String uid) {
        return usersMapper.getName(uid);
    }

    public List<UsersModel> getUsrInfo(String uid) { return usersMapper.getUsrInfo(uid); }

    public List<UsersModel> getUs() {
        return usersMapper.getAllUsers();
    }

    public int updateUs(String uid,String pwd,String city,String phnum,String address,String name) {
        return usersMapper.updateUser(uid,pwd,city,phnum,address,name);
    }


    public int deleteUs(String uid) {
        return usersMapper.deleteUser(uid);
    }


    public int addUs(String uid,String pwd,String city,String phnum,String address,String name) {
        return usersMapper.addUser(uid, pwd, city, phnum, address, name);
    }
}
