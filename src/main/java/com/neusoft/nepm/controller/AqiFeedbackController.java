package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.dto.AfPageRequestDto;
import com.neusoft.nepm.po.Aqi;
import com.neusoft.nepm.po.AqiFeedback;
import com.neusoft.nepm.service.AqiFeedbackService;
import com.neusoft.nepm.service.AqiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.CookieManager;
import java.util.List;

@Controller
@Api(tags = "AqiFeedbackController", description = "公共监督员AQIFeedback")
@RequestMapping("/aqiFeedback")
public class AqiFeedbackController {
    @Autowired
    private AqiFeedbackService aqiFeedbackService;

    @ResponseBody
    @PostMapping("/saveAqiFeedback")
    public CommonResult<Integer> saveAqiFeedback(@RequestBody AqiFeedback aqiFeedback){
        int res = aqiFeedbackService.AqiFeedbackInsert(aqiFeedback);
        return CommonResult.success(res);
    }

    @ResponseBody
    @GetMapping("/listAqiFeedbackByTelId")
    public CommonResult<List<AqiFeedback>> listAqiFeedbackByTelId(@RequestParam Integer telId){
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackService.AqiFeedbackByTelId(telId);
        return CommonResult.success(aqiFeedbackList);
    }

    @ResponseBody
    @GetMapping("/listAqiFeedbackPage")
    public CommonResult<CommonPage<AqiFeedback>> listAqiFeedbackPage(@RequestBody AfPageRequestDto afPageRequestDto){
        return CommonResult.success(aqiFeedbackService.listAqiFeedback(afPageRequestDto));

    }

    @ResponseBody
    @GetMapping("/getAqiFeedbackById")
    public AqiFeedback getAqiFeedbackById(@RequestParam int afId){
        return aqiFeedbackService.getById(afId);
    }
}
