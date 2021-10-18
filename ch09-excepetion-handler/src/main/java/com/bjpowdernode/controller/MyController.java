package com.bjpowdernode.controller;

import com.bjpowdernode.exception.AgeException;
import com.bjpowdernode.exception.MyUserException;
import com.bjpowdernode.exception.NameException;
import com.bjpowdernode.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {


    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {

        ModelAndView mv = new ModelAndView();

        //根据请求参数抛出异常
        if(!"zs".equals(name))
            throw new NameException("姓名不正确!");

        if(age ==null || age >80)
            throw new AgeException("年龄不正确！");

       mv.addObject("myname",name);
       mv.addObject("myage",age);

       mv.setViewName("show");
       return mv;
    }
}
