package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import com.fanchen.util.DesUtil;
import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/5.
 */
@Controller
public class LoginController {

    final String success = "你登录成功了";
    final String failure = "用户名或密码错误,请重试...";

    @Autowired
    CategoryMapper categoryMapper;
    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException, NullPointerException {
        String key = "12345678";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            //获取email相对的对象
            Register reg = categoryMapper.getMP(email);
            //密码相同则添加Cookie
            if (reg.getPassword().equals(password)) {
                //加密当前时间
                String date = DesUtil.encryption(df.format(new Date()), key);
                //加密邮箱
                String e_mail = DesUtil.encryption(email, key);
                //加密用户名
                String name = DesUtil.encryption(reg.getUsername(), key);
                // 添加Cookie
                CookieUtil.addCookie(response, "secretName", name);
                CookieUtil.addCookie(response, "secretDate", date);
                CookieUtil.addCookie(response, "secretEmail", e_mail);
                //如果有头像字段就添加到Cookie
                System.out.println("头像外链.........."+reg.getPortraitpath());
                if (reg.getPortraitpath()!=null){
                    String desportrait = DesUtil.encryption(reg.getPortraitpath(),key);
                    CookieUtil.addCookie(response,"secretPortrait",desportrait);
                }
                //发送成功信息
                model.addAttribute("success", success);
                return "ok";
            } else {
                model.addAttribute("failure", failure);
                return "register";
            }
        } catch (NullPointerException e) {
            model.addAttribute("failure", failure);
            return "register";
        } catch (Exception e) {
            System.out.println("登录出错了,加密出错");
            return "register";
        }
    }
}
