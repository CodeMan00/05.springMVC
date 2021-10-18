ch10-interceptor: 拦截器

拦截器的实现步骤:
  1.新建maven项目
  2.加入依赖
  3.创建controller类
  4.创建一个普通类,是西安Intercepetor接口,实现该类的三个方法
  5.创建show页面
  6.创建springmvc的配置文件
    1)声明组件扫描器,扫描@Controller注解
    2)声明拦截器,并指定拦截的请求uri地址.


拦截器和过滤器的区别：
1.拦截器是springmvc框架提供的，而过滤器是servlet提供的
2.过滤器是实现filter接口， 而拦截器是实现handlerInterceptor接口
3.过滤器是用来设置request、response的参数，属性的，侧重对数据过滤的，而拦截器是用来验证请求的，能截断请求。
4.过滤器是在拦截器之前先执行的
5.过滤器tomcat服务器创建的对象，拦截器是springmvc创建的对象
6.过滤器是一个执行时间点，拦截器有三个执行时间点。
7.过滤器可以处理jsp、js、html等等，拦截器是侧重拦截对controller的请求，如果你的请求
    不会被DispatcherServlet接收，这个请求就不会执行拦截器的内容。