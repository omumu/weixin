package com.project.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.project.model.doctor;
import com.project.service.doctorServiceInterface;
import com.project.service.regisServiceInterface;
import com.project.util.jsonutil;
import com.project.util.stringutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/16.
 */
@Controller
@RequestMapping("/doctor")
public class doctorController {
    private static final int pagesize=10;
    private final static Log logger = LogFactory.getLog(regisController.class);
    @Autowired
    private doctorServiceInterface doctorServiceInterface;
    @Autowired
    private stringutil stringutil;
    @Autowired
    private com.project.util.jsonutil jsonutil;

    @RequestMapping("getDocList")
    @ResponseBody
    public JSONObject getDocList(int regisId,String time) {
        logger.info("project--------执行了/regis/getDocList");
        List list=new ArrayList();
        try {
            list=doctorServiceInterface.getDocList(regisId, time);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/doctor/getDocList----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getDocM")
    @ResponseBody
    public JSONObject getDocM(int page) {
        logger.info("project--------执行了/doctor/getDocM");
        List list=new ArrayList();
        try {
            list=doctorServiceInterface.getDoctorList((page-1)*pagesize,pagesize);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/doctor/getDocM----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getDocCount")
    @ResponseBody
    public JSONObject getDocCount() {
        logger.info("project--------执行了/doctor/getDocCount");
       int count=0;
        try {
            count=doctorServiceInterface.getCount();
            return jsonutil.JSONRESPONSE(1,"获取成功",count);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/doctor/getDocM----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("deleteDoc")
    @ResponseBody
    public JSONObject deleteDoc(int dId) {
        logger.info("project--------执行了/doctor/getDocCount");

        try {
           doctorServiceInterface.deleteDoc(dId);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/doctor/getDocM----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }


    @RequestMapping("getdocByid")
    @ResponseBody
    public JSONObject getdocByid(int id) {
        logger.info("project--------执行了/doctor/getdocByid");
List list=new ArrayList();
        try {
          list=doctorServiceInterface.getdocById(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/doctor/getdocByid----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("updatedocByid")
    @ResponseBody
    public JSONObject updatedocByid( String doctor_name,int doctor_level,int doctor_sex,int doctor_price,
                                     String dacotor_data,String doctor_photo,int doctor_id) {
        logger.info("project--------执行了/doctor/updatedocByid");
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
             date = fmt.parse(dacotor_data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        doctor d=new doctor();
        d.setDoctorName(doctor_name);
        d.setDoctorLevel(doctor_level);
        d.setDoctorSex(doctor_sex);
        d.setDoctorPrice((long)doctor_price);
        d.setDacotorData(date);
        d.setDoctorPhoto(doctor_photo);
        d.setDoctorId(doctor_id);

        try {
           doctorServiceInterface.updateByPrimaryKey(d);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/doctor/updatedocByid----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }



    @RequestMapping("insertdoc")
    @ResponseBody
    public JSONObject insertdoc(String doctor_name,int doctor_level,int doctor_sex,int doctor_price, String dacotor_data,String doctor_photo) {
        logger.info("project--------执行了/doctor/updatedocByid");
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = fmt.parse(dacotor_data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        doctor d=new doctor();
        d.setDoctorName(doctor_name);
        d.setDoctorLevel(doctor_level);
        d.setDoctorSex(doctor_sex);
        d.setDoctorPrice((long)doctor_price);
        d.setDacotorData(date);
        d.setDoctorPhoto(doctor_photo);


        try {
            doctorServiceInterface.insert(d);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/doctor/updatedocByid----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }
}
