ch07-ssm: ssm整合开发

ssm : spingMVC spring mybatis

SpringMVC: 视图层,界面层, 负责接收请求,显示处理请求的.
Spring: 业务层,管理Service,dao,工具类对象.
Mybatis: 持久层,访问数据库的


用户发送请求 --->  SpringMVC接收请求 ---> Spring中的Service对象处理请求
在spring中的service处理请求时,可能需要调用dao层接口,进行数据库 ---> Mybatis处理数据

mybatis返回结果 ---> 给Spring的Service对象  ---> service对象将结果返回给Controller
springMVC根据方法的返回值把返回结果呈现给用户.

SSM整合也叫做SSI ,i是ibatis,也就是mybatis的前身.整合中有两个容器
1.第一个容器就是springmvc容器,管理controller控制器对象
2.第二个容器就是spring容器,管理service,dao,工具类对象
我们要做的是把使用的对象交给合适的容器创建和管理对象.把controller还有web开发的相关
对象交给spring容器,这些web用的对象写在springmvc的配置文件中.

service,dao对象定义在spring的配置文件中,让spring管理这些对象.


springmvc容器和spring容器是有关系的，关系已经确定好了。
springmvc容器是spring容器的子容器，类似java中的继承。
在子容器中的controller可以访问父容器中的service对象，就可以实现controller使用service对象。


实现步骤：
    0.使用mybatis数据库中的students表(id auto_increment, name, age)
    1.新建maven项目，web项目
    2.加入依赖 springmvc spring mybatis  mysql驱动， druid连接池  jsp  servlet依赖
    3.写web.xml
        1)注册DispatcherServlet 目的：  1.创建springmvc容器对象，才能创建controller类对象  2.创建的是servlet，才能接收用户的请求。
        2)注册spring的监听器：ContextLoaderListener 目的：创建spring容器对象，才能创建service，dao对象。
        3)注册字符集过滤器，解决post请求乱码问题。
    4.创建包。Controller包，service，dao实体类包名创建好。
    5.写springmvc ,spring,mybatis的配置文件和数据库属性配置文件
    6.写代码。dao接口，mapper文件，service和实现类，controller，实体类
    7.写页面。

