<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/16
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>木棉花论坛</title>
  </head>
  <body>
  <table border="1" align="center" width="80%">
    <tr>
      <td colspan="5" style="font-size:50px;text-align:center;height:100px">首页</td>
    </tr>
    <tr>
      <td colspan="5" align="right">
        <a href="sendMessage.jsp">发留言</a>
        <c:if test="${empty sessionScope.user}">
          <a href='login.jsp'>登录</a>
        </c:if>


        <a href="personal.jsp">${sessionScope.user.account }</a>
        <a href="UserInfoLogout">退出系统</a>
      </td>
    </tr>
    <tr>
      <th>编号</th>
      <th>标题</th>
      <th>作者</th>
      <th>回复</th>
      <th>发帖时间</th>
    </tr>

    <%--<c:forEach var="m" items="${requestScope.pagerUtil.data }" varStatus="vs">
      <tr align="center">
        <td>${vs.count }</td>
        <td>
          <a href="FindReplays?messageId=${m.id }">${m.title }</a>
        </td>
        <td>${m.isNiMing == 1?"匿名":m.userInfo.username }</td>
        <td>
            ${fn:length(m.replay)}
        </td>
        <td>
          <fmt:formatDate value="${m.messageTime }" pattern="yyyy-MM-dd hh:mm:ss"/>
        </td>
      </tr>
    </c:forEach>--%>


  </table>

  </body>
</html>
