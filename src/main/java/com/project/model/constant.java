package com.project.model;

/**
 * Created by 木木高 on 2017/4/18.
 */
public class constant {
public constant(){

    }
    private static final String APPID="wxb1bbad2db6ec2010";
    private static final String APPSECRET="a3446544d93530688741fcdcff5c9948";
    private static final String REDIRECT_URL="http://localhost:8080/Autho2";

   /* url*/
   private static final String AUTHO2="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

    public static String getAPPID() {
        return APPID;
    }

    public static String getAPPSECRET() {
        return APPSECRET;
    }

    public static String getAUTHO2() {
        return AUTHO2;
    }
}
