package com.bjpowdernode.controller;

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

    /***
     *  处理器方法返回String，表示逻辑视图名称，需要配置视图解析器。
     *  如果我们还想把请求参数传递到show页面中，有两种方式：
     *      1.通过HttpServletRequest 的setAttribute方法，添加到request域中
     *      2.用javaBean对象封装请求数据，那么可以直接从show.jsp页面中获取请求参数
     *
     *  这是的请求参数是封装到了Java对象中，而这个对象在request域中。
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(Student student){

        //show是逻辑视图名称，项目中配置了视图解析器,框架对视图执行forward转发操作
        return "show";

        //使用完整视图路径作为返回值，那么就不能配置视图解析器了，否则就会报错。
       // return "/WEB-INF/view/show.jsp";
    }

    /**
     * 处理器方法返回void，相应ajax请求，
     */
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void returnVoidAjax(HttpServletResponse response,String name,Integer age) throws IOException {

        System.out.println("name:"+name+",   age="+age);

        //处理ajax，使用jason做数据格式
        Student s = new Student(name,age);

        String json = "";

        //把结果的对象转为json格式的数据
        if(s!=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(s);
            System.out.println("student转换的json："+json);
        }

        //输出数据，响应ajax请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }

    /**
     *  处理器方法返回student对象，通过框架转为json，相应ajax请求。
     *  @ResponseBody:
     *     作用：将方法的返回值，以特定的格式写入到response的body区域，进而将数据返回给客户端。
     *              当方法上面没有写ResponseBody,底层会将方法的返回值封装为ModelAndView对象。
     *              如果返回值是字符串，那么直接将字符串写到客户端；如果是一个对象，会将对象转化为json串，然后写到客户端。
     *
     *      注意:如果返回对象,按utf-8编码。如果返回String，默认按iso8859-1编码，页面可能出现乱码。
     *              因此在注解中我们可以手动修改编码格式，例如@RequestMapping(value="/cat/query",produces="text/html;charset=utf-8")，
     *              前面是请求的路径，后面是编码格式。
     *
     *     原理
     *          控制层方法的返回值是如何转化为json格式的字符串的？其实是通过HttpMessageConverter中的方法实现的，它本是一个接口，
     *          在其实现类完成转换。如果是bean对象，会调用对象的getXXX（）方法获取属性值并且以键值对的形式进行封装，进而转化为json串。
     *          如果是map集合，采用get(key)方式获取value值，然后进行封装。
     *
     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student returnStudentJson(String name, Integer age){

        Student student = new Student("李四同学",33);

        return student;
    }


    @RequestMapping(value = "/returnStudenstJsonArray.do")
    @ResponseBody
    public List<Student> returnStudenstJsonArray(String name, Integer age){

        List<Student> lists = new ArrayList<>();
        Student student = new Student("李四同学",33);
        Student student1 = new Student("张三同学",12);
        Student student2 = new Student("闪闪",44);

        lists.add(student);
        lists.add(student2);
        lists.add(student1);
        return lists;
    }

    /**
     *  处理器方法返回的是String，这里的String不是视图，而是数据
     *     区分返回值字符串是视图还是数据，看有没有@ResponseBody注解，也就是数据，没有就是视图
     *
     * @RequestMapping：
     *      produces属性可以设置返回数据的【类型】以及【编码】
     */
    @RequestMapping(value = "returnStringData.do",produces = "text/plain:charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){

        return "Hello World! 返回的String是数据，不是视图！";
    }
}
