package com.project.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/20.
 */
public interface userServiceInterface {
    int adduser(String user_name,String user_sex,String user_openid,String user_headimgurl,Date user_registertime);
    int getUserOpenid(String openuid);
    int getUserSchoolCount(String oprnId);
    String getMoney(String openid);
    int selectSchoolId(String openId);
    int selectSchoolCount(String openId);
    int updateMoney(int money,String openid);
    int deletenull();
    List<HashMap> getUserList(int page, int size);
    int getUserCount();
    int deleteUser(int id);
    List<HashMap> getUserById(int id);
    int updateUser(String money,int id );
}
