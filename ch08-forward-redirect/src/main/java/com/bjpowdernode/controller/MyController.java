package com.bjpowdernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.print.MultiDoc;

/**
 * @author gjd
 * @create 2021/10/11  13:03:38
 */
@Controller
public class MyController {


    /**
     * 处理器方法返回  ModelAndView 实现转发forward
     *
     * 语法：
     *      setVeiwName("forward:视图文件完整路径")
     *  特点：
     *      不和视图解析器一同使用，就当项目中没有视图解析器。
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doSome(){

        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","欢迎使用springmvc做web开发！");
        mv.addObject("fun","执行的doForward方法！");
        /**
         *  视图解析器书写那么方便为什么不用，反而用forward这么麻烦的写法？
         *
         *     如果我们访问的资源，视图解析器无法解析，那么使用forward就可以解决这个问题。
         */
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }

    /**
     * 处理器方法返回ModelAndView，实现重定向redirect
     * 语法：
     *  setViewName("redirect",视图完整路径)；
     *  redirect特点： 不和视图解析器一起使用。
     *
     *  框架对重定向的操作：
     *      1.框架会把Model中的简单类型数据，转为String类型，作为hello.jsp 的get请求参数使用。
     *          目的是在 doRedirect.do 和hello.jsp 两次请求之间可以传递数据。
     *
     *      2.因为重定向是客户端发送了两次请求给服务端，那么第一次传来的参数是保存在request1中的作用域。
     *          第二次请求，request对象不同，无法获取到request1中的数据。但是在重定向时，第一次传递的参数
     *          会加在url地址中，我们可以通过从url地址中获取参数的形式来获取第一次传递的参数。
     *          获取方式：
     *              在目标页面 hello.jsp 可以获取参数集合对象 ${param.参数名} 获取请求参数值
     *
     *      3.重定向到WEB-INF目录下的页面是不行的，404，这是客户端直接请求WEB-INF被保护页面，是不允许得。
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doRedirect(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }

}
