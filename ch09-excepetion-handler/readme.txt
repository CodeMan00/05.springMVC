ch09-exception-handler:异常处理

异常处理步骤:
1.新建maven web项目
2.加入依赖
3.新建一个自定义异常类，MyUserException，在定义它的子类NameException，AgeException
4.在controller层中抛出NameException，AgeException
5.创建一个普通类，作用全局异常处理类
    1）在类的上面加上@ControllerAdvice注解
    2）在类中的方法上加上@ExceptionHandler
6.创建处理异常的视图页面
7.创建springmvc的配置文件
    1）组件扫描器，扫描@Controller
    2）组件扫描器，扫描@ControollerAdvice所在的包
    3）声明注解驱动
