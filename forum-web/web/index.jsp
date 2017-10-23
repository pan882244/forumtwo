<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/16
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
  <head>
    <title>木棉花论坛</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!--初始化移动浏览显示-设置窗口大小与移动设备一致，且不能缩放窗口-->
    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="js/index.js" ></script>
  </head>
  <body>
  <table border="1" align="center" width="80%" class="table" id="newsliebiao">
    <tr>
      <td colspan="5" style="font-size:50px;text-align:center;height:100px">首页</td>
    </tr>
    <tr>
      <td colspan="5" align="right">
        <a href="sendMessage.jsp">发留言</a>
        <c:if test="${empty sessionScope.user}">
          <a href='login.html'>登录</a>
        </c:if>


        <a href="personal.jsp">${sessionScope.user.account }</a>
        <a href="UserInfoLogout">退出系统</a>
      </td>
    </tr>
    <tr>
      <th>编号</th>
      <th>标题</th>
      <th>作者</th>
      <th>内容</th>
      <th>发帖时间</th>
    </tr>

    <c:forEach var="m" items="${requestScope.list.data }" varStatus="vs">
      <tr align="center">
        <td>${vs.count }</td>
        <td>
          <a href="#">${m.title }</a>
        </td>
        <td>${m.userAccount }</td>
        <%--<td>
            ${m.content}
        </td>--%>
        <td>
          <fmt:formatDate value="${m.genTime }" pattern="yyyy-MM-dd hh:mm:ss"/>
        </td>
      </tr>
    </c:forEach>


  </table>
  <div id="pager" style="margin-left:30%;">
    <ul class="pagination">

      <li><a href="#" id="firstPage">首页</a></li>
      <li><a href="#" id="prevPage">上一页</a></li>
      <li><a href="#" id="cp">1</a></li>
      <li><a href="#" id="nextPage">下一页</a></li>
      <li><a href="#" id="lastPage">尾页</a></li>
      <li><a href="#" >共<span id="totalPageCount">5</span>页</a></li>
      <li><a href="#">每页<span id="pageCount">0</span>条</a></li>
    </ul>
  </div>
  </body>
</html>
