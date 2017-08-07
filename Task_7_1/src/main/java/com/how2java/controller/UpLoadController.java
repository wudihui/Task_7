package com.how2java.controller;

/**
 * Created by Administrator on 2017/8/6.
 */

import com.fanchen.util.CookieUtil;
import com.fanchen.util.DesUtil;
import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Register;
import com.how2java.service.TencentYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.Iterator;

@Controller
public class UpLoadController {

    @Autowired
    TencentYunService tencentYunService;

    @Autowired
    CategoryMapper categoryMapper;
    /*
      * 通过流的方式上传文件
      * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
      */

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {

        //用来检测程序运行时间
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());

        try {
            //获取输出流
            OutputStream os = new FileOutputStream("E:/" + new Date().getTime() + file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is = file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while ((temp = is.read()) != (-1)) {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法一的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "none";
    }

    @RequestMapping("fileUpload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        long startTime = System.currentTimeMillis();
        /**输出上传时的名字含后缀名*/
        System.out.println("fileName：" + file.getOriginalFilename());
        /**在临时存放在本地的地址*/
        String path = "E:/" + file.getOriginalFilename();
        File newFile = new File(path);
        /**直接把CommonsMultipartFile传入的文件写入到上面设置的路径里*/
        file.transferTo(newFile);
        try {
            /**密匙*/
            String secretKey = "12345678";
            /**从cookie中获取加密后的邮箱*/
            Cookie cokEmail = CookieUtil.getCookieByName(request, "secretEmail");
            if (cokEmail != null) {
                /**把email的数据取出*/
                String secretEmail = cokEmail.getValue();
                /**此时是输出的是加密的邮箱*/
                System.out.println(secretEmail);
                /**解密*/
                String email = DesUtil.decryption(secretEmail, secretKey);
                System.out.println(email);
                /**转发到腾讯云,并返回外链*/
                String pth = tencentYunService.upDate(path);
                System.out.println("地址..." + pth);
                Register register = new Register();
                register.setEmail(email);
                register.setPortraitpath(pth);
                /**根据邮箱更新头像字段*/
                categoryMapper.setPortrait(register);

                long endTime = System.currentTimeMillis();
                System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
            }

        } catch (Exception e) {
            System.out.println("上传头像出错....");
        }
        return "none";
    }

    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("springUpload")
    public String springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = "E:/springUpload" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "none";
    }
}
