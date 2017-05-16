
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
    <title>挂号详情</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />


</head>
<body>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/iscroll.js" ></script>

<div class="site-notice"><a href="#" target="_blank" style="font-size: 20px;"><em>校园医疗</em></a></div>

<%--<span class="input input--haruki">
					<input class="input__field input__field--haruki kbtn" type="text" style="line-height:40px;"  id="beginTime" />
					<label class="input__label input__label--haruki" for="beginTime">
						<span class="input__label-content input__label-content--haruki"><strong style="padding:5px;font-size: 15px">就诊日期:</strong></span>
					</label>
				</span>--%>
<span class="input input--minoru">
					<input class="input__field input__field--minoru" type="text" style="line-height:40px;"id="beginTime" />
					<label class="input__label input__label--minoru" for="beginTime">
						<span class="input__label-content input__label-content--minoru"><strong style="padding:5px;font-size: 15px">就诊日期</strong></span>
					</label>

<ul id="doctorlist" style="width: 94%;margin-left: 10px;margin-top: 12px;">

</ul>
<script src="${pageContext.request.contextPath}/js/classie.js"></script>
<script>
$ (document).ready(function() {

        var data1 = $("#beginTime").val();
        var regisId=$("#regisid").val();
        getdoctorList(regisId,data1);
        $("#beginTime").click(function(){
            var data1 = this.value.toString();
            var regisId=$("#regisid").val();
            getdoctorList(regisId,data1);
             if(data1!=""){
             getdoctorList(regisId,data1);

            }
        });
    })
</script>

<script>
    function level(data){
        if(data==0){
            return "普通";
        }else{
            return "专家";
        }

    }
    function getdoctorList(regisId,time){

        $.ajax({
            type: "POST",
            cache: false,
            url: "${pageContext.request.contextPath}/doctor/getDocList",
            data: {regisId:regisId,time:time},
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {
                    if(data.data.length==0){
                        var lilist = "<img src='${pageContext.request.contextPath}/images/nodata.png' style='margin-left: 30%;margin-top: 0px;margin-right: 2%'><label style='margin-left: 4px;margin-top: 65px;color: gray'>没有医生值班咯！</label>";
                        $("#doctorlist").html(lilist);

                    }else {

                    var lilist = "";
                    for (var i = 0; i < data.data.length; i++) {
                        lilist +="<a style='text-decoration: none' href='${pageContext.request.contextPath}/regis/getCurrent?id="+ data.data[i].doctor_id+"&regisId="+regisId+"&time="+time+"'><li><img src="+data.data[i].doctor_photo+" style='width:8%;height:5%;margin-top:-20px'><span style='font-size: 14px;margin-left:10px;'>" +  data.data[i].doctor_name + "</span>" +
                                "<span style='margin-left: 2%;background-color:green;font-size:10;color: white;padding: 3;'>"+level(data.data[i].doctor_level)+ "</span>"+
                                "<span style='margin-left:53%;font-size:12;padding: 3;'>"+data.data[i].doctor_price+"元"+ "</span>"+
                                "<img src='${pageContext.request.contextPath}/images/next1.png' style='float:right'>"+
                                "<hr style='margin-top: 4px;'></li></a>"

                    }
                    $("#doctorlist").html(lilist);}

                }else{
                    alert("获取列表失败！错误信息: "+ data.message);
                }
            }

        })


    }
</script>
<script>
    (function() {
        // trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
        if (!String.prototype.trim) {
            (function() {
                // Make sure we trim BOM and NBSP
                var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                String.prototype.trim = function() {
                    return this.replace(rtrim, '');
                };
            })();
        }

        [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
            // in case the input is already filled..
            if( inputEl.value.trim() !== '' ) {
                classie.add( inputEl.parentNode, 'input--filled' );
            }

            // events:
            inputEl.addEventListener( 'focus', onInputFocus );
            inputEl.addEventListener( 'blur', onInputBlur );
        } );

        function onInputFocus( ev ) {
            classie.add( ev.target.parentNode, 'input--filled' );
        }

        function onInputBlur( ev ) {
            if( ev.target.value.trim() === '' ) {
                classie.remove( ev.target.parentNode, 'input--filled' );
            }
        }
    })();
</script>
<%--时间选择--%>
<script type="text/javascript">
    $(function(){

        $('#beginTime').date();
        $('#endTime').date({theme:"datetime"});


    });
</script>

<%--<div class="lie" style="margin-top: 50px"><strong style="padding:5px;background:gainsboro">就诊日期:</strong>

    <label style="padding:5px;background:gainsboro" for="beginTime">就诊日期:</label>
    <input  id="begin1Time" class="kbtn" /></div>--%>



<div id="datePlugin"></div>
<div style="display:none;">
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_5032201'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/stat.php%3Fid%3D5032201%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));</script>
    <script type="text/javascript">
        var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
        document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F7acca738c2b8551dcae59f4b9b8f6ea0' type='text/javascript'%3E%3C/script%3E"));
    </script>

</div>

<%--时间选择--%>

<input type="hidden" id="regisid" value="${ids }">

</body>
<%--<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>--%>

</html>
