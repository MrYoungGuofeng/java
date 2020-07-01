<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍管理-----新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label>书籍名称</label>
                <%--input中的name必须要跟数据库一致，否者会插入null--%>
            <input type="text" name="bookName" class="form-control" required>
            <small class="form-text text-muted">请输入书籍名称。</small>
        </div>
        <div class="form-group">
            <label>图书数量</label>
            <input type="text" name="bookCounts" class="form-control" required>
        </div>
        <div class="form-group">
            <label>书籍详情</label>
            <input type="text" name="detail" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">提交</button>
    </form>
</div>
</body>
</html>
