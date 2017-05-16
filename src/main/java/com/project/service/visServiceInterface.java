package com.project.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/21.
 */
public interface visServiceInterface {
    int insertVis(String vis_name, String vis_doctor,Date vis_data, String vis_phone, String regis_name,int vis_school);
    List<HashMap> getVis(int page, int size);
    int deletevis(int visid);
    int getvisCount();
    List<HashMap> getvisById(int vId);
    int updateVis(String vis_name,String vis_phone,int regis_status,int vis_id);
}
