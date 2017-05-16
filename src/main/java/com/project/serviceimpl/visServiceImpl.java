package com.project.serviceimpl;

import com.project.dao.visMapper;
import com.project.service.visServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/21.
 */
@Service
public class visServiceImpl implements visServiceInterface {

    @Autowired
    private visMapper visMapper;
    public int insertVis(String vis_name, String vis_doctor,Date vis_data, String vis_phone, String regis_name,int vis_school) {
        return visMapper.insertVis(vis_name, vis_doctor,vis_data, vis_phone, regis_name,vis_school);
    }

    public List<HashMap> getVis(int page,int size) {
        return visMapper.getVis(page,size);
    }

    public int deletevis(int visid) {
        return visMapper.deletevis(visid);
    }

    public int getvisCount() {
        return visMapper.getvisCount();
    }

    public List<HashMap> getvisById(int vId) {
        return visMapper.getvisById(vId);
    }

    public int updateVis(String vis_name, String vis_phone, int regis_status, int vis_id) {
        return visMapper.updateVis(vis_name, vis_phone, regis_status, vis_id);
    }
}
