package com.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.model.constant;
import com.project.model.user;
import com.project.service.bannerServiceInterface;
import com.project.service.userServiceInterface;
import com.project.util.QiniuUpload;
import com.project.util.http.MenuUtil;
import com.project.util.jsonutil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by 木木高 on 2017/4/18.
 */
@Controller
public class commonController {
    private final static Log logger = LogFactory.getLog(bannerController.class);
   @Autowired
    private com.project.util.jsonutil jsonutil;
    @Autowired
    private QiniuUpload qiniuUpload;
    @Autowired
    private userServiceInterface userServiceInterface;

    @RequestMapping("Autho2")
    public String Authorize(HttpSession session, String code){
        if (session.getAttribute("user") == null ) {
            String appid = constant.getAPPID();
            String appsecret =constant.getAPPSECRET();

            logger.info("开始授权"+appsecret+"   "+appid);
            try {
                Map<String,String> map = MenuUtil.getAccessToken(appid, appsecret,code);
               user user = MenuUtil.getUserInfo(map.get("access_token"),map.get("open_id"));
                if(userServiceInterface.getUserOpenid(user.getUserOpenid())==0){
                userServiceInterface.adduser(user.getUserName(),user.getUserSex(),user.getUserOpenid(),user.getUserHeadimgurl(),new Date());}else {
                    session.setAttribute("user", user);
                    logger.info("  open_id=" + user.getUserOpenid() + "  user_name=" + session.getAttribute("user").toString() + "   access_token=" + map.get("access_token"));

                }} catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.error(e.toString());
                return "404";
            }
        }
        return "firstpage";
    }
    @RequestMapping("Autho21")
    public String Authorize1(HttpSession session, String code){

        if (session.getAttribute("user") == null ) {
            String appid = constant.getAPPID();
            String appsecret =constant.getAPPSECRET();
            logger.info("开始授权"+appsecret+"   "+appid);
            try {
                Map<String,String> map = MenuUtil.getAccessToken(appid, appsecret,code);
               user user = MenuUtil.getUserInfo(map.get("access_token"),map.get("open_id"));
                if(userServiceInterface.getUserOpenid(user.getUserOpenid())==0){
                userServiceInterface.adduser(user.getUserName(),user.getUserSex(),user.getUserOpenid(),user.getUserHeadimgurl(),new Date());}else {
                    session.setAttribute("user", user);
                    logger.info("  open_id=" + user.getUserOpenid() + "  user_name=" + session.getAttribute("user").toString() + "   access_token=" + map.get("access_token"));

                }  } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.error(e.toString());

                return "404";
            }
        }
        return "money";
    }
    @RequestMapping("Autho22")

    public String Authorize2(HttpSession session, String code){

        if (session.getAttribute("user") == null ) {
            String appid = constant.getAPPID();
            String appsecret =constant.getAPPSECRET();
            logger.info("开始授权"+appsecret+"   "+appid);
            try {
                Map<String,String> map = MenuUtil.getAccessToken(appid, appsecret,code);
                user user = MenuUtil.getUserInfo(map.get("access_token"),map.get("open_id"));
                if(userServiceInterface.getUserOpenid(user.getUserOpenid())==0){
                userServiceInterface.adduser(user.getUserName(),user.getUserSex(),user.getUserOpenid(),user.getUserHeadimgurl(),new Date());}else {
                    session.setAttribute("user", user);
                    logger.info("  open_id=" + user.getUserOpenid() + "  user_name=" + session.getAttribute("user").toString() + "   access_token=" + map.get("access_token"));

                } } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.error(e.toString());

                return "404";
            }
        }

        return "school";
    }
    @RequestMapping("uploadFile")
    @ResponseBody
    public JSONObject  uploadFile(@RequestParam(value = "file",required = false) MultipartFile file,HttpServletRequest request)throws IOException {
        logger.info("project--------执行了/common/uploadFile");

        String fileName = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("upload");
        String path1 = request.getSession().getServletContext().getRealPath("upload")+"/"+fileName;
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List list=new ArrayList();
        HashMap map=new HashMap();
        try {
            String result=qiniuUpload.uploadFile(path1,fileName);
            map.put("result",result);
            list.add(map);
            return jsonutil.JSONRESPONSE(1,"获取成功！",list);
        } catch (Exception e) {
            e.printStackTrace();
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }

}
