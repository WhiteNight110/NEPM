package com.neusoft.nepm.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.config.CaptchaProperties;
import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.service.AdminsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "AdminController", description = "管理员端")
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @Autowired
    private CaptchaProperties captchaProp;

    //验证码生效时间限制
    private static final long VALID_MILLIS_TIME = 60 * 1000;


    @ApiOperation("根据管理员编码和密码进行查询，用于登录")
    @PostMapping("/getAdminsByCode")
    @ResponseBody
    public CommonResult<String> getAdminsByCode(@RequestBody Admins admins){

        String msg = adminsService.adminsLogin(admins);
        if(("FAILED").equals(msg)){
            return CommonResult.fail("用户名或密码有误");
        }
        else{
            return CommonResult.success(msg);
        }
    }

    @ApiOperation("管理员注册")
    @PostMapping("/adminsRegister")
    @ResponseBody
    public CommonResult<String> adminRegister(@RequestBody Admins admins){
        String msg = adminsService.adminRegister(admins);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("注册成功");
        }
        else{
            return CommonResult.fail("用户已存在");
        }
    }

    @ApiOperation("获取验证码")
    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) {
        //定义图形验证码的长和宽(配置默认值)
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProp.getWidth(), captchaProp.getHeight());
        //细节问题，不影响程序
        //设置返回类型
        response.setContentType("image/jpeg");
        //静止缓存
        response.setHeader("Progma", "No-cache");
        try {
            //图形验证码写出，可以写出到文件，也可以写出到流
            lineCaptcha.write(response.getOutputStream());
            //同时将验证码内容和当前时间戳存储到Session中
            //此处Session的键可以配置成常量
            session.setAttribute(captchaProp.getSession().getKey(), lineCaptcha.getCode());
            session.setAttribute(captchaProp.getSession().getDate(), new Date());
            //关流
            response.getOutputStream().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation("校验验证码")
    @GetMapping("/checkCaptcha")
    public boolean checkCaptcha(String captcha, HttpSession session) {
        //保证传过来的参数是合法的
        if (StringUtils.hasLength(captcha)) {
            //根据配置的默认session信息获取key和date
            String key = (String) session.getAttribute(captchaProp.getSession().getKey());
            Date date = (Date) session.getAttribute(captchaProp.getSession().getDate());
            //1.验证码正确(不区分大小写)  2.验证码还未失效
            return key.equalsIgnoreCase(captcha)
                    && System.currentTimeMillis() - date.getTime() < VALID_MILLIS_TIME;
        }
        return false;
    }



}
