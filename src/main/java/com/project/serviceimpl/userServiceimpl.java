package com.project.serviceimpl;

import com.project.dao.userMapper;
import com.project.service.userServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/20.
 */
@Service
public class userServiceimpl implements userServiceInterface {
    @Autowired
    private userMapper userMapper;
    public int adduser(String user_name, String user_sex, String user_openid, String user_headimgurl, Date user_registertime) {
        return userMapper.adduser(user_name, user_sex, user_openid, user_headimgurl, user_registertime);
    }

    public int getUserOpenid(String openuid) {
        return userMapper.getUserOpenid(openuid);
    }

    public int getUserSchoolCount(String oprnId) {
        return userMapper.getUserSchoolCount(oprnId);
  }

    public String getMoney(String openid) {
        return userMapper.getMoney(openid);
    }

    public int selectSchoolId(String openId) {
        return userMapper.selectSchoolId(openId);
    }

    public int selectSchoolCount(String openId) {
        return userMapper.getUserSchoolCount(openId);
    }

    public int updateMoney(int money, String openid) {
        return userMapper.updateMoney(money, openid);
    }

    public int deletenull() {
        return userMapper.deletenull();
    }

    public List<HashMap> getUserList(int page, int size) {
        return userMapper.getUserList(page, size);
    }

    public int getUserCount() {
        return userMapper.getUserCount();
    }

    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    public List<HashMap> getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public int updateUser(String money, int id) {
        return userMapper.updateUser(money,id);
    }


}
