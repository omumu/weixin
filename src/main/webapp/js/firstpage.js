
function serchisempty(){
  if(document.getElementById("loading").value=='')
    Ajax();

}
function getregisount(){
    var objul=document.getElementsByTagName("ul")[0];
    var lis=objul.getElementsByTagName("li");
    pullUpEl = document.getElementById('pullUp');
    $.ajax({
        type: "POST",
        cache: false,
        url: ".regis/getRegisCount",
        //data: {code:code1},
        dataType: "json",
        success: function (data) {

            if (data.code == 1) {

                /* alert(data.data);*/
                if(lis.length==data.data){
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '没有更多数据啦...';
                }else{
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                }
            }else{
                alert("获取列表数量失败！错误信息: "+ data.message);
            }
        }

    })

}

function Ajax() {
    $.ajax({
        type: "POST",
        cache: false,
        url: "./regis/getreGisList",
        /*data: {page:page},*/
        dataType: "json",
        success: function (data) {
            if (data.code == 1) {

                var lilist = "";
                for (var i = 0; i < data.data.length; i++) {
                   lilist +="<a style='text-decoration: none' href='./regis/getRegisdes?id="+ data.data[i].regis_id+"'><li><span style='font-size: 14px;color: green;'>" +  data.data[i].regis_name + "</span>" +
                        "<img src='images/next1.png' style='float:right'>"+
                        "<hr style='margin-top: 4px;'></li></a>"

                }
                $("#vedioul").html(lilist);

            }else{
                alert("获取列表失败！错误信息: "+ data.message);
            }
        }

    })



}


