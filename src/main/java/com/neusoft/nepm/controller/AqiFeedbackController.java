package com.neusoft.nepm.controller;

import com.neusoft.nepm.service.AqiFeedbackService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "AqiFeedbackController", description = "AqiFeedback管理")
@RequestMapping("/aqiFeedback")
public class AqiFeedbackController {
    @Autowired
    AqiFeedbackService aqiFeedbackService;


}
