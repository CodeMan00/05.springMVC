package com.bjpowdernode.handler;

import com.bjpowdernode.exception.AgeException;
import com.bjpowdernode.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gjd
 * @create 2021/10/14  11:15:49
 */

/**
 * @ControllerAdvice :控制器增强（也就是说给控制器类增加功能---异常处理功能）
 *
 *  位置：在类的上面
 *  特点：必须让框架知道这个注解所在的包名，需要springmvc配置文件声明组件扫描器。
 *      指定@ControllerAdvice所在的包名
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 定义方法，处理发生的异常。
     *     处理的异常的方法和控制器方法的定义一样，可以有多个参数，可以有ModelAndView
     *     String， void 对象类型的返回值
     */
    //形参是一个Exception,表示Controller中抛出的异常对象，通过形参可以获取发生的异常信息。
    // @ExceptionHandler(异常的class)；表示异常的类型，当发生此类型异常时，由该方法处理.
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){

        //处理NameException的异常

        /**
         *  异常发生的处理逻辑
         *  1.需要把异常记录下来,记录到数据库,日志文件
         *    记录日志发生的时间和哪个方法发生的,异常错误信息
         *
         *  2.发送通知,把异常得信息通过邮件,短信或者微信发送给相关人员.
         *  3.给用户友好提示.
         */
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","你的姓名必须zs,其他用户不能访问");
        mv.addObject("ex",exception);

        mv.setViewName("nameError");
        return mv;
    }

    /**
     * 处理AgeException的异常
     */
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){


        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","你得年龄不能大于80");
        mv.addObject("ex",exception);

        mv.setViewName("ageError");
        return mv;
    }

    /**
     *  处理其他异常,NameException,AgeException以外的暂不知道的异常
     *
     *  这时我们在注解@ExceptionHandler上,就不需要在加上指定类型的class类了,这样他就能接收
     *  其他我们没有定义异常处理方法的异常了.
     */
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){


        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","对不起,我们下班了!!!");
        mv.addObject("ex",exception);

        mv.setViewName("defaultError");
        return mv;
    }

}
