ch11-interceptor2: 多个拦截器

拦截器的实现步骤:
  1.新建maven项目
  2.加入依赖
  3.创建controller类
  4.创建一个普通类,是西安Intercepetor接口,实现该类的三个方法
  5.创建show页面
  6.创建springmvc的配置文件
    1)声明组件扫描器,扫描@Controller注解
    2)声明拦截器,并指定拦截的请求uri地址.








两个个拦截器，拦截路径都为 "/**" , 拦截顺序：
 先声明的拦截器先执行原则，首先对请求进行拦截。

【情况1】：拦截器1的preHandler方法返回值为true；拦截器2的preHandler方法返回值为true
执行结果：
Interceptor的preHandle
22222-拦截器的Interceptor的preHandle的方法
myController中的doSome方法
22222-拦截器的posthandle方法
posthandle
22222-拦截器的afterCompletion方法
afterCompletion方法



【情况2】：拦截器1的preHandler方法返回值为true；拦截器2的preHandler方法返回值为false
执行结果：
Interceptor的preHandle
22222-拦截器的Interceptor的preHandle的方法
afterCompletion方法


【情况3】拦截器1的preHandler方法返回值为false；拦截器2的preHandler方法返回值为true/false
执行结果：
Interceptor的preHandle