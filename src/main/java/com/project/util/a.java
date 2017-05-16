package com.project.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

/**
 * Created by 木木高 on 2017/4/25.
 */
public class a {


    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "HUWlhVWWD1y5-JucvIIA7GfHAS3-e9Qx0J0peY3_"; //这两个登录七牛 账号里面可以找到
    String SECRET_KEY = "BricvcWAfzhx951scoIsPSqgTDl3zNMjurHI0Pjc";

    //要上传的空间
    String bucketname = "projects"; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）
    //上传到七牛后保存的文件名
    String key = "daimo6.png";
    //上传文件的路径
    String FilePath = "F:\\1.jpg";  //本地要上传文件路径

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }
    //普通上传
    public void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    public static void main(String args[]) throws IOException{
        new a().upload();
    }

}
