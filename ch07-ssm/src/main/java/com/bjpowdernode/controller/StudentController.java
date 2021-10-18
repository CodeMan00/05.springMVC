package com.bjpowdernode.controller;

import com.bjpowdernode.domain.Student;
import com.bjpowdernode.service.StudentService;
import com.bjpowdernode.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author gjd
 * @create 2021/10/13  17:44:14
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;


    //注册学生
    @RequestMapping(value = "addStudent.do")
    public ModelAndView addStudent(Student student){

        ModelAndView modelAndView = new ModelAndView();
        String info = "注册失败！";

        int rows = studentService.insertStudent(student);

        modelAndView.addObject("info",(rows>0 ? (info = "学生【" + student.getName() + "】注册成功！"):info));

        modelAndView.setViewName("result");
        return modelAndView;
    }

    //处理查询，响应ajax  返回的是json对象 注意：1.是否有jackson依赖  2.是否加注册注解驱动 <mvc:annotation-driven>  3.在处理器方法上加注解
    //此方法，返回List集合，会被框架转变为json对象的数组
    @ResponseBody
    @RequestMapping(value = "/queryStudent.do")
    public List<Student> queryStudent(){

        return studentService.findStudents();
    }
}
