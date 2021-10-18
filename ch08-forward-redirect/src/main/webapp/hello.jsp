<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>hello.jsp </h3>
    <br/>
    <br/>
<%--    param代表参数的集合--%>
    <h3>myname:${param.myname}</h3>
    <br/>
    <br/>
    <h3>myage:${param.myage}</h3>
    <br/>
    <br/>
    <h3>取参数的方式：<%=request.getParameter("myname")%></h3>

</body>
</html>
