$(document).ready(function() {
    $.ajax({
        type: "POST",
        cache: false,
        url: "./banner/getBannerUrl",
        //data: {code:code1},
        dataType: "json",
        success: function (data) {
        //  alert(data.code);
            if (data.code == 1) {
                $("#banner1").attr("src",data.data[0].banner_url);
                $("#banner2").attr("src",data.data[1].banner_url);
                $("#banner3").attr("src",data.data[2].banner_url);
            }else{alert("图片加载失败！错误信息: "+data.message);}
        }

    })
})

/*$(document).ready(function() {
    var code1=1;
    $.ajax({
        type: "POST",
        cache: false,
        url: "./video/videoList",
        data: {code:code1},
        dataType: "json",
        success: function (data) {
            // alert(data.data.length);

            if (data.code == 1) {
                var lilist = "";
                for (var i = 0; i < data.data.length; i++) {
                    lilist += " <li class='package list-group-item' id='vediolist'>" +
                        "<span style='display: none'; id='vedioid'>" + data.data[i].video_id + "</span>" +
                        "<div class='row' id='vediorow'>" +
                        "<div class='col-xs-3' style='margin-top: 1px;'>" +
                        "<img src='" + data.data[i].video_image + "' alt='...' id='vedioimg' class='img-rounded'></div>" +
                        "<div class='col-xs-9' style='margin-bottom: 5px;'>" +
                        "<h4 id='vediotitle'>" + data.data[i].video_title + "</h4>" +
                        "</div>" +
                        "<div class='package-extra-info col-xs-9 col-md-offset-3 col-xs-12' id='intro'>" +
                        "<span id='vediointro'>" + data.data[i].video_intro + "</span></div> </div> </li>"
                }
                $("#vedioul").html(lilist);
            }else{
                alert("获取列表失败！错误信息: "+data.message);
            }
        }

    })

})*/

$(document).ready(function() {
    var codel=1;
    $("#vedioul").unbind("scroll").bind("scroll", function(e){
        var sum = this.scrollHeight;
      if (sum <= $(this).scrollTop() + $(this).height()) {
           if(code1<3) {
            code1++;}
        }
    })

    $.ajax({
        type: "POST",
        cache: false,
        url: "./video/videoList",
        data: {page:code1},
        dataType: "json",
        success: function (data) {


            if (data.code == 1) {

                var lilist = "";
                for (var i = 0; i < data.data.length; i++) {
                    lilist += " <li class='package list-group-item' id='vediolist'>" +
                        "<span style='display: none'; id='vedioid'>" + data.data[i].video_id + "</span>" +
                        "<div class='row' id='vediorow'>" +
                        "<div class='col-xs-3' style='margin-top: 1px;'>" +
                        "<img src='" + data.data[i].video_image + "' alt='...' id='vedioimg' class='img-rounded'></div>" +
                        "<div class='col-xs-9' style='margin-bottom: 5px;'>" +
                        "<h4 id='vediotitle'>" + data.data[i].video_title + "</h4>" +
                        "</div>" +
                        "<div class='package-extra-info col-xs-9 col-md-offset-3 col-xs-12' id='intro'>" +
                        "<span id='vediointro'>" + data.data[i].video_intro + "</span></div> </div> </li>"
                }
                $("#vedioul").html(lilist);
            }else{

                alert("获取列表失败！错误信息: "+ data.message);
            }
        }

    })



})


