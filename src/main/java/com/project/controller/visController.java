package com.project.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.project.model.user;
import com.project.service.schoolServiceInterface;
import com.project.service.userServiceInterface;
import com.project.service.visServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/21.
 */
@Controller
@RequestMapping("vis")
public class visController {
    private static final int pagesize=10;
    private final static Log logger = LogFactory.getLog(regisController.class);
    @Autowired
    private visServiceInterface visServiceInterface;
    @Autowired
    private com.project.service.userServiceInterface userServiceInterface;
    @Autowired
    private schoolServiceInterface schoolServiceInterface;
    @Autowired
    private com.project.util.jsonutil jsonutil;

    @RequestMapping("insertVis")
    @ResponseBody
    public JSONObject insertVis(String vis_name, String vis_doctor, String time, String vis_phone, String regis_name, int money,HttpSession session) {
        user u=(user)session.getAttribute("user");
        int schoolid=0;
       if(userServiceInterface.getUserSchoolCount(u.getUserOpenid())==0){
           return jsonutil.JSONRESPONSE(2,"获取失败",null);
       }else{
         schoolid= userServiceInterface.selectSchoolId(u.getUserOpenid());}
         if(Integer.parseInt(userServiceInterface.getMoney(u.getUserOpenid()))<money){
             return jsonutil.JSONRESPONSE(3,"金额不足",null);
         }
        logger.info("project--------执行了/vis/insertVis");
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        try {
            visServiceInterface.insertVis(vis_name, vis_doctor,formatter.parse(time.toString()), vis_phone, regis_name,schoolid);
            userServiceInterface.updateMoney(money,u.getUserOpenid());
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/vis/insertVis----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getVisList")
    @ResponseBody
    public JSONObject getVisList(Integer page){
        logger.info("project--------执行了/banner/getVisList");
      List<HashMap> list=new ArrayList();
        try {
           list=visServiceInterface.getVis((page-1)*pagesize,pagesize);
            for(int i=0;i<list.size();i++){
                String schoolname=schoolServiceInterface.getSchoolName(Integer.parseInt(list.get(i).get("vis_school").toString()));
                list.get(i).remove("vis_school");
                list.get(i).put("vis_school",schoolname);

            }
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            logger.error("/banner/getVisList出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }


    @RequestMapping("deletevis")
    @ResponseBody
    public JSONObject deletevis(int visid){
        logger.info("project--------执行了/vis/deletevis");

        try {
           visServiceInterface.deletevis(visid);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/vis/deletevis出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }
    @RequestMapping("getuisCount")
    @ResponseBody
    public JSONObject getuisCount(){
        logger.info("project--------执行了/vis/getuisCount");
          int count=0;
        try {
           count=visServiceInterface.getvisCount();
            return jsonutil.JSONRESPONSE(1,"获取成功",count);
        } catch (Exception e) {
            logger.error("/vis/getuisCount出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }
    @RequestMapping("getVisById")
    @ResponseBody
    public JSONObject getVisById(int vid){
        logger.info("project--------执行了/vis/getVisById");
        List<HashMap> list=new ArrayList();
        try {
         list=visServiceInterface.getvisById(vid);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).get("vis_data"));
                String schoolname=schoolServiceInterface.getSchoolName(Integer.parseInt(list.get(i).get("vis_school").toString()));
                list.get(i).put("schoolname",schoolname);
                list.get(i).remove("vis_school");
            }
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            logger.error("/vis/getVisById出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }

    @RequestMapping("updatevis")
    @ResponseBody
    public JSONObject updatevis(String vis_name, String vis_phone, int regis_status, int vis_id){
        logger.info("project--------执行了/vis/updatevis");

        try {
            visServiceInterface.updateVis(vis_name, vis_phone, regis_status, vis_id);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/vis/updatevis出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }
}
