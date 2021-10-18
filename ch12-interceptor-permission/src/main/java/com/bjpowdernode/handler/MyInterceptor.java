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


    //验证登录的用户信息，正确返回true  错误返回false
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String login_name = "";
        //从session中获取name的值
        Object param = request.getSession().getAttribute("name");

        if( param != null){
            login_name = (String) param;
        }
        if(!"张三".equals(login_name)){
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
            return  false;
        }
        
        return true;
    }
}
