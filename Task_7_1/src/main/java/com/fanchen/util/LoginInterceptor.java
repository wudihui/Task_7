package com.fanchen.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 拦截处理程序的执行，在HandlerMapping调用之后，但在HandlerAdapter调用之前
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("启动拦截器，判断是否放行");

        /**直接获取cookie，有就判断是否匹配，没有就跳转到登陆页面*/
        Cookie cokLoginName = CookieUtil.getCookieByName(request, "secretName");
        Cookie cokLoginDate = CookieUtil.getCookieByName(request, "secretDate");

        /**如果Cookie不为空*/
        if (cokLoginName != null && cokLoginDate != null && cokLoginName.getValue() != null && cokLoginDate.getValue() != null) {
            /**获取两个Cookie的具体内容*/
            String secretName = cokLoginName.getValue();
            String secretDate = cokLoginDate.getValue();
            /**解密*/
            String secretKey = "12345678";
            String userName = DesUtil.decryption(secretName, secretKey);
            String loginDate = DesUtil.decryption(secretDate, secretKey);
            /**如果不为null说明解密成功是cookie*/
            boolean result; // 判断 cookie是否匹配
            if (userName != "" && loginDate != "") {
                result = true;
            } else {
                response.sendRedirect("register");
                result = false;
            }

            return result;

        }  // 获取不到浏览器cookie则跳转到登陆页面
        else {
            response.sendRedirect("register");
            return false;
        }
    }

    /**
     * 拦截处理程序的执行，在HandlerAdaoter调用之后，但在DispatcherServlet呈现视图之前
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 请求处理完成后的回调，即在视图渲染之后，可用于清理资源
     */
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    }


}