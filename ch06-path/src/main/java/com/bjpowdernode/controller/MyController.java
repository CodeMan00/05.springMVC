package com.bjpowdernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gjd
 * @create 2021/10/11  13:03:38
 */
@Controller
public class MyController {


    @RequestMapping(value = "/user/some.do")
    public ModelAndView doSome(){

        ModelAndView mv = new ModelAndView();

//        mv.addObject("msg","欢迎使用springmvc做web开发!!");
//        mv.addObject("fun","执行的是doSome方法");

        mv.setViewName("/index.jsp");

        return mv;
    }
}
