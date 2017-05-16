package com.project.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.project.model.user;
import com.project.service.doctorServiceInterface;
import com.project.service.schoolServiceInterface;
import com.project.service.userServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/17.
 */
@Controller
@RequestMapping("school")
public class schoolController {
    private final static Log logger = LogFactory.getLog(regisController.class);
    @Autowired
    private schoolServiceInterface schoolServiceInterface;
    @Autowired
    private userServiceInterface userServiceInterface;
    @Autowired
    private com.project.util.jsonutil jsonutil;

    @RequestMapping("getSchoolList")
    @ResponseBody
    public JSONObject getSchoolList() {
        logger.info("project--------执行了/regis/getSchoolList");
        List list=new ArrayList();
        try {
            list=schoolServiceInterface.getSchool();
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getSchoolList----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("insertSchooluser")
    @ResponseBody
    public JSONObject insertSchooluser(int sid, HttpSession session) {
        user user=(user)session.getAttribute("user");
        logger.info("project--------执行了/regis/insertSchooluser");
        if(userServiceInterface.getUserSchoolCount(user.getUserOpenid())!=0){
            return jsonutil.JSONRESPONSE(2,"获取失败",null);
        }else{
        try {
           schoolServiceInterface.insertschool(sid,user.getUserOpenid());

            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/insertSchooluser----"+e);
        }}
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

}
