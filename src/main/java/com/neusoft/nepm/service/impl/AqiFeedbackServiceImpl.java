package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.dto.AfPageRequestDto;
import com.neusoft.nepm.po.AqiFeedback;
import com.neusoft.nepm.mapper.AqiFeedbackMapper;
import com.neusoft.nepm.service.AqiFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<AqiFeedback> AqiFeedbackByTelId(Integer telId) {
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackMapper.selectList(new QueryWrapper<AqiFeedback>().eq("tel_id", telId));

        return aqiFeedbackList;
    }

    @Override
    public CommonPage<AqiFeedback> listAqiFeedback(AfPageRequestDto afPageRequestDto) {
        QueryWrapper<AqiFeedback> aqiFeedbackQueryWrapper = new QueryWrapper<>();
        if(afPageRequestDto.getProvinceId() != 0){
            aqiFeedbackQueryWrapper.eq("province_id", afPageRequestDto.getProvinceId());
        }
        if(afPageRequestDto.getCityId() != 0){
            aqiFeedbackQueryWrapper.eq("city_id", afPageRequestDto.getCityId());
        }
        if(afPageRequestDto.getEstimatedId() != 0){
            aqiFeedbackQueryWrapper.eq("estimated_id", afPageRequestDto.getEstimatedId());
        }
        if(afPageRequestDto.getState() != 0){
            aqiFeedbackQueryWrapper.eq("state", afPageRequestDto.getState());
        }

        Page<AqiFeedback> aqiFeedbackPage = new Page<>(afPageRequestDto.getPage(), afPageRequestDto.getSize());
        Page<AqiFeedback> res = aqiFeedbackMapper.selectPage(aqiFeedbackPage, aqiFeedbackQueryWrapper);

        return CommonPage.restPage(res);
    }


}
