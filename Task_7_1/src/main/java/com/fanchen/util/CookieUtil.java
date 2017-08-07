package com.fanchen.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    // 接口方式设置cookie
    public static void addCookie(HttpServletResponse response,String name,String value){
        Cookie cookie = new Cookie(name,value);
//        /代表所有页面都可以使用该Cookie
        cookie.setPath("/");
//        存活时间
        cookie.setMaxAge(60);
        response.addCookie(cookie);
    }

    // 获取cookie
    public static Cookie getCookieByName(HttpServletRequest request,String name){
//        拿到cookie的内容
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
//        拿到cookie的名字
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }

    //将cookie封装到Map（非接口）
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}

