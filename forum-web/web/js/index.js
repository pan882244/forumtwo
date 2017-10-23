function queryPageNews() {
    $.ajax({
        url:"queryPageNews.action",
        type:"post",
        dataType:"json" ,
        data:{"cp":cp},
        success:function(FQpagerUtil) {
            //清空原数据
            /*$("#newsliebiao").find("tbody").find("tr:gt(0)").remove() ;*/

            //遍历数组
            $.each(FQpagerUtil.data,function(index,news) {
                //创建节点
                var ne = $("<tr><td>"+index.canvas+"</td><td><a href='#'></a>"+news.title+"</td><td>"+news.userAccount+"</td><td>"+news.genTime+"</td></tr>");

                //添加节点到表格中
                $("#newsliebiao").append(ne);
            });

            //把分页的相关信息，在页面中显示
            $("#cp").text(FQpagerUtil.currentPage) ;

            $("#totalPageCount").text(FQpagerUtil.totalPageCount) ;

            $("#pageCount").text(FQpagerUtil.pageCount) ;
        }
    });
}