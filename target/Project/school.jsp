
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="email=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css"/>
    <link href="${pageContext.request.contextPath}/css/second.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/site.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/second.js" type="text/javascript"></script>
    <title>选择学校</title>
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
            url: "${pageContext.request.contextPath}/school/getSchoolList",
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {
                    var lilist = "";
                    for (var i = 0; i < data.data.length; i++) {
                        lilist +="  <span style='margin-left: 2%;color: green'><input type='radio' name='identity' value='"+data.data[i].school_id+"'/>&nbsp;&nbsp;"+data.data[i].schoole_name+"</span>" +
                        "<hr style='margin-top: 4px;'>"

                    }
                    $("#doctorlist").html(lilist);
                }else{alert("学校加载失败！错误信息: "+data.message);}
            }

        })
    })

</script>
<script>
    function sure(){
    var list= $('input:radio[name="identity"]:checked').val();
        $.ajax({
            type: "POST",
            cache: false,
            url: "${pageContext.request.contextPath}/school/insertSchooluser",
            dataType: "json",
            data: {sid:list},
            success: function (data) {
                if(data.code==2){
                    swal({
                        title: "你已绑定过学校!",
                        html: true,
                        timer: 1000,
                        showConfirmButton: false
                    });
                }else{
                if (data.code == 1) {
                    swal("Good!", "绑定成功", "success");
                }else{
                   swal("OMG!", "绑定失败", "error");

                }}
            }

        })

    }

</script>
<div class="site-notice"><a href="#" target="_blank" style="font-size: 20px;"><em>校园医疗</em></a></div><br>

<ul id="doctorlist" style="width: 94%;margin-left: 10px;margin-top: 12px;">
  <%--  <span style="margin-left: 2%;color: green"><input type="radio" name="identity" value="学生"/>&nbsp;&nbsp;学生</span>
    <hr style='margin-top: 4px;'>--%>
</ul>
<input type="button"onclick="sure()" value="确认选择" style="width:90%;margin-left: 18px;background-color: mediumseagreen;height: 30px;color: white">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>














</body>
<script>

    $(document).ready(function() {
        $.ajax({
            type: "POST",
            cache: false,
            url: "./user/deleteNULL",
            dataType: "json",
            success: function (data) {
                if(data.code==1){

                }
            }

        })
    });
</script>

</html>
