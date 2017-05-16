package com.project.util.http;
  


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.project.model.constant;
import com.project.model.user;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.util.EntityUtils;  

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

  
public class MenuUtil {  
  
    public static String APPID,APPSECRET;  
      
    //http客户端    
    public static DefaultHttpClient httpclient;  
      
    static {    
        httpclient = new DefaultHttpClient();    
        httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端

        APPID =constant.getAPPID();;//你的APPID
        APPSECRET = constant.getAPPSECRET(); //你的APPSECRET
    }    
      
    /** 
     * 创建菜单  
     */  
    public static String createMenu(String params, String accessToken) throws Exception {    
        HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);    
        httpost.setEntity(new StringEntity(params, "UTF-8"));    
        HttpResponse response = httpclient.execute(httpost);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");    
        JSONObject json = JSON.parseObject(jsonStr);  
        return json.getString("errmsg");  
    }    
    /** 
     * 获取accessToken  
     */  
    public static Map<String,String> getAccessToken(String appid, String secret,String code) throws Exception {    
        HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code");
        JSONObject json = null;
        CloseableHttpResponse response = httpclient.execute(get);
        try {

            String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
            json = JSON.parseObject(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
           response.close();
            //httpclient.close();
        }
        Map<String,String>map=new HashMap<String,String>();
        String access_token=json.getString("access_token");
        String open_id=json.getString("openid");
        map.put("access_token", access_token);
        map.put("open_id", open_id);
        return map;
    }    
    /**
     * 
     * @param access_token
     * @param open_id
     * @return 用户信息
     * @throws Exception
     */
    public static user getUserInfo(String access_token, String open_id) throws Exception {
        HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+open_id+"&lang=zh_CN");
        //HttpResponse response = httpclient.execute(get);
        JSONObject jsonObject = null;
      //  CloseableHttpResponse response=null;
        CloseableHttpResponse  response = httpclient.execute(get);
        try {
            String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
            jsonObject = JSON.parseObject(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            response.close();
            //httpclient.close();

        }
        if (null != jsonObject) {
	    	user weixinUserInfo=null;

	    		weixinUserInfo= new user();
		        // 用户的标识
	    		//System.out.println(jsonObject.getInteger("subscribe"));
	    		//System.out.println(jsonObject.getString("subscribe_time"));
	    		System.out.println(jsonObject.getString("nickname"));
	    		
	    		
		        weixinUserInfo.setUserOpenid(jsonObject.getString("openid"));
		        
		        String nickname=jsonObject.getString("nickname");
		        // 昵称
		        if(nickname!=null){
		        	weixinUserInfo.setUserName(nickname);
		        }
		        Integer sex=jsonObject.getInteger("sex");
		        // 用户的性别（1是男性，2是女性，0是未知）
		        if(sex!=null){
		        	 weixinUserInfo.setUserSex(sex.toString());
		        }
		     // 用户头像
		        String headimgurl=jsonObject.getString("headimgurl");
		        if(headimgurl!=null){
		        	   weixinUserInfo.setUserHeadimgurl(headimgurl);
		        }
		        return weixinUserInfo;

        }
		return null;
    }
}  
