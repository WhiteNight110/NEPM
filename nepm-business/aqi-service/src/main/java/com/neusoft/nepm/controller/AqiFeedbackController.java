package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.dto.AfPageRequestDto;
import com.neusoft.nepm.common.dto.AfPageResponseDto;
import com.neusoft.nepm.common.dto.AfResponseDto;
import com.neusoft.nepm.common.po.AqiFeedback;
import com.neusoft.nepm.service.AqiFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "AqiFeedbackController", description = "AqiFeedback模块")
@RequestMapping("/aqiFeedback")
public class AqiFeedbackController {

    @Autowired
    private AqiFeedbackService aqiFeedbackService;

    /**
     * 新增Aqi反馈信息
     * @param aqiFeedback
     * @return CommonResult<Integer>
     */
    @PostMapping("/save")
    public CommonResult<Integer> saveAqiFeedback(@ApiParam(name = "待提交Aqi反馈信息") @RequestBody AqiFeedback aqiFeedback) {
        int res = aqiFeedbackService.AqiFeedbackInsert(aqiFeedback);
        return CommonResult.success(res);
    }

    /**
     * 根据telId查询GridMember指定检测任务
     * @param telId
     * @return CommonResult<List<AqiFeedback>>
     */
    @GetMapping("/{telId}")
    public CommonResult<List<AqiFeedback>> listAqiFeedbackByTelId(@ApiParam(name = "GridMember的指定检测任务信息") @PathVariable("telId") String telId) {
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackService.AqiFeedbackByTelId(telId);
        return CommonResult.success(aqiFeedbackList);
    }

    /**
     * 分页查询AqiFeedback信息
     * @param afPageRequestDto
     * @return CommonResult<CommonPage<AfPageResponseDto>>
     */
    @PostMapping("/listAqiFeedbackPage")
    public CommonResult<CommonPage<AfPageResponseDto>> listAqiFeedbackPage(@ApiParam(name = "Aqi反馈信息分页查询参数") @RequestBody(required = false) AfPageRequestDto afPageRequestDto) {
        return CommonResult.success(aqiFeedbackService.listAqiFeedback(afPageRequestDto));
    }

    /**
     * 根据afId查询Aqi反馈信息
     * @param afId
     * @return CommonResult<AfResponseDto>
     */
    @GetMapping("/list/{afId}")
    public CommonResult<AfResponseDto> getAqiFeedbackById(@ApiParam(name = "待查询afId") @PathVariable("afId") Integer afId) {
        return CommonResult.success(aqiFeedbackService.aqiFeedbackDetail(afId));
    }

    /**
     * 根据主键更新AQI反馈信息（更新指派信息）
     * @param aqiFeedback
     * @return CommonResult<Boolean>
     */
    @ApiOperation("根据主键更新AQI反馈信息（更新指派信息）")
    @PutMapping("/save")
    public CommonResult<Boolean> updateAqiFeedbackAssign(@ApiParam(name = "待更新Aqi反馈信息") @RequestBody AqiFeedback aqiFeedback) {
        return CommonResult.success(aqiFeedbackService.updateById(aqiFeedback));
    }

    /**
     * 根据网格员编号查询指派给网格员的AQI反馈信息
     * @param gmId
     * @return CommonResult<List<AqiFeedback>>
     */
    @ApiOperation("根据网格员编号查询指派给网格员的AQI反馈信息")
    @GetMapping("/gm/{gmId}")
    public CommonResult<List<AqiFeedback>> listAqiFeedbackByGmId(@ApiParam(name = "待查询网格员信息gmId") @PathVariable("gmId") Integer gmId) {
        // 创建一个QueryWrapper对象，用于构建更新条件
        QueryWrapper<AqiFeedback> qw = new QueryWrapper<>();
        qw.eq("gm_id", gmId);
        qw.eq("state", 1);
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackService.list(qw);
        return CommonResult.success(aqiFeedbackList);
    }

    /**
     * 将Aqi反馈信息分配给指定Grid Member
     * @param afId
     * @param gmId
     * @return CommonResult<Boolean>
     */
    @ApiOperation("将Aqi反馈信息分配给指定Grid Member")
    @PostMapping("/{afId}/{gmId}")
    public CommonResult<Boolean> assignAqiFeedback(@ApiParam(name = "Aqi反馈信息主键afId") @PathVariable("afId") Integer afId,
                                                   @ApiParam(name = "Grid Member主键gmId") @PathVariable("gmId") Integer gmId) {
        // 创建一个UpdateWrapper对象，用于构建更新条件
        UpdateWrapper<AqiFeedback> uw = new UpdateWrapper<>();
        uw.eq("af_id", afId);
        uw.set("gm_id", gmId);
        uw.set("state", 1);
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        uw.set("assign_date",dateFormatter.format(date));
        uw.set("assign_time",timeFormatter.format(date));

        // 使用aqiFeedbackService执行更新操作，并返回更新结果
        Boolean result = aqiFeedbackService.update(uw);

        return CommonResult.success(result);
    }

    /**
     * Aqi反馈信息确认
     * @param afId
     * @return CommonResult<Boolean>
     */
    @ApiOperation("Aqi反馈信息确认")
    @PutMapping("/confirmAqiFeedback/{afId}")
    public CommonResult<Boolean> confirmAqiFeedback(@PathVariable Integer afId){
        // 创建一个UpdateWrapper对象，用于构建更新条件
        UpdateWrapper<AqiFeedback> uw = new UpdateWrapper<>();
        uw.eq("af_id", afId);
        uw.set("state", 2);

        // 使用aqiFeedbackService执行更新操作，并返回更新结果
        Boolean result = aqiFeedbackService.update(uw);

        return CommonResult.success(result);
    }

    /**
     * 未确认Aqi反馈信息
     * @return CommonResult<List<AqiFeedback>>
     */
    @ApiOperation("未确认Aqi反馈信息")
    @GetMapping("/unconfirmAqiFeedback")
    public CommonResult<List<AqiFeedback>> unconfirmAqiFeedback(){
        // 创建一个QueryWrapper对象，用于构建更新条件
        QueryWrapper<AqiFeedback> qw = new QueryWrapper<>();
        qw.in("state", 0, 1); // 修改此行，查询 state 为 0 或 1

        // 使用aqiFeedbackService执行更新操作，并返回更新结果
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackService.list(qw);

        return CommonResult.success(aqiFeedbackList);
    }


}
