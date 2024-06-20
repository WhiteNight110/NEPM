package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.dto.AfPageRequestDto;
import com.neusoft.nepm.dto.AqiFeedbackResponseDto;
import com.neusoft.nepm.mapper.GridProvinceMapper;
import com.neusoft.nepm.po.*;
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

    @Autowired
    private GridProvinceMapper gridProvinceMapper;

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

//    @Override
//    public CommonPage<AqiFeedback> listAqiFeedback(AfPageRequestDto afPageRequestDto) {
//        QueryWrapper<AqiFeedback> aqiFeedbackQueryWrapper = new QueryWrapper<>();
//        QueryWrapper<GridProvince> gridProvinceQueryWrapper = new QueryWrapper<>();
////        if(afPageRequestDto.getProvinceId() != 0){
////            aqiFeedbackQueryWrapper.eq("province_id", afPageRequestDto.getProvinceId());
////        }
////        if(afPageRequestDto.getCityId() != 0){
////            aqiFeedbackQueryWrapper.eq("city_id", afPageRequestDto.getCityId());
////        }
//        if(afPageRequestDto.getEstimatedGrade() != 0){
//            aqiFeedbackQueryWrapper.eq("estimated_grade", afPageRequestDto.getEstimatedGrade());
//        }
//
//        aqiFeedbackQueryWrapper.eq("state", afPageRequestDto.getState());
//
//
//        Page<AqiFeedback> aqiFeedbackPage = new Page<>(afPageRequestDto.getPage(), afPageRequestDto.getSize());
//        Page<AqiFeedback> res = aqiFeedbackMapper.selectPage(aqiFeedbackPage, aqiFeedbackQueryWrapper);
//
//        return CommonPage.restPage(res);
//    }

    @Override
    public CommonPage<AqiFeedbackResponseDto> listAqiFeedback(AfPageRequestDto afPageRequestDto) {

        MPJLambdaWrapper<AqiFeedback> mpjLambdaWrapper = new MPJLambdaWrapper<AqiFeedback>()
                .select(AqiFeedback::getAfId, AqiFeedback::getAfDate, AqiFeedback::getAfTime, AqiFeedback::getState, AqiFeedback::getState, AqiFeedback::getEstimatedGrade)
                .select(GridProvince::getProvinceName)
                .select(GridCity::getCityName)
                .selectAs(Supervisor::getRealName, AqiFeedbackResponseDto::getName)
                .leftJoin(GridProvince.class, GridProvince::getProvinceId,  AqiFeedback::getProvinceId)
                .leftJoin(GridProvince.class, GridProvince::getProvinceId, AqiFeedback::getProvinceId)
                .leftJoin(GridCity.class, GridCity::getCityId, AqiFeedback::getCityId)
                .leftJoin(Supervisor.class, Supervisor::getTelId, AqiFeedback::getTelId);

        if(afPageRequestDto.getProvinceName() != "" && afPageRequestDto.getProvinceName() != null){
            mpjLambdaWrapper.eq(GridProvince::getProvinceName, afPageRequestDto.getProvinceName());
        }
        if(afPageRequestDto.getCityName() != "" && afPageRequestDto.getCityName() != null){
            mpjLambdaWrapper.eq(GridCity::getCityName, afPageRequestDto.getCityName());
        }
        if(afPageRequestDto.getEstimatedGrade() != 0){
            mpjLambdaWrapper.eq(AqiFeedback::getEstimatedGrade, afPageRequestDto.getEstimatedGrade());
        }
        if(afPageRequestDto.getEstimatedGrade() != -1){
            mpjLambdaWrapper.eq("state", afPageRequestDto.getState());
        }

        Page<AqiFeedbackResponseDto> page = aqiFeedbackMapper.selectJoinPage(new Page<>(afPageRequestDto.getPage(), afPageRequestDto.getSize()), AqiFeedbackResponseDto.class, mpjLambdaWrapper);

        return CommonPage.restPage(page);

    }


}
