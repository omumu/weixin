
import com.project.util.http.HttpClientConnectionManager;
import com.project.util.wx.WeixinBasicKit;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.project.model.constant;

import java.net.URLEncoder;

/**
 * Created by 木木高 on 2017/3/31.23
 */
public class logtext {

    private final static Logger logger = LoggerFactory.getLogger(logtext.class);
    public static void main(String[] args)throws Exception {
        String url=constant.getAUTHO2();
        url=url.replace("APPID",constant.getAPPID()).replace("REDIRECT_URI","http%3a%2f%2flocalhost%3a8080%2fAutho2");
        System.out.println(url);

        HttpClientConnectionManager.getGetMethod(url);
/*logger.info("logback 成功了");
logger.error("logback 成功了");
logger.debug("logback 成功了");*/

    }
}
