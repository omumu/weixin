package com.project.dao;

import com.project.model.vis;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public interface visMapper {
    int deleteByPrimaryKey(Integer visId);

    int insert(vis record);

    int insertSelective(vis record);

    vis selectByPrimaryKey(Integer visId);

    int updateByPrimaryKeySelective(vis record);

    int updateByPrimaryKey(vis record);
    int insertVis(String vis_name,String vis_doctor,Date vis_data, String vis_phone, String regis_name,int vis_school);
    List<HashMap> getVis(int page, int size);
    int deletevis(int visid);
    int getvisCount();
    List<HashMap> getvisById(int vId);
    int updateVis(String vis_name,String vis_phone,int regis_status,int vis_id);
}