package com.project.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.util.SecurityKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeinxinController {
	
	public static final String TOKEN = "gaomumu";

	@RequestMapping("/wget")
	public void wget(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//		signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
//		timestamp	时间戳
//		nonce	随机数
//		echostr
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		String[] arr = {WeinxinController.TOKEN,timestamp,nonce};
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(String a:arr) {
			sb.append(a);
		}
		String sha1Msg = SecurityKit.sha1(sb.toString());
		if(signature.equals(sha1Msg)) {
			resp.getWriter().println(echostr);
		}
	}
}
