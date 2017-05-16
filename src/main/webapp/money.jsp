
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
    <title>您的余额</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />




</head>
<body>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js" ></script>

<script>

</script>
<div class="site-notice"><a href="#" target="_blank" style="font-size: 20px;"><em>校园医疗</em></a></div><br>
<ul id="moneylist" style="width: 94%;margin-left: 10px;margin-top: 12px;">

</ul>

<script>
    $(document).ready(function() {
        $.ajax({
        type: "POST",
        cache: false,
        url: "${pageContext.request.contextPath}/user/getUserMoney",
        dataType: "json",
        success: function (data) {
            if (data.code == 1) {
              var  lilist =" <span style='margin-left: 2%;'>您的医保余额:</span>&nbsp;<span style='margin-left: 1%;color: green'  >￥"+data.data+".00元</span>"+
                "<hr style='margin-top: 4px;'>";

                  $("#moneylist").html(lilist);

            }else{
                alert("获取列表失败！错误信息: "+ data.message);
            }
        }

    });
    });
</script>











</body>


</html>
