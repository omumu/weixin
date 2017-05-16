package com.project.dao;

import com.project.model.user;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public interface userMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
    int adduser(String user_name,String user_sex,String user_openid,String user_headimgurl,Date user_registertime);
    int getUserOpenid(String openuid);
    int getUserSchoolCount(String oprnId);
    String getMoney(String openid);
    int selectSchoolId(String openId);
    int selectSchoolCount(String openId);
    int updateMoney(int money,String openid);
    int deletenull();
    List<HashMap> getUserList(int page,int size);
    int getUserCount();
    int deleteUser(int id);
    List<HashMap> getUserById(int id);
    int updateUser(String money,int id );

}