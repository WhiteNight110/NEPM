package com.neusoft.nepm.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.neusoft.nepm.service.SendMessageService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SendMessageServiceImpl implements SendMessageService {
    @Override
    public boolean send(String phone, String templateCode, Map<String, Object> code) {
            //github无法上传密钥配置对象
            DefaultProfile profile = DefaultProfile.getProfile("","","");
            //初始化配置对象 com.aliyuncs.profile.DefaultProfile 。 Profile 对象存放 your-access-key-id、your-access-key-secret 和 your-region-id
            //实例化一个客户端，从 com.aliyuncs.IAcsClient 类生成对象 client
            IAcsClient client = new DefaultAcsClient(profile);

            // 创建API请求并设置参数
            //创建对应 API 的 Request 。 类的命名规则为 API 方法名加上 Request
            SendSmsRequest request = new SendSmsRequest();
            //设置请求类 request 的参数。 通过 request 类的 setXxx 方法设置必要的信息，即 API 中必须要提供的信息，通过 set 方法设置参数
            //手机号、验证码、签名、模板
            request.setPhoneNumbers(phone); // 该参数值为假设值，请您根据实际情况进行填写
            request.setSignName("NEPM实训项目"); // 该参数值为假设值，请您根据实际情况进行填写
            request.setSysMethod(MethodType.POST);
            request.setTemplateCode(templateCode);
            //构建验证码
            request.setTemplateParam(JSONObject.toJSONString(code));
            try {
                //通过 client 对象获得对应 request 响应 response
                SendSmsResponse response = client.getAcsResponse(request);
                System.out.println(JSON.toJSONString(response));
                // 打印您需要的返回值，此处打印的是此次请求的 RequestId
                System.out.println(response.getRequestId());
                return response.getMessage().equals("OK");
            } catch (ServerException e) {
                //服务端报错
                e.printStackTrace();
            } catch (ClientException e) {
                // 打印错误码,客户端报错
                System.out.println("ErrCode:" + e.getErrCode());
                System.out.println("ErrMsg:" + e.getErrMsg());
                System.out.println("RequestId:" + e.getRequestId());
            }
            return false;
        }

}
