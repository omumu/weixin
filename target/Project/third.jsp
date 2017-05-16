
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="email=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/second.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css"/>
    <link href="${pageContext.request.contextPath}/css/site.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/second.js" type="text/javascript"></script>
    <title>确认订单</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />




</head>
<body>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js" ></script>

<script>

</script>
<div class="site-notice"><a href="#" target="_blank" style="font-size: 20px;"><em>校园医疗</em></a></div>
<ul id="doctorlist" style="width: 94%;margin-left: 10px;margin-top: 12px;">
    <li><span style="font-size: 14px;margin-left:10px;">科室名称</span>
        <span id="regisname" style="margin-left: 55%;font-size:12px;color: green;padding: 3px;">${regisName}</span>
        <hr style="margin-top: 4px;"></li>
    <li><span style="font-size: 14px;margin-left:10px;">医生姓名</span>
        <span id="vis_doctor" style="margin-left: 55%;font-size:12px;color: green;padding: 3px;">${doctor_name}(${doctor_level})</span>
        <hr style="margin-top: 4px;"></li>
    <li><span style="font-size: 14px;margin-left:10px;">就诊日期</span>
        <span id="time" style="margin-left: 55%;font-size:12px;color: green;padding: 3px;">${time}</span>
        <hr style="margin-top: 4px;"></li>
    <li><span style="font-size: 14px;margin-left:10px;">挂号类型</span>
        <span style="margin-left: 55%;font-size:12px;color: green;padding: 3px;">预约挂号</span>
        <hr style="margin-top: 4px;"></li>
    <li><span style="font-size: 14px;margin-left:10px;">挂号金额</span>
        <span  id="money" style="margin-left: 55%;font-size:12px;color: darkred;padding: 3px;">${doctor_price}</span><span style="font-size:12px;color: darkred;padding: 3px;">.00元</span>
        <hr style="margin-top: 4px;"></li>
</ul><br>
<ul>
    <li><span style="margin-left:5%">就诊人姓名</span><input id="name" type="text" style="margin-left:12%;width:55%;height:5%"></li><br>
    <li><span style="margin-left:5%">就诊人电话</span><input id="phone" type="text" style="margin-left:12%;width:55%;height:5%"></li>
</ul><br><br>
<input type="button" onclick="sure()" value="确认预约" style="width:90%;margin-left: 18px;background-color: mediumseagreen;height: 30px;color: white">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
<script>
 function sure() {
    var name= $("#name").val();
     var phone=$("#phone").val();

     if(phone==""||name==""){
         swal({
             title: "所填信息不能为空!",
             html: true,
             timer: 1000,
             showConfirmButton: false
         });

     }else{

         if(!(/^1[34578]\d{9}$/.test(phone))){
             swal({
                 title: "手机号码格式不正确!",
                 html: true,
                 timer: 1000,
                 showConfirmButton: false
             });

         }else{

     var regisname=$("#regisname").html();
     var time=$("#time").html();
             var money=$("#money").html();
     var vis_doctor=$("#vis_doctor").html();

     $.ajax({
         type: "POST",
         cache: false,
         url: "${pageContext.request.contextPath}/vis/insertVis",
         dataType: "json",
         data: {vis_name:name,vis_doctor:vis_doctor,time:time,vis_phone:phone, regis_name:regisname,money:money},
         success: function (data) {
             if(data.code==2){
                 swal({
                     title: "你还未绑定学校!",
                     html: true,
                     timer: 1000,
                     showConfirmButton: false
                 });
             }else{
                 if(data.code==3){
                     swal({
                         title: "医保余额不足!",
                         html: true,
                         timer: 1000,
                         showConfirmButton: false
                     });
                 }else{
             if (data.code == 1) {
                 swal("Good!", "预约成功", "success");
                 $("#name").val("");
                 $("#phone").val("")

                 }else{
                     swal("OMG!", "预约失败", "error");

                 }}}}


     })

 }}
 }


</script>











</body>


</html>
