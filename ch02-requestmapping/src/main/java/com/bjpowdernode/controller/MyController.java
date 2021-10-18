package com.bjpowdernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gjd
 * @create 2021/10/11  13:03:38
 */
@Controller //创建控制器对象，改对象放在springmvc中，定义在类的上面，和spring中的@Service、@Component类似
public class MyController { //能处理请求的都是控制器

    /**
     * 处理用户提交的请求，springmvc中是使用方法处理的，方法是自定义的，可以有多个返回值，多种参数，方法名称自定义
     */

    /**
     * 使用doSome方法处理some.do请求
     * @RequestMapping:请求映射，作用把一个请求地址和一个方法绑定在一起。
     *              一个请求指定一个方法处理
     *      属性：
     *          value：是一个字符串，表示请求的uri地址，value值必须是唯一的。在使用时，推荐地址以“ /” 开头
     *      位置：
     *              1。在方法的上面  2.在类的上面
     *      说明：使用RequestMapping修饰的方法叫做处理器方法或者控制器方法。
     *              使用@RequestMapping修饰的方法可以处理请求，类似于Servlet中的doGet ， doPost
     */

    /**
     * 返回值： ModelAndView   表示本次请求的处理结果
     *  Model：数据，请求处理完成后，要显示给用户的数据
     *  View ：视图，比如jsp等等。
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){

        ModelAndView mv = new ModelAndView();

        //添加数据   框架在请求的最后把数据放入到request作用域 相当于request.setAttribute("msg","欢迎使用springmvc做web开发!!");
        mv.addObject("msg","欢迎使用springmvc做web开发!!");
        mv.addObject("fun","执行的是doSome方法");

        //指定视图,指定视图的完整路径
        //框架对视图指定的forWord操作,request.getDispatcher("/show.jsp").forword(...);


//        mv.setViewName("/show.jsp");
        //把show.jsp放到WEB-INF里面，WEB-INF是受保护的，无法直接从客户端访问，所以可以解决了直接在浏览器上访问show.jsp页面的问题。
//        mv.setViewName("/WEB-INF/view/show.jsp");
//        mv.setViewName("/WEB-INF/view/other.jsp");

        //使用视图解析器简化上面的路径写法  我们在springmvc.xml配置视图解析器，将WEB-INF/view/ 和 .jsp 作为前缀和后缀，这样就不用在写了。
        // 指定视图解析器后，我们使用逻辑名称（jsp的文件名）来指定视图。框架会使用视图解析器的前缀+逻辑名称+后缀 组成完整路径。
        mv.setViewName("show");
        mv.setViewName("other");
        //返回mv
        return mv;
    }


    //这两个请求都使用doOther方法来处理
    @RequestMapping(value = {"/other.do","second.do"})
    public ModelAndView doOther(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发!!");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("show");
        mv.setViewName("other");
        return mv;
    }
}
