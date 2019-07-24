<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
查询条件：
<table width="100%" border=1>
    <tr>
        <td><input type="submit" value="查询"/></td>
    </tr>
</table>
商品列表：
<form action="${pageContext.request.contextPath}/item/bachDelete" method="post">
    <table width="100%" border=1>
        <tr>
            <td>删除</td>
            <td>商品名称</td>
            <td>图片</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${itemList }" var="item">
            <tr>
                <td><input type="checkbox" name="id" value="${item.id}"></td>
                <td>${item.name }</td>
                <td><img width="100px" height="100px" src="http://localhost:8090/${item.pic}" alt=""></td>
                <td>${item.price }</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.detail }</td>

                <td><a href="${pageContext.request.contextPath }/item/toEdit?id=${item.id}">修改</a></td>

            </tr>
        </c:forEach>

    </table>
    <input type="submit" value="批量删除">
</form>
</body>

</html>