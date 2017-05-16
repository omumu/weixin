package com.project.service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/13.
 */
public interface regisServiceInterface {
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
    int insert(String name,int status);

}
