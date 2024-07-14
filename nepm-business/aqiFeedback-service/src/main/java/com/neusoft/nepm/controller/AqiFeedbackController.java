package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.dto.AfPageRequestDto;
import com.neusoft.nepm.common.dto.AfPageResponseDto;
import com.neusoft.nepm.common.dto.AfResponseDto;
import com.neusoft.nepm.common.po.AqiFeedback;
import com.neusoft.nepm.mapper.AqiFeedbackMapper;
import com.neusoft.nepm.service.AqiFeedbackService;
import com.sun.deploy.security.JarSignature;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Api(tags = "AqiFeedbackController", description = "公共监督员AQIFeedback")
@RequestMapping("/aqiFeedback")
public class AqiFeedbackController {
    @Autowired
    private AqiFeedbackService aqiFeedbackService;
    @ResponseBody
    @PostMapping("/saveAqiFeedback")
    public CommonResult<Integer> saveAqiFeedback(@RequestBody AqiFeedback aqiFeedback) {
        int res = aqiFeedbackService.AqiFeedbackInsert(aqiFeedback);
        return CommonResult.success(res);
    }

    @ResponseBody
    @GetMapping("/listAqiFeedbackByTelId")
    public CommonResult<List<AqiFeedback>> listAqiFeedbackByTelId(@RequestParam Integer telId) {
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackService.AqiFeedbackByTelId(telId);
        return CommonResult.success(aqiFeedbackList);
    }

//    @ResponseBody
//    @GetMapping("/listAqiFeedbackPage")
//    public CommonResult<CommonPage<AqiFeedback>> listAqiFeedbackPage(@RequestBody AfPageRequestDto afPageRequestDto){
//        return CommonResult.success(aqiFeedbackService.listAqiFeedback(afPageRequestDto));
//
//    }

    @ResponseBody
    @PostMapping("/listAqiFeedbackPage")
    public CommonResult<CommonPage<AfPageResponseDto>> listAqiFeedbackPage(@RequestBody(required = false) AfPageRequestDto afPageRequestDto) {
        System.out.println("====service=====");
        if (afPageRequestDto != null) System.out.println(afPageRequestDto.toString());


        return CommonResult.success(aqiFeedbackService.listAqiFeedback(afPageRequestDto));
    }

    @ResponseBody
    @GetMapping("/getAqiFeedbackById")
    public CommonResult<AfResponseDto> getAqiFeedbackById(@RequestParam Integer afId) {

        return CommonResult.success(aqiFeedbackService.aqiFeedbackDetail(afId));

    }

    /**
     * 根据主键更新AQI反馈信息（更新指派信息）
     *
     * @param aqiFeedback
     * @return
     */
    @ApiOperation("根据主键更新AQI反馈信息（更新指派信息）")
    @PutMapping("/updateAqiFeedbackAssign")
    @ResponseBody
    public CommonResult<Boolean> updateAqiFeedbackAssign(@RequestBody AqiFeedback aqiFeedback) {

        return CommonResult.success(aqiFeedbackService.updateById(aqiFeedback));
    }

    @ApiOperation("根据网格员编号查询指派给网格员的AQI反馈信息")
    @GetMapping("/listAqiFeedbackByGmId")
    @ResponseBody
    public CommonResult<List<AqiFeedback>> listAqiFeedbackByGmId(Integer gmId) {
        QueryWrapper<AqiFeedback> qw = new QueryWrapper<>();
        qw.eq("gm_id", gmId);
        qw.eq("state", 1);
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackService.list(qw);
        return CommonResult.success(aqiFeedbackList);
    }


    @ApiOperation("分配AQI信息")
    @PostMapping("/assignAqiFeedback")
    @ResponseBody
    public CommonResult<Boolean> assignAqiFeedback(@RequestParam Integer afId, @RequestParam Integer gmId) {
        UpdateWrapper<AqiFeedback> uw = new UpdateWrapper<>();
        uw.eq("af_id", afId);
        uw.set("gm_id", gmId);
        uw.set("state", 1);
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        uw.set("assign_date",dateFormatter.format(date));
        uw.set("assign_time",timeFormatter.format(date));
        boolean result = aqiFeedbackService.update(uw);
        return CommonResult.success(result);
    }

}
