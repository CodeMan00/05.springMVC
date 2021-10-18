ch04-return:
处理器方法的返回值表示请求的处理结果
1.ModelAndView：有效数据和视图，对视图执行forward
2.String：表示视图，可以是逻辑名称，也可以是完整视图名称
3.void:不能表示数据，也不能表示视图。这种方式常用在处理ajax的时候。
    通过HttpServletResponse输出结果，响应ajax请求。ajax请求服务器端返回的就是数据，和视图无关。
4.Object：例如String,Integer,Map,List,Student都是对象，对象有属性，属性就是数据
            所以返回Object表示数据，和视图无关。可以使用对象表示的数据，相应ajax请求。

    现在做ajax，主要使用jsno的数据格式。  实现步骤：
        1.加入处理json工具库的依赖，springmvc默认使用jackson
        2.在springmvc配置文件之间 加入<mvc:annotation-driven>注解驱动，它的作用
            就是把对象转换为json格式。 json = om.writeValueAsString(s);
        3.在处理器方法上面加入@ResponseBody注解，它的作用就是把json对象输入。
                 response.setContentType("application/json;charset=utf-8");
                 PrintWriter writer = response.getWriter();
                 writer.println(json);
            @ResponseBody注解：放在处理器方法上，通过HttpServletResponse输出数据。




       springmvc处理器返回Object，可以转为json输出到浏览器，相应ajax的内部原理：
        1.<mvc:annotation-dirven>注册驱动，
            功能：完成java对象到json、xml、text、二进制等数据格式的转换.
            <mvc:annotation-dirven>在加入到springmvc配置文件后，会自动创建HttpMessageConverter接口的
            7个实现类，包括MappingJackson2HttpMessageConterver（使用jackson工具库中的ObjectMapping对象实现java对象转换为字符串）

           它实现了HttpMessageConverter接口，该接口的功能是：
            定义了java转为json、xml等数据格式的方法。这个接口有很多的实现类。
            这些实现类完成了java到json，java到xml，java对象到二进制数据的转换。

         下面两个方法是控制类把结果输出到浏览器时使用的：
           boolean canWrite(Class<?> var1,@Nullable MediaType var2);
           void write(T var1,@Nullable MediaType var2, HttpOutputMessage var3);

        例如处理器的方法为：
            @ReqeustMapping(value="/returnObject")
            public Student returnObj(HttpServletRequest request, String name,Integer age){

                    Student student = new Student();
                    student.setName("lisi");
                    student.setAge(12);
                    return student;
            }

       1.canWrite的作用：检查处理器方法的返回值，能不能转换为var2表达的数据格式。
        检查student(lisi,0)能不能转换为var2表达对的数据格式，如果检查能转换为json，canWrite方法返回true
        MediaType：表示数据格式，例如 json、xml等。
       2.write方法：把处理器方法的返回值对象，调用jackson中的ObjectMapper转换为json字符串。
        json = om.writeValueAsString(student);










ch03-receiverparam:
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







ch02-requestmapping:
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