<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.11.2.js" type="text/javascript"></script>


    <script>
        //{"id1" : 1,"name1" : "台式机","detail" : {"empno":7369,"job":"clerk"}

       /* $(function () {
            $.ajax({
                url: '/getItemJson',
                method:'POST',
                contentType: 'application/json',
                data: '{"id1": 1,"name1": "台式机","detail": "该电脑质量非常好！！！！"}',
                dataType: 'json',
                success: function (data) {

                }
            })
        })*/
        $(function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/getItemJson3',
                method:'POST',
                contentType: 'application/json',
                data: '{"id1" : 1,"name1" : "台式机","detail" : {"empno":7369,"job":"clerk"}}',
                dataType: 'json',
                success: function (data) {

                }
            })
        })

    </script>
    <%--

        {"id": 1,"name": "台式机","detail": "该电脑质量非常好！！！！"}


    --%>

</head>
<body>

</body>
</html>
