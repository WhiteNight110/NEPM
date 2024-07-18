package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.GridMember;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.feign.MQFeignService;
import com.neusoft.nepm.service.GridMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Api(tags = "GridMemberController", description = "GridMember模块")
@RequestMapping("/gridMember")
public class GridMemberController {

    @Autowired
    private GridMemberService gridMemberService;

    @Autowired
    private MQFeignService mqFeignService;

    /**
     * 查找指定省份的网格监督员
     * @param cityId
     * @return CommonResult<List<GridMember>>
     */
    @ApiOperation("查找指定省份的网格监督员")
    @GetMapping("/province/{cityId}")
    public CommonResult<List<GridMember>> listGridMemberByProvinceId(@ApiParam("指定省份id") @PathVariable("cityId") Integer cityId){
        // 创建QueryWrapper对象，用于构建查询条件
        QueryWrapper<GridMember> qw = new QueryWrapper<>();

        // 添加查询条件
        qw.eq("city_id", cityId);

        // 使用gridMemberService根据查询条件获取网格成员列表
        List<GridMember> gridMembers = gridMemberService.list(qw);
        // 返回包含网格成员列表的通用结果
        return CommonResult.success(gridMembers);
    }

    /**
     * 查找指定城市的网格监督员
     * @param cityId
     * @return CommonResult<List<GridMember>>
     */
    @ApiOperation("查找指定城市的网格监督员")
    @GetMapping("/city/{cityId}")
    public CommonResult<List<GridMember>> listGridMemberByCityId(@PathVariable("cityId") Integer cityId){
        // 创建QueryWrapper对象，用于构建查询条件
        QueryWrapper<GridMember> qw = new QueryWrapper<>();

        // 添加查询条件
        qw.eq("city_id", cityId);

        // 使用gridMemberService根据查询条件获取网格成员列表
        List<GridMember> gridMembers = gridMemberService.list(qw);
        // 返回包含网格成员列表的通用结果
        return CommonResult.success(gridMembers);
    }

    /**
     * 网格员登陆验证
     * @param gridMember
     * @return CommonResult<Integer>
     */
    @ApiOperation("网格员登陆验证")
    @PostMapping("/login")
    public CommonResult<Integer> getGridMemberByCodeByPass(@ApiParam("登陆用户") @RequestBody GridMember gridMember){
        // 调用gridMemberService的gridMemberLogin方法进行登录验证
        String msg = gridMemberService.gridMemberLogin(gridMember);

        // 判断登录结果
        if (("FAILED").equals(msg)) {
            // 登录失败，返回失败消息
            return CommonResult.failed("用户名或密码有误");
        } else {
            // 登录成功，返回网格成员ID和成功消息
            return CommonResult.success(gridMemberService.getGridMemberId(gridMember), msg);
        }
    }

    /**
     * 网格员注册
     * @param gridMember
     * @return CommonResult<String>
     */
    @ApiOperation("网格员注册")
    @PostMapping("/register")
    public CommonResult<String> gmRegister(@ApiParam("注册账号") @RequestBody GridMember gridMember){

        // 调用gridMemberService的gmRegister方法进行注册
        String msg = gridMemberService.gmRegister(gridMember);

        // 判断注册结果
        if(("FAILED").equals(msg)){
            // 注册失败，返回失败消息
            return CommonResult.failed("用户已存在");
        }
        else{
            // 注册成功，返回成功消息
            return CommonResult.success("注册成功");
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
     * @return CommonResult<Integer>
     */
    @ApiOperation("手机号验证码校验")
    @GetMapping("/sms/{phone}/{code}")
    public CommonResult<Integer> checkSms(@ApiParam("登陆手机号") @PathVariable("phone") String phone,
                                          @ApiParam("待校验验证码") @PathVariable("code") String code){
        CommonResult<Boolean> res = mqFeignService.checkSms(phone, code);

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("userId", phone);
        String token = JwtUtil.generateToken(map);

        if(res.getData()){
            QueryWrapper<GridMember> qw = new QueryWrapper<>();
            qw.eq("tel", phone);
            GridMember gridMember = gridMemberService.getOne(qw);
            return CommonResult.success(gridMemberService.getGridMemberId(gridMember), token);
        }

        return CommonResult.failed("登陆失败");
    }

}
