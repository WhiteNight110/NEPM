package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.po.AqiFeedback;
import com.neusoft.nepm.service.AqiFeedbackService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "AqiFeedbackController", description = "公共监督员AQIFeedback")
@RequestMapping("/aqi")
public class AqiFeedbackController {
    @Autowired
    private AqiFeedbackService aqiFeedbackService;

    @ResponseBody
    @PostMapping("/saveAqiFeedback")
    public CommonResult<Integer> saveAqiFeedback(@RequestBody AqiFeedback aqiFeedback){
        int res = aqiFeedbackService.AqiFeedbackInsert(aqiFeedback);
        return CommonResult.success(res);
    }
}
