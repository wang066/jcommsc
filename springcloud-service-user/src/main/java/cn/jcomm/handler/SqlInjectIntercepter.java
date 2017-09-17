package cn.jcomm.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by jowang on 2017/4/21 0021.
 * 1.鉴权
 * 2.sql注入
 * 3.xsrf
 * 4xss
 */
public class SqlInjectIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String[] values = request.getParameterValues(name);
            for (int i = 0; i < values.length; i++) {
                //进行校验
//                if(Utility.hasAttackStr(values[i])){
//                    if(!(values[i].equals("DELETE") && name.equals("_method")) ){
//                        response.setContentType("text/html;charset=utf-8");
//                        response.getWriter().print("请不要尝试注入<br><a href='#' onclick='history.Go(-1)'>返回</a>");
//                        return false;
//                    }
//                }
            }
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
