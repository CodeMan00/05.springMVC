package com.bjpowdernode.controller;

import com.bjpowdernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class MyController {

    /**
     * 参数问题1：
     * 逐个接收请求参数
     *  要求：处理器方法的形参名和请求中的参数名必须一致
     *    同名的请求参数赋值给同名的形参
     *
     *
     *  框架接收请求参数：
     *      1.使用request对象接收请求参数
     *          String name = request.getParameter("name");
     *          String age = request.getParameter("age");
     *
     *     2.springmvc框架通过中央调度器DispatcherServlet调用MyController的
     *          doSome方法，调用方法是，按名称对应，参数的前后位置无所谓，把接收的参数赋给形参。
     *          参数都是String类型，但是此方法中我们需要int类型，那么就
     *          会进行类型转换
     *          注意：这里有bug，如果我们在年龄字段里传递的不是字符串型数字，那么在转换是就会
     *                  出问题，会出现400的状态码。
     *
     *     400的状态码是客户端错误，表示提交请求参数过程中，发生了错误。
     *
     *
     *     如果年龄我们没有传递值，则会400状态码，我们可以把int改为Integer类型，
     *     可避免这种情况。但是我们传递的不是字符串数字类型，还会出现400状态码
     */
    @RequestMapping(value = "/receiverproperty.do")
    public ModelAndView doSome(String name ,Integer age){

        ModelAndView mv = new ModelAndView();
        System.out.println("doSome方法，获取name："+name+" ,  age："+age);
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");

        return mv;
    }

    //解决post请求乱码问题   ，除了这种，还可以在web.xml文件中通过过滤器进行配置
//    public void doGet(HttpServletRequest request) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//    }


    /**
     * 参数问题2：
     * 请求的参数名处理器方法的形参名不一样
     *
     * @RequestParam:解决请求中参数名和形参名不一样的问题。
     *   属性：value 请求中的参数名称,value可以省去，只写参数名即可
     *        required: 是一个布尔类型，默认是true， true表示请求参数中必须包含该参数，如果是false，如果没有该参数，也不会报错
     *        defaultValue：是一个字符串， 表示默认值，如果有默认值的情况下，required无效
     *   位置： 在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "/receiverparam.do")
    public ModelAndView doSomeParam(@RequestParam(value = "rname") String name , @RequestParam(value = "rage") Integer age){

        ModelAndView mv = new ModelAndView();
        System.out.println("doSome    name="+name+" ,  age="+age);
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");
        return mv;
    }

    /**
     * 参数3：
     *  1.如果请求参数过多，我们可以通过对象来作为请求参数，对象的属性名和请求参数名保持一致。
     *  2.框架会创建形参的java对象，并通过对象的set方法给属性赋值，请求中的参数是name，框架会调用setName（）；
     *  3.可以不添加注解，也可以加上@ModelAttribute
     *
     */
    @RequestMapping("receiverObject.do")
    public ModelAndView doParamObject(Student student){

        System.out.println("name=  "+student.getName()+", age = "+student.getAge());
        ModelAndView mv = new ModelAndView();

        mv.addObject("myname",student.getName());
        mv.addObject("myage",student.getAge());
        mv.setViewName("show");
        return  mv;
    }
}
