package com.zxh.kcsj.bj.controller;


import com.zxh.kcsj.bj.service.UsersService;
import model.UsersModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/UserBJ")
public class UsersControllerBJ {
    private final UsersService usersService;

    public UsersControllerBJ(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/Login")
    @ResponseBody
    public Boolean UserBJLogin(String uid,String pwd,String city){
        return usersService.loginUs(uid,pwd,city);
    }

    @RequestMapping(value = "/getName")
    @ResponseBody
    public String getName(String uid){
        return usersService.getName(uid);
    }

    @RequestMapping(value = "/getUsrInfo")
    @ResponseBody
    public List<UsersModel> getUsrInfo(String uid) { return usersService.getUsrInfo(uid); }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public Boolean addUser(String uid,String pwd,String city,String phnum,String address,String name){
        if(usersService.addUs(uid, pwd, city, phnum, address, name)>0)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public Boolean updateUser(String uid,String pwd,String city,String phnum,String address,String name){
        if(usersService.updateUs(uid, pwd, city, phnum, address, name)>0)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public Boolean deleteUser(String uid){
        if(usersService.deleteUs(uid)>0)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/getAllUsers")
    @ResponseBody
    public List<UsersModel> getAllUser(){
        return usersService.getUs();
    }


}
