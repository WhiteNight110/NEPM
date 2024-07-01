package com.neusoft.nepm.service;

import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.dto.AfPageRequestDto;
import com.neusoft.nepm.dto.AfPageResponseDto;
import com.neusoft.nepm.dto.AfResponseDto;
import com.neusoft.nepm.po.AqiFeedback;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 空气质量公众监督反馈表 服务类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface AqiFeedbackService extends IService<AqiFeedback> {

    /**
     * 添加AQI反馈数据
     * @param aqiFeedback
     * @return
     */
    int AqiFeedbackInsert(AqiFeedback aqiFeedback);

    /**
     * 根据telID查询AQI反馈数据
     * @param telId 公共监督员id
     * @return
     */
    List<AqiFeedback> AqiFeedbackByTelId(Integer telId);

    /**
     * 分页查询 AqiFeedback
     * @param afPageRequestDto
     * @return CommonPage<AqiFeedbackResponseDto>
     */
//    CommonPage<AqiFeedback> listAqiFeedback(AfPageRequestDto afPageRequestDto);

    CommonPage<AfPageResponseDto> listAqiFeedback(AfPageRequestDto afPageRequestDto);

    AfResponseDto aqiFeedbackDetail(Integer afId);
}
