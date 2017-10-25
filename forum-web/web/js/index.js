$(function() {
    Date.prototype.format = function(format) {
        var o = {
            "M+" : this.getMonth() + 1,// month
            "d+" : this.getDate(),// day
            "h+" : this.getHours(),// hour
            "m+" : this.getMinutes(),// minute
            "s+" : this.getSeconds(),// second
            "q+" : Math.floor((this.getMonth() + 3) / 3),// quarter
            "S" : this.getMilliseconds()
            // millisecond
        };
        if (/(y+)/.test(format) || /(Y+)/.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for ( var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    };



    //分页操作
    //1.首页

    $("#firstPage").click(function(){

        queryPageNews(1);
    }) ;


    //2.尾页
    $("#lastPage").click(function(){

        var totalPageCount = $("#totalPageCount").text() ;
        queryPageNews(totalPageCount);
    });

    //3.上一页
    $("#prevPage").click(function(){

        var prevPage = $("#cp").text() - 1;
        //alert("上一页"+prevPage);
        if(prevPage<=0) {
            return ;
        }

        queryPageNews(prevPage);
    }) ;

    //4.下一页
    $("#nextPage").click(function(){
        //alert("下一页:");

        var nextPage = $("#cp").text()*1 + 1;
        //alert("下一页"+nextPage);
        var totalPageCount = $("#totalPageCount").text() ;
        //alert("总页数"+totalPageCount);
        if(nextPage>totalPageCount) {
            return ;
        }
        //alert("甲乙"+nextPage+"+"+newNo);
        queryPageNews(nextPage);
    }) ;
});


/************功能函数**************/
function queryPageNews(cp) {
    $.ajax({
        url:"queryPageNews",
        type:"post",
        dataType:"json" ,
        data:{"cp":cp},
        success:function(FQpagerUtil) {
            //清空原数据
            $("#newsliebiao").find("tbody").find("tr:gt(0)").remove() ;
            /*$("#newsliebiao").find("tbody").find("tr:gt(1)").remove() ;*/

            var d = eval("("+FQpagerUtil+")");


            //遍历数组
            $.each(d.data,function(index,news) {
                //创建节点
                var ne = $("<tr align='center'><td>"+(index+1)+"</td><td><a href='#'></a>"+news.title+"</td><td>"+news.userAccount+"</td><td>"+(new Date(news.genTime)).format("yyyy-MM-dd hh:mm:ss")+"</td></tr>");

                //添加节点到表格中
                $("#newsliebiao").append(ne);
            });

            //把分页的相关信息，在页面中显示
            $("#cp").text(d.currentPage) ;

            $("#totalPageCount").text(d.totalPageCount) ;

            $("#pageCount").text(d.pageCount) ;
        },
        error:function(){

            alert("系统异常，请稍后重试！");

        }
    });
}


