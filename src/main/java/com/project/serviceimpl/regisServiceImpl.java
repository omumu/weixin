package com.project.serviceimpl;

import com.project.dao.regisMapper;
import com.project.service.regisServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/13.
 */
@Service
public class regisServiceImpl implements regisServiceInterface {
    @Autowired
    protected regisMapper regisMapper;
    public List<HashMap> getreGisList() {
        return regisMapper.getreGisList();
    }

    public int getRegisCount() {
        return regisMapper.getRegisCount();
    }

    public List<HashMap> serchRegis(String regisname) {
        return regisMapper.serchRegis(regisname);
    }

    public String getRegisName(int regisId) {
        return regisMapper.getRegisName(regisId);
    }

    public List<HashMap> getDocmessage(int DocId) {
        return regisMapper.getDocmessage(DocId);
    }

    public List<HashMap> getreGisListM(int page,int size) {
        return regisMapper.getreGisListM(page, size);
    }

    public int getRegisCountM() {
        return regisMapper.getRegisCountM();
    }

    public int deleteById(int id) {
        return regisMapper.deleteById(id);
    }

    public List<HashMap> getlistById(int id) {
        return regisMapper.getlistById(id);
    }

    public int updateById(String name, int status, int id) {
        return regisMapper.updateById(name, status, id);
    }

    public int insert(String name, int status) {
        return regisMapper.insert(name, status);
    }
}
