package com.bjpowdernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author gjd
 * @create 2021/10/14  12:10:46
 */

//拦截器类，拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {

    /**
     *   拦截器的三个方法和控制层方法的执行顺序：
     *      1. 拦截器的preHandle方法先执行，它决定了后面3个方法是否能够执行
     *      2. 如果preHandle返回true，则执行控制器层的处理器方法
     *      3. 执行拦截器的postHandle方法
     *      4. 执行拦截器的afterCompletion方法
     */


    private long begin ;
    /**
     * 预处理方法
     * @param request  请求
     * @param response  应答
     * @param handler  被拦截的控制器对象
     * @return        布尔值 如果值为true，请求通过了拦截器的验证，可以执行处理器方法
     *                      如果false，表示没有通过拦截器的验证，所以不能执行处理器方法，同时
     *                      拦截器的postHandle、afterCompletion 方法也不会执行。
     * @throws Exception
     * 特点：
     *      1、在控制器方法（MyController的doSome方法）执行之前先执行。用户的请求首先到达此方法
     *      2、在这个方法中可以获取请求的信息，验证请求是否符合要求。可以验证用户是否登录，验证用户
     *          是否有权限访问某个地址（url），如果验证失败，可以截断请求，请求不能被处理
     *          如果验证成功，可以放行请求，此时控制器方法才能执行。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        begin = System.currentTimeMillis();

        System.out.println("Interceptor的preHandle");
        return true;
    }

    /**
     *  后处理方法
     * @param request
     * @param response
     * @param handler  被拦截的处理器对象
     * @param modelAndView  处理器方法的返回值
     * @throws Exception
     *
     * 特点：
     *  1.在处理器方法之后执行的，
     *  2.能够获取到处理器的方法的返回值，可以修改ModelAndView，可以修改ModelAndView中的数据和视图，可以影响到
     *      最后的执行结果。
     *  3.主要对元素的执行结果进行二次修正。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("posthandle");

        //对原来的doSome的执行结果，进行调整
        if(modelAndView !=null){
            modelAndView.addObject("mydate",new Date());
            modelAndView.setViewName("other");
        }
    }

    /**
     * 最后执行的拦截器方法
     * @param request
     * @param response
     * @param handler  被拦截的处理器对象
     * @param ex   我们程序中发生的异常
     * @throws Exception
     *
     * 特点：
     *  1.在请求处理完成后执行的。在框架中规定当你的视图处理完成后，对视图执行了forward方法，就认为请求处理完成。
     *  2.最后执行的一个方法，一般用来做资源回收工作。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long end = System.currentTimeMillis();

        System.out.println("afterCompletion方法");
        System.out.println("系统执行时间："+(end-begin));
    }
}
