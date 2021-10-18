package com.bjpowdernode.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age){

        ModelAndView modelAndView = new ModelAndView();

        System.out.println("name="+name+" , age="+age);

        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);

        modelAndView.setViewName("show");

        return modelAndView;
    }
}
