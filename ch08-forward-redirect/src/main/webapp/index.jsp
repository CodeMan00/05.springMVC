<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+
                      request.getServerName()+":"+
                      request.getServerPort()+":"+
                      request.getContextPath() +"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>"/>
</head>
<body>
    <p>当处理器方法返回ModelAndView实现转发操作</p>
    <form action="doForward.do" method="post">
        <input type="submit" value="提交请求"/>
    </form>

    <br/>
    <br/>
    <br/>

    <p>当处理器方法返回ModelAndView实现重定向操作</p>
    <form action="doRedirect.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <button type="submit" value="提交"/>
    </form>
</body>
</html>
