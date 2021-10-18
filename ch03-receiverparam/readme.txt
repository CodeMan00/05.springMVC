接收请求参数，使用的处理器方式的形参
1）HttpServletRequest
2）HttpServletResponse
3）HttpSession
4）用户提交的数据


接收用户提交的参数：
1.逐个接收
2.对象接收

注意：

    在提交请求参数时，get请求方式中文没有乱码
    使用post请求方式提交，中文会有乱码，需要过滤器处理乱码问题。
    过滤器可以自定义，也可以使用框架中提供的过滤器。
    CharacterEncodingFilter







需求：
    用户在页面发起一个请求，请求交给springmvc控制器对象，
    并显示请求的处理结果(在结果页面显示一个欢迎语句)

步骤:
    1.新建web maven工程
    2.加入依赖
        spring-webmvc依赖,间接的把spring的依赖都加入到项目中,因为它是基于spring的.
        jsp,servlet依赖,底层是基于servlet,是对servlet的封装
    3.重点: 在web.xml文件中注册springmvc框架的核心对象DispatcherServlet
        1) DispatcherServlet叫做中央处理器,是一个servlet,它的父类继承HttpServlet
        2) DispatcherServlet也叫做前端控制器(front controller)
        3) DispatcherServlet负责接收用户提交的请求,调用其它的控制器对象,并把请求的处理结果
            显示给用户

    4.创建一个发起请求的页面 index.jsp

    5.创建控制类
        1)在类的上面加上@Controller注解,创建对象,并放入到springmvc容器中
        2)在类中的方法上加入@RequestMapping注解
    6.创建一个作为结果的jsp,显示请求的处理结果.

    7.创建springmvc的配置文件(和spring的配置文件一样)
        1)声明主键扫描器,指定@Controller注解所在的包名
        2)声明视图解析器.帮助处理视图的.




  springmvc 请求处理流程：
    发送some.dao请求给tomcat(web.xml----->url-pattern 知道 *.do 的请求给 DispatherServlet)
    DispatcherServlet会根据springmvc.xml配置文件知道 some.do对应的处理方法为doSome()
    DispatcherServlet把some.do的请求转发给了MyController的doSome方法。然后框架执行doSome方法
    把得到的ModelAndView进行处理，转发到show.jsp