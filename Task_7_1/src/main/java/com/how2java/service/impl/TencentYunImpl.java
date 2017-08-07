package com.how2java.service.impl;


import com.how2java.service.TencentYunService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TencentYunImpl implements TencentYunService {

    public COSClient Key() {
        // 设置用户属性, 包括appid, secretId和SecretKey
        // 这些属性可以通过cos控制台获取(https://console.qcloud.com/cos)
        long appId = 写自己的;
        String secretId = "写自己的";
        String secretKey = "写自己的";
        // 初始化客户端配置
        ClientConfig clientConfig = new ClientConfig();
        // 设置bucket所在的区域，比如广州(gz), 天津(tj)
        clientConfig.setRegion("gz");
        // 初始化秘钥信息
        Credentials cred = new Credentials(appId, secretId, secretKey);
        // 初始化cosClient
        COSClient cosClient = new COSClient(clientConfig, cred);
        return cosClient;
    }

    @Override
    public String upDate(String localFilePath) {
        try {
            String bucketName = "xiuzhenyuan";
            String time = String.valueOf(new Date().getTime());
            /**在服务器的位置*/
            String cosFilePath = "/" + time + ".jpg";
            UploadFileRequest uploadFileRequest =
                    new UploadFileRequest(bucketName, cosFilePath, localFilePath);
            uploadFileRequest.setEnableShaDigest(false);
            String uploadFileRet = Key().uploadFile(uploadFileRequest);
            System.out.println("upload file ret:" + uploadFileRet);
            /**外链生成*/
            return "http://xiuzhenyuan-1253633260.cosgz.myqcloud.com/" + cosFilePath;
        } catch (Exception e) {
            System.out.println("上传头像出错");
            return null;
        }
    }
}