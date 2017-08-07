package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import com.fanchen.util.DesUtil;
import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */

@Controller
public class HomeController {

    final String denglu = "<a href=\"../register\"><span style=\"color: green; \">登录</span></a>";
    final String reg = "<a href=\"../register\"><span style=\"color: green; \">注册</span></a>";
    final String index = "<a href=\"../quit\"><span style=\"color: green; \">";
    final String quit = "<a href=\"../register\"><span style=\"color: green; \">注销</span></a>";
    String end = "</span></a>";

    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        List<Category> cs = categoryMapper.getAll();
        Long pn = categoryMapper.getPpNumber();
        Cookie cokLoginName = CookieUtil.getCookieByName(request, "secretName");
        Cookie cokLoginDate = CookieUtil.getCookieByName(request, "secretDate");
        Cookie cokLoginPortrait = CookieUtil.getCookieByName(request, "secretPortrait");

        if (cokLoginDate != null && cokLoginName != null) {
            String secretKey = "12345678";

            String secretName = cokLoginName.getValue();
            /**登录时间*/
//            String secretDate = cokLoginDate.getValue();
            if (cokLoginPortrait != null) {
                String secretPortrait = cokLoginPortrait.getValue();
                String portrait = DesUtil.decryption(secretPortrait, secretKey);

                System.out.println(portrait);

                model.addAttribute("portrait", portrait);
                model.addAttribute("cs", cs);
                model.addAttribute("pn", pn);
                String userName = DesUtil.decryption(secretName, secretKey);
                model.addAttribute("username", index + userName + end);
                model.addAttribute("reg_quit", quit);
                return "index";
            }
//            String loginDate = DesUtil.decryption(secretDate, secretKey);
            model.addAttribute("cs", cs);
            model.addAttribute("pn", pn);
            String userName = DesUtil.decryption(secretName, secretKey);
            model.addAttribute("username", index + userName + end);
            model.addAttribute("reg_quit", quit);
            return "index";
        }
        model.addAttribute("cs", cs);
        model.addAttribute("pn", pn);
        model.addAttribute("username", denglu);
        model.addAttribute("reg_quit", reg);
        return "index";
    }
}
