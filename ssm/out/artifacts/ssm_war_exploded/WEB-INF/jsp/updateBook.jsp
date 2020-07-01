<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍管理-----修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <div class="form-group">
            <label>书籍名称</label>
            <%--input中的name必须要跟数据库一致，否者会插入null--%>
            <%-- 使用隐藏域将BookID传入修改 --%>
            <input type="hidden" name="bookID"value="${QueryBook.bookID}">
            <input type="text" name="bookName" class="form-control" value="${QueryBook.bookName}" required>
            <small class="form-text text-muted">请输入书籍名称。</small>
        </div>
        <div class="form-group">
            <label>图书数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${QueryBook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍详情</label>
            <input type="text" name="detail" class="form-control"  value="${QueryBook.detail}" required>
        </div>

        <button type="submit" class="btn btn-primary">确认修改</button>
    </form>
</div>
</body>
</html>
