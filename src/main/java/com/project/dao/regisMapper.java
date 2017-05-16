package com.project.dao;

import com.alibaba.druid.util.H2Utils;
import com.project.model.regis;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface regisMapper {
    int deleteByPrimaryKey(Integer regisId);

    int insert(String name,int status);

    int insertSelective(regis record);

    regis selectByPrimaryKey(Integer regisId);

    int updateByPrimaryKeySelective(regis record);

    int updateByPrimaryKey(regis record);
    List<HashMap> getreGisList();
    int getRegisCount();
    List<HashMap> serchRegis(String regisname);
    String getRegisName(int regisId);
    List<HashMap>getDocmessage(int DocId);

    List<HashMap> getreGisListM(int page,int size);

    int getRegisCountM();
    int deleteById(int id);
    List<HashMap> getlistById(int id);
    int updateById(String name,int status,int id);

}