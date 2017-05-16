
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="email=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/second.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/site.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/second.js" type="text/javascript"></script>
    <title>医疗咨询</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />




</head>
<body>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js" ></script>

<script>
    $(document).ready(function() {
        $.ajax({
            type: "POST",
            cache: false,
            url: "${pageContext.request.contextPath}/question/getQuestionList",
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {
                    var lilist = "";
                    for (var i = 0; i < data.data.length; i++) {
                        lilist +=" <li><h3 style='font-size: 14px;margin-left:10px;'>"+ data.data[i].question+"</h3> " +
                        "<p style='margin-left: 2%;font-size:12px;color: green;padding: 3px;'>"+ data.data[i].answer+"</p>" +
                        "<hr style='margin-top: 4px;'></li>"

                    }
                    $("#doctorlist").html(lilist);
                }else{alert("图片加载失败！错误信息: "+data.message);}
            }

        })
    })
</script>

<div class="site-notice"><a href="#" target="_blank" style="font-size: 20px;"><em>校园医疗</em></a></div>
<br>
<a style="margin-left: 5%"target="_blank" href="http://sighttp.qq.com/authd?IDKEY=34c628ee89832b1893e3030a26c0467eb8ebe0078716f17e"><img border="0"  src="http://wpa.qq.com/imgd?IDKEY=34c628ee89832b1893e3030a26c0467eb8ebe0078716f17e&pic=52" alt="点击这里给我发消息" title="点击这里给我发消息"/><span>医疗在线咨询</span></a><br><br>
<span style="margin-left:5%">医疗咨询邮箱</span> &nbsp;&nbsp;<span style="color: green">304213868@qq.com</span><br><br>
<span style="color: green;font-size: 20px;margin-left:5%"><b>常见问题</b></span><hr>
<ul id="doctorlist" style="width: 94%;margin-left: 10px;margin-top: 12px;">


</ul><br>












</body>


</html>
