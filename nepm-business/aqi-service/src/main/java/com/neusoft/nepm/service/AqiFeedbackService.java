package com.neusoft.nepm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.dto.AfPageRequestDto;
import com.neusoft.nepm.common.dto.AfPageResponseDto;
import com.neusoft.nepm.common.dto.AfResponseDto;
import com.neusoft.nepm.common.po.AqiFeedback;

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
    Integer AqiFeedbackInsert(AqiFeedback aqiFeedback);

    /**
     * 根据telID查询AQI反馈数据
     * @param telId
     * @return List<AqiFeedback>
     */
    List<AqiFeedback> AqiFeedbackByTelId(String telId);

    /**
     * 分页查询 AqiFeedback
     * @param afPageRequestDto
     * @return CommonPage<AqiFeedbackResponseDto>
     */
    CommonPage<AfPageResponseDto> listAqiFeedback(AfPageRequestDto afPageRequestDto);

    /**
     * 根据afId查询Aqi反馈详细信息
     * @param afId
     * @return AfResponseDto
     */
    AfResponseDto aqiFeedbackDetail(Integer afId);
}
