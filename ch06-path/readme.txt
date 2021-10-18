ch06-path:解决jsp页面中的路径问题，关于路径中是否带有 / 的问题。

在jsp，html中使用的地址都是在前端页面中的地址，都是相对地址。

地址分类：
    1.绝对地址
        带有协议名称的都是绝对地址， http://www.baidu.com
    2.相对地址
        没有协议开头的都是相对地址。 例如：user/some.do

        相对地址不能独立使用，必须有一个参考地址，通过参考地址加上相对地址本身才能
        指定资源。
    3.参考地址。
        张三同学  1班有张三  2班也有张三    这时候我们需要参考地址定位到1班 然后找到张三

       在index.jsp访问页面中，访问地址不加 "/"
       访问的是： http://localhost:8085/ch06-path/index.jsp
       路径：http://localhost:8085/ch06-path/
       资源：index.jsp

       在index.jsp发起 user/some.do 请求，访问地址为：http://localhost:8085/ch06-path/user/some.do
        当你的地址没有斜杠开头，例如user/some.do,当你点击链接时，访问地址是当前页面的地址
        加上链接的地址，也就是http://localhost:8085/ch06-path/ + user/some.do
        我们称http://localhost:8085/ch06-path/ 为参考地址。

        当你的index.jsp页面中的访问地址加上 "/"
         访问的是：http://localhost:8085/ch06-path/index.jsp
         路径：http://localhost:8085/ch06-path/
         资源：index.jsp

         点击 /user/some.do 访问地址变为 http://localhost:8085/user/some.do
          参考地址：http://localhost:8085
          这个地址是没有正常访问到页面的，其实这个地址是缺少了/ch06-path,这是我们就需要
          自己在index.jsp文件的访问路径中添加上项目名。