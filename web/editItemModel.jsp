<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改商品信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>

    <script type="text/javascript">
        function submitImg() {
            /* $.ajax({
                 url: '
           /uploadAjax',
                dataType: 'text',
                success: function (data) {

                },
                error: function (err) {

                }
            })*/

            //异步提交表单
            $('#itemForm').ajaxSubmit({
                url: '${pageContext.request.contextPath}/uploadAjax',
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                    if (data.code == 0) {
                        //1.修改imgsrc
                        $('#img').attr('src', 'http://localhost:8090/' + data.pic);
                    } else {
                        alert(data.msg)
                    }

                },
                error: function (err) {

                }
            })
        }


    </script>

</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${item.id }"/>
    修改商品信息：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${item.name }"/></td>
        </tr>
        <%-- <tr>
             <td>商品名称</td>
             <td><input type="text" name="itemCus.name" value="${item.name }"/></td>
         </tr>--%>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${item.price }"/></td>
        </tr>
        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createtime"
                       value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${item.pic !=null}">
                    <img src="http://localhost:8090/${item.pic}" width=100 height=100 id="img"/>
                    <br/>
                </c:if>
                <input type="file" name="pictureFile" onchange="submitImg()"/>
                <%--  <input type="hidden" name="pic" value="">--%>
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${item.detail }</textarea>
            </td>
        </tr>


        <select>
            <c:forEach items="${map}" var="entry">
                <option value="${entry.key}">${entry.value}</option>
            </c:forEach>

        </select>


        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>

</form>
</body>

</html>