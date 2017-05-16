package com.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.model.user;
import com.project.service.bannerServiceInterface;
import com.project.service.schoolServiceInterface;
import com.project.service.userServiceInterface;
import com.project.util.jsonutil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/2.
 */
@Controller
@RequestMapping("/banner")
public class bannerController {
    private static final int pagesize=10;
    private final static Log logger = LogFactory.getLog(bannerController.class);
    @Autowired
    private bannerServiceInterface bannerServiceInterface;
    @Autowired
    private schoolServiceInterface schoolServiceInterface;
    @Autowired
    private userServiceInterface userServiceInterface;
    @Autowired
    private jsonutil jsonutil;

    @RequestMapping("getBannerUrl")
    @ResponseBody
    public JSONObject getBannerUrl(HttpSession session){
        logger.info("project--------执行了/banner/getBannerUrl");
        user u=(user)session.getAttribute("user");
        int schooleId=userServiceInterface.selectSchoolId(u.getUserOpenid());
        try {
            String str = bannerServiceInterface.getbannerurl(schooleId);
            return jsonutil.JSONRESPONSE(1,"获取成功",str);
        } catch (Exception e) {
            logger.error("/banner/getBannerUrl出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }

    @RequestMapping("getBannerList")
    @ResponseBody
    public JSONObject getBannerList(Integer page){
        logger.info("project--------执行了/banner/getBannerList");
       List<HashMap> list=new ArrayList();
        try {
           list=bannerServiceInterface.getBanner((page-1)*pagesize,pagesize);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            logger.error("/banner/getBannerList出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }
    @RequestMapping("getBannerCount")
    @ResponseBody
    public JSONObject getBannerCount(){
        logger.info("project--------执行了/banner/getBannerCount");
        int count=0;
        try {
           count=bannerServiceInterface.getBannerCount();
            return jsonutil.JSONRESPONSE(1,"获取成功",count);
        } catch (Exception e) {
            logger.error("/banner/getBannerCount出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }

    @RequestMapping("deleteBanner")
    @ResponseBody
    public JSONObject deleteBanner(Integer bannerId){
        logger.info("project--------执行了/banner/deleteBanner");

        try {
           bannerServiceInterface.deleteByPrimaryKey(bannerId);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/banner/deleteBanner出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }


    @RequestMapping("getbannerbyid")
    @ResponseBody
    public JSONObject getbannerbyid(Integer id){
        logger.info("project--------执行了/banner/getbannerbyid");
           List<HashMap> list=new ArrayList();
        try {
          list=bannerServiceInterface.getbannerById(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            logger.error("/banner/getbannerbyid出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }

    @RequestMapping("updatebanner")
    @ResponseBody
    public JSONObject updatebanner(String name,String url,Integer id){
        logger.info("project--------执行了/banner/updatebanner");

        try {
          bannerServiceInterface.updateBanner(name,url,id);

            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/banner/updatebanner出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }

    @RequestMapping("addSchool")
    @ResponseBody
    public JSONObject addSchool(String name,String url){
        logger.info("project--------执行了/banner/updatebanner");

        try {
            bannerServiceInterface.addschool(name, url);

            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/banner/updatebanner出错--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }
}
