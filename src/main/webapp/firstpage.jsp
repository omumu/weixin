<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>校园医疗</title>
    <meta name="keywords" content="">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/site.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css"/>
    <link href="${pageContext.request.contextPath}/css/firstpage.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/iscroll.js" type="text/javascript"></script>
<%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Management/css/style.css" />

    <script src="${pageContext.request.contextPath}/Management/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/Management/js/jquery.mCustomScrollbar.concat.min.js"></script>--%>
    <script>
    var _hmt = _hmt || [];
    </script>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://www.bootcdn.cn/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="shortcut icon" href="http://www.bootcdn.cn/assets/ico/favicon.ico">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/firstpage.js"></script>
</head>

<body class="home-template">
<style type="text/css">
    a{text-decoration:none}
</style>
    <div class="site-notice"><a href="#" <%--target="_blank"--%>><em>校园医疗</em></a></div>

    <header class="site-header jumbotron">
      
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                  



<!-- 轮播开始 -->
<div id="banner" >

		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->

			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner" >
				<div class="item active">
					<img id="banner1" src=""
						width="100%" alt=""></div>

			</div>

			<a class="carousel-control left" href="#myCarousel" data-slide="prev"></a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next"></a>
		</div>
	</div>
<!-- 轮播结束 -->

                    <script type="text/javascript">
                        $ (document).ready(function(){
                            $("#loading").blur(function(){
                                var data1=this.value;
                                $.ajax({
                                    type: "POST",
                                    cache: false,
                                    url: "${pageContext.request.contextPath}/regis/serchRegis",
                                    data: {regisname:data1},
                                    dataType: "json",
                                    success: function (data) {

                                        if (data.code == 1) {
                                          if(data.data.length==0){
                                                var lilist = "<img src='images/nodata.png' style='margin-left: 30%;margin-top: 0px;margin-right: 2%'><label style='margin-left: 4px;margin-top: 65px;color: gray'>小主，这里找不到！</label>";
                                                $("#vedioul").html(lilist);

                                            }else {
                                              var lilist = "";
                                              for (var i = 0; i < data.data.length; i++) {
                                                  lilist += "<a style='text-decoration: none' href='./regis/getRegisdes?id="+ data.data[i].regis_id+"'><li><span style='font-size: 14px;color: green;'>" + data.data[i].regis_name + "</span>" +
                                                          "<img src='images/next1.png' style='float:right'>" +
                                                          "<hr style='margin-top: 4px;'></li></a>"
                                              }
                                              $("#vedioul").html(lilist);

                                          }
                                        }else{

                                            alert("获取列表失败！错误信息: "+ data.message);
                                        }
                                    }

                                })
                            });
                        });
                    </script>


                  <form class="" role="search" style="margin-top: -25px;margin-bottom: -40px">
                        <div class="form-group">
                            <input type="text" id="loading"  class="form-control search clearable" style="height: 20px;font-size: 0.2rem"></div>
                    </form>
                </div>
            </div>
        </div>
    </header>
  
    <div class="container protocal-notice">
        <div class="row">
          
        </div>
    </div>

    <main class="packages-list-container" id="all-packages">
        <div class="container">
            <div class="list-group packages" id="listgroup" >
                <div id="wrapper">
                   <%-- <div id="scroller">--%>
                      <%--  <div id="pullDown">
                           <span class="pullDownLabel">下拉刷新...</span>
                        </div>--%>
                       <ul style="padding: 0; width: 100%;" id="vedioul">



                     </ul>
             <%-- <div id="pullUp">
                   <span class="pullUpLabel" >上拉加载更多...</span>
                </div>--%></div></div>

              
              
       
              
             
            </div>
        </div>
    </main>
  <!--   <footer id="footer" class="footer hidden-print">
    
      
    </footer> -->
<%--回到顶部--%>
   <%-- <a href="#" id="back-to-top" style="display: none;">&lt;%&ndash;<i class="fa fa-angle-up">&ndash;%&gt;<img class="fa fa-angle-up" src="${pageContext.request.contextPath}/images/top.png"></a>--%>

    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/geopattern.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/clipboard.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/localforage.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/site.min.js"></script>
    <script type="text/javascript">
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F24aff315392dc2c9b2805cfa4d8e101a' type='text/javascript'%3E%3C/script%3E"));
    </script>
    <script src="${pageContext.request.contextPath}/js/h.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/iscroll-probe.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
<script>

    $(document).ready(function() {

        serchisempty();
        $.ajax({
            type: "POST",
            cache: false,
            url: "./banner/getBannerUrl",
            /*  data: {schooleId:2},*/
            dataType: "json",
            success: function (data) {

                if (data.code == 1) {

                    $("#banner1").attr("src",data.data);
                }else{
                    swal({
                        title: "你没绑定学校，图片加载失败!",
                        html: true,
                        timer: 1000,
                        showConfirmButton: false
                    });

                }
            }

        })
    })

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



</body>

</html>
