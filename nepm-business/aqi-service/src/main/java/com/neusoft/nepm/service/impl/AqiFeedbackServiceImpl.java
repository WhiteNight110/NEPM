package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.dto.AfPageRequestDto;
import com.neusoft.nepm.common.dto.AfPageResponseDto;
import com.neusoft.nepm.common.dto.AfResponseDto;
import com.neusoft.nepm.common.po.*;
import com.neusoft.nepm.mapper.AqiFeedbackMapper;
import com.neusoft.nepm.service.AqiFeedbackService;
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
    public Integer AqiFeedbackInsert(AqiFeedback aqiFeedback) {
        Integer res = aqiFeedbackMapper.insert(aqiFeedback);
        return res;
    }

    @Override
    public List<AqiFeedback> AqiFeedbackByTelId(String telId) {
        List<AqiFeedback> aqiFeedbackList = aqiFeedbackMapper.selectList(new QueryWrapper<AqiFeedback>().eq("tel_id", telId));

        return aqiFeedbackList;
    }

    @Override
    public CommonPage<AfPageResponseDto> listAqiFeedback(AfPageRequestDto afPageRequestDto) {
        // 创建一个MPJLambdaWrapper对象，用于构建查询条件
        MPJLambdaWrapper<AqiFeedback> mpjLambdaWrapper = new MPJLambdaWrapper<AqiFeedback>()
                .selectAll(AqiFeedback.class) // 选择所有AqiFeedback类的字段
                .selectAssociation(Supervisor.class, AfPageRequestDto::getSupervisor) // 选择关联的Supervisor类的字段
                .leftJoin(Supervisor.class, Supervisor::getTelId, AqiFeedback::getTelId); // 左连接Supervisor类，根据TelId进行连接

        // 根据ProvinceId筛选
        if (afPageRequestDto.getProvinceId() != null) {
            mpjLambdaWrapper.eq(AqiFeedback::getProvinceId, afPageRequestDto.getProvinceId());
        }

        // 根据State筛选，添加state=0或1的条件
        if (afPageRequestDto.getState() != null) {
            mpjLambdaWrapper.eq(AqiFeedback::getState, afPageRequestDto.getState());
        } else {
            mpjLambdaWrapper.in(AqiFeedback::getState, 0, 1);
        }

        // 根据CityId筛选
        if (afPageRequestDto.getCityId() != null) {
            mpjLambdaWrapper.eq(AqiFeedback::getCityId, afPageRequestDto.getCityId());
        }

        // 根据EstimatedGrade筛选
        if (afPageRequestDto.getEstimatedGrade() != null) {
            mpjLambdaWrapper.eq(AqiFeedback::getEstimatedGrade, afPageRequestDto.getEstimatedGrade());
        }

        // 根据State筛选
        if (afPageRequestDto.getState() != null) {
            mpjLambdaWrapper.eq(AqiFeedback::getState, afPageRequestDto.getState());
        }

        // 根据AfDate筛选
        if(afPageRequestDto.getAfDate() != null) {
            mpjLambdaWrapper.eq(AqiFeedback::getAfDate, afPageRequestDto.getAfDate());
        }

        // 执行分页查询，获取结果
        Page<AfPageResponseDto> page = aqiFeedbackMapper.selectJoinPage(
                new Page<>(afPageRequestDto.getPage(), afPageRequestDto.getSize()), // 分页参数
                AfPageResponseDto.class, // 返回结果的DTO类
                mpjLambdaWrapper // 查询条件
        );

        // 将查询结果封装到CommonPage对象中并返回
        return CommonPage.restPage(page);
    }


    @Override
    public AfResponseDto aqiFeedbackDetail(Integer afId) {
        // 创建一个MPJLambdaWrapper对象，用于构建查询条件
        MPJLambdaWrapper<AqiFeedback> mpjLambdaWrapper = new MPJLambdaWrapper<AqiFeedback>()
                .selectAll(AqiFeedback.class) // 选择所有AqiFeedback类的字段
                .selectAssociation(Supervisor.class, AfResponseDto::getSupervisor) // 选择关联的Supervisor类的字段
                .selectAssociation(Aqi.class, AfResponseDto::getAqi) // 选择关联的Aqi类的字段
                .selectAssociation(GridProvince.class, AfResponseDto::getGridProvince) // 选择关联的GridProvince类的字段
                .selectAssociation(GridCity.class, AfResponseDto::getGridCity) // 选择关联的GridCity类的字段
                .leftJoin(Supervisor.class, Supervisor::getTelId, AqiFeedback::getTelId) // 左连接Supervisor类，根据TelId进行连接
                .leftJoin(Aqi.class, Aqi::getAqiId, AqiFeedback::getEstimatedGrade) // 左连接Aqi类，根据AqiId进行连接
                .leftJoin(GridProvince.class, GridProvince::getProvinceId, AqiFeedback::getProvinceId) // 左连接GridProvince类，根据ProvinceId进行连接
                .leftJoin(GridCity.class, GridCity::getCityId, AqiFeedback::getCityId) // 左连接GridCity类，根据CityId进行连接
                .eq("af_Id", afId); // 根据afId筛选

        // 执行查询，获取结果
        List<AfResponseDto> res = aqiFeedbackMapper.selectJoinList(AfResponseDto.class, mpjLambdaWrapper);

        // 判断查询结果是否为空，如果不为空则返回第一个结果，否则返回null
        if (res.get(0) != null) {
            return res.get(0);
        } else {
            return null;
        }
    }

}
