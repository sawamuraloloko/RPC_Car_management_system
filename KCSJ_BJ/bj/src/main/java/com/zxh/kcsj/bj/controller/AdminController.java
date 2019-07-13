package com.zxh.kcsj.bj.controller;


import com.zxh.kcsj.bj.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/Login")
    @ResponseBody
    public Boolean AdminLogin(int id, String pwd){
        return adminService.loginAd(id, pwd);
    }
}
