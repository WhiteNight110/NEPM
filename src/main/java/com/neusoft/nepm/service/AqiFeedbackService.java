package com.neusoft.nepm.service;

import com.neusoft.nepm.po.AqiFeedback;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 空气质量公众监督反馈表 服务类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface AqiFeedbackService extends IService<AqiFeedback> {
    int AqiFeedbackInsert(AqiFeedback aqiFeedback);

}
