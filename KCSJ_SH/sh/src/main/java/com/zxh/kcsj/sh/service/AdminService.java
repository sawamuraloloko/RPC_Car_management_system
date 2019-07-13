package com.zxh.kcsj.sh.service;


import com.zxh.kcsj.sh.mapper.AdminMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class AdminService implements service.AdminService{
    private final AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminMapper adminMapper){ this.adminMapper = adminMapper; }

    @Override
    public Boolean loginAd(int id, String pwd) {
        return pwd.equals(adminMapper.getPwd(id));
    }
}
