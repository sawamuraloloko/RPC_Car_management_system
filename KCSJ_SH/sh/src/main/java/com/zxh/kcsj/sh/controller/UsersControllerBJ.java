package com.zxh.kcsj.sh.controller;



import model.UsersModel;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.UsersService;


import java.util.List;

@RestController
@RequestMapping(value = "/UserBJ")
public class UsersControllerBJ {
    @Reference(version = "1.0.0", url = "dubbo://47.93.249.126:20880")
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
