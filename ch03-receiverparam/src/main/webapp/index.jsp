<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>提交参数给Controller</p>
<%--    post请求，传递中文时出现乱码情况，
        get请求，传递中文不会有乱码情况
--%>
    <form action="receiverproperty.do" method="post">
        姓名：<input type="text" name ="name">
        <br/>
        年龄：<input type="text" name = "age">
        <br/>
        <input type="submit" value="提交参数">
    </form>

    <br/>

    <p>请求参数名和处理器方法的形参不一样</p>
    <form action="receiverparam.do" method="post">
        姓名：<input type="text" name ="rname">
        <br/>
        年龄：<input type="text" name = "rage">
        <br/>
        <input type="submit" value="提交参数">
    </form>

    <p>使用java对象接收请求参数</p>
    <form action="receiverObject.do" method="post">
        姓名：<input type="text" name ="name">
        <br/>
        年龄：<input type="text" name = "age">
        <br/>
        <input type="submit" value="提交参数">
    </form>

</body>
</html>
