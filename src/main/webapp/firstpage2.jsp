<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>PROJECT</title>
    <meta name="keywords" content="">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/site.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/firstpage.css" rel="stylesheet">
   
    <script>
    var _hmt = _hmt || [];
    </script>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://www.bootcdn.cn/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="shortcut icon" href="http://www.bootcdn.cn/assets/ico/favicon.ico">
</head>

<body class="home-template">
    <div class="site-notice"><a href="http://blog.bootcdn.cn/bootcdn-support-https/" target="_blank"><em>小朋友课堂开课啦！</em></a></div>
    <header class="site-header jumbotron">
      
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                  



<!-- 轮播开始 -->
<div id="banner" >

		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner" >
				<div class="item active">
					<img id="banner1" src=""
						width="100%" alt=""></div>
					<div class="item">
					<img id="banner2" src=""
						width="100%" alt="">
				    </div>
				<div class="item">
                   <%-- ./images/03.jpg--%>
					<img id="banner3" src=""
						width="100%" alt="">
				</div>
			</div>

			<a class="carousel-control left" href="#myCarousel" data-slide="prev"></a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next"></a>
		</div>
	</div>
<!-- 轮播结束 -->




                  <form class="" role="search" style="margin-top: -25px;margin-bottom: -40px">
                        <div class="form-group">
                            <input type="text" class="form-control search clearable" placeholder="搜索小朋友课堂" style="height: 20px;font-size: 0.2rem"></div>
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
             
                   <ul style=" padding: 0; width: 100%;" id="vedioul">

       <%--  <li class="package list-group-item" id="vediolist">
                   <span style="display: none" id="vedioid"></span>
                   <div class="row" id="vediorow">
                        <div class="col-xs-3" style="margin-top: 1px;">
                           <img src="./images/04.jpg" alt="..." id="vedioimg" class="img-rounded"></div>
                        <div class="col-xs-9" style="margin-bottom: 5px;">
                            <h4 id="vediotitle">我是title</h4>
                        </div>
                        <div class="package-extra-info col-xs-9 col-md-offset-3 col-xs-12" id="intro">
                            <span id="vediointro">The most popular front-end framework for 其实我有很长长长长长长长长长长长长长长长长长长长长长长长长长长</span></div>
                    </div></li>--%>

                     </ul>
                <div id="pullUp">
                    <span><img src="${pageContext.request.contextPath}/images/load.png">&nbsp;</span><span class="pullUpLabel" >查看更多...</span>
                </div>

              
              
       
              
             
            </div>
        </div>
    </main>
  <!--   <footer id="footer" class="footer hidden-print">
    
      
    </footer> -->

    <a href="#" id="back-to-top" style="display: none;"><%--<i class="fa fa-angle-up">--%><img class="fa fa-angle-up" src="${pageContext.request.contextPath}/images/top.png"></a>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/geopattern.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/clipboard.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/localforage.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/firstpage2.js"></script>
    <script src="${pageContext.request.contextPath}/js/site.min.js"></script>
    <script type="text/javascript">
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F24aff315392dc2c9b2805cfa4d8e101a' type='text/javascript'%3E%3C/script%3E"));
    </script>
    <script src="${pageContext.request.contextPath}/js/h.js" type="text/javascript"></script>
</body>

</html>
