package com.neusoft.nepm.service.impl;

import com.neusoft.nepm.po.AqiFeedback;
import com.neusoft.nepm.mapper.AqiFeedbackMapper;
import com.neusoft.nepm.service.AqiFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 空气质量公众监督反馈表 服务实现类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@Service
public class AqiFeedbackServiceImpl extends ServiceImpl<AqiFeedbackMapper, AqiFeedback> implements AqiFeedbackService {

    @Autowired
    private AqiFeedbackMapper aqiFeedbackMapper;

    @Override
    public int AqiFeedbackInsert(AqiFeedback aqiFeedback) {
        int res = aqiFeedbackMapper.insert(aqiFeedback);
        return res;
    }
}
