<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--这段代码获取base路径,同样是为了便于维护,如果我们进行了改动,那么它会自动的变更,
而不是人为的修改.--%>
<%
    String basePath = request.getScheme()+"://"+
                      request.getServerName()+":"+
                      request.getServerPort()+":"+
                      request.getContextPath() +"/";
%>
<html>
<head>
    <title>Title</title>
<%--    <base href="http://localhost:8085/ch06-path/"/>--%>
<%--    动态的获取base路径,便于以后得维护.--%>
    <base href="<%=basePath%>"/>


</head>
<body>
    <p>第一个springmvc的项目</p>
<%--    href:属性加上 / 时，/user/some.do 最终跳转到的地址为http://localhost:8085/user/some.do
               这个地址是缺少项目名的，所以访问不到资源。我们需要自己添加项目名到访问路径中。

        这种方式的缺陷：
            如果我们对项目名进行修改，那么我们还需要对所有引用该项目名的地方进行修改，这是不利于维护的。
            所以，我们可以通过EL表达式动态获取项目名
--%>
<%--    没有加EL表达式的形式--%>
<%--    <p><a href="/ch06-path/user/some.do">发起user/some.do的get请求</a></p>--%>

<%--    加上EL表达式的形式   推荐此方式--%>
<%--    <p><a href="${pageContext.request.contextPath}/user/some.do"></a></p>--%>



<%--href:属性地址不加 / , user/some.do 最终跳转到的地址为 http://localhost:8085/ch06-path/user/some.do
    这个地址是能够被servlet映射到的，所以能够正常处理。

    但是这种地址缺陷，当我把index.jsp的地址设置为 user/some.do，这是它就会通过some.do对应的控制器方法进行处理，在控制器方法中，我们就
    做一个操作，就是重新跳转到index.jsp页面，这是就会出现问题。
      第一次请求： 请求地址：http://localhsot:8085/user/some.do
               参数地址： http://localhsot:8085/user/
               资源： some.do

      控制器方法forword转发到index.jsp页面。

      第二次请求控制器处理：
        这时会使用参考地址（http://localhsot:8085/user/） + 相对地址（user/some.do）
        整体就是http://localhsot:8085/user/user/some.do 作为项目的请求地址，所以就会导致错误，


      解决办法：
        1，使用base标签
        2. 或者使用上面介绍的EL表达式的问题.
--%>
<%--    <p><a href="user/some.do">请求路径中，不带斜杠的user/some.do请求</a></p>--%>

<%--使用base标签处理相对路径问题--%>
    <p><a href="user/some.do">请求index.jsp</a></p>

</body>
</html>
