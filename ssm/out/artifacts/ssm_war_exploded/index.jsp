
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>
<%--   ${pageContext.request.contextPath}是JSP取得绝对路径的方法，等价于<%=request.getContextPath()%> 。--%>
<%--    也就是取出部署的应用程序名或者是当前的项目名称--%>
    <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>
  </h1>
  </body>
</html>
