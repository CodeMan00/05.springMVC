<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
    <p>处理器方法返回String，表示视图名称</p>
    <form action="some.do" method="post">
        姓名：<input type="text" name ="name">
        <br/>
        年龄：<input type="text" name = "age">
        <br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <img src="static/images/lala.jpg" alt="我是一个静态资源，不能显示" style="width: 400px">
</body>
</html>
