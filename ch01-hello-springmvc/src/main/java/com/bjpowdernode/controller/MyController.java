package com.bjpowdernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gjd
 * @create 2021/10/11  13:03:38
 *
 * @RequestMapping
 *   value:所有的请求地址的公共部分，叫做模块名称
 *   位置：放在类的上面
 *
 *   本例中，请求的地址有公共部分--test，可以把test通过@RequestMapping注解，
 *   定义test作为value属性的值，这样简单了。
 */
@RequestMapping(value = "/test")
@Controller
public class MyController {

    /**
     * @RequestMapping:
     *   属性：method 表示请求的方式，它是一个数组，可以选择多个枚举值。取值：RequestMethod类的枚举值
     *          例如表示get请求，RequestMethod.GET
     *            表示post方式，RequestMethod.POST
     *
     *      如果不指定，那么方法就没有限制。
     */

   // @RequestMapping(value = "/test/some.do")
    @RequestMapping(value = "/some.do" ,method= {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView doSome(){

        ModelAndView mv = new ModelAndView();

        //添加数据   框架在请求的最后把数据放入到request作用域 相当于request.setAttribute("msg","欢迎使用springmvc做web开发!!");
        mv.addObject("msg","欢迎使用springmvc做web开发!!");
        mv.addObject("fun","执行的是doSome方法");

        mv.setViewName("show");
        mv.setViewName("other");
        //返回mv
        return mv;
    }


//    @RequestMapping(value = {"/test/other.do","test/second.do"})
    @RequestMapping(value = {"/other.do","/second.do"},method = RequestMethod.POST)
    public ModelAndView doOther(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发!!");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("show");
        mv.setViewName("other");
        return mv;
    }
}
