package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.GridMember;
import com.neusoft.nepm.common.po.Supervisor;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.feign.MQFeignService;
import com.neusoft.nepm.service.SupervisorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Api(tags = "SupervisorController", description = "决策者模块")
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @Autowired
    private MQFeignService mqFeignService;

    /**
     * 根据主键查询公众监督员，用于注册时手机号码是否存在验证
     * @param telId
     * @return CommonResult<Supervisor>
     */
    @ApiOperation("根据主键查询公众监督员，用于注册时手机号码是否存在验证")
    @GetMapping("/{telId}")
    public CommonResult<Supervisor> getSupervisorById(@ApiParam("公众监督员登录id") @PathVariable("telId") String telId){
        return CommonResult.success(supervisorService.getById(telId));
    }

    /**
     * 保存公众监督员信息，用于注册
     * @param supervisor
     * @return CommonResult<String>
     */
    @ApiOperation("保存公众监督员信息，用于注册")
    @PostMapping("/save")
    public CommonResult<String> saveSupervisor(@ApiParam("待注册公众监督员信息") @RequestBody Supervisor supervisor){
        String msg = supervisorService.supervisorRegister(supervisor);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("注册成功");
        }else{
            return CommonResult.failed("用户名已注册");
        }
    }

    /**
     * 根据公众监督员手机号码和密码查询，用于登录
     * @param telId
     * @param password
     * @return CommonResult<String>
     */
    @ApiOperation("根据公众监督员手机号码和密码查询，用于登录")
    @GetMapping("/{telId}/{password}")
    public CommonResult<String> getSupervisorByIdByPass(@PathVariable("telId") String telId, @PathVariable("password") String password){
        // 创建一个新的Supervisor对象，用于登录操作
        Supervisor supervisor = new Supervisor();

        // 设置登录信息（电话ID和密码）
        supervisor.setTelId(telId);
        supervisor.setPassword(password);

        // 调用supervisorService.supervisorLogin方法进行登录操作，并获取返回的消息
        String msg = supervisorService.supervisorLogin(supervisor);

        // 判断登录操作是否成功
        if(("FAILED").equals(msg)){
            // 登录失败，返回错误信息
            return CommonResult.failed("用户名或密码有误");
        } else {
            // 登录成功，返回成功信息和生成的令牌
            return CommonResult.successWithString(msg);
        }

    }

    /**
     * 手机号验证码登录
     * @param phone
     * @return CommonResult<Boolean>
     */
    @ApiOperation("手机号验证码登录")
    @PostMapping("/sms/{phone}")
    public CommonResult<Boolean> sendVerifyCode(@ApiParam("登陆手机号") @PathVariable("phone") String phone){
        return mqFeignService.sendVerifyCode(phone);
    }

    /**
     * 手机号验证码校验
     * @param phone
     * @param code
     * @return CommonResult<String>
     */
    @ApiOperation("手机号验证码校验")
    @GetMapping("/sms/{phone}/{code}")
    public CommonResult<String> checkSms(@ApiParam("登陆手机号") @PathVariable("phone") String phone,
                                         @ApiParam("待校验验证码") @PathVariable("code") String code){
        CommonResult<Boolean> res = mqFeignService.checkSms(phone, code);

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("userId", phone);
        String token = JwtUtil.generateToken(map);

        return CommonResult.successWithString(token);
    }

    /**
     * 修改个人信息
     * @param supervisor
     * @return CommonResult<Boolean>
     */
    @ApiOperation("修改个人信息")
    @PostMapping("/modifyInfo")
    public CommonResult<Boolean> modifyInfo(@RequestBody Supervisor supervisor){
        // 创建一个新的Supervisor对象用于更新操作
        Supervisor updateSupervisor = new Supervisor();

        // 设置更新信息（电话ID、生日、性别、真实姓名）
        updateSupervisor.setTelId(supervisor.getTelId());
        updateSupervisor.setBirthday(supervisor.getBirthday());
        updateSupervisor.setSex(supervisor.getSex());
        updateSupervisor.setRealName(supervisor.getRealName());

        // 创建查询条件，用于匹配需要更新的记录
        QueryWrapper<Supervisor> qw = new QueryWrapper<>();
        qw.eq("tel_id", supervisor.getTelId());

        // 调用supervisorService.update方法执行更新操作，并将结果包装在CommonResult.success中返回
        return CommonResult.success(supervisorService.update(updateSupervisor, qw));
   }


}
