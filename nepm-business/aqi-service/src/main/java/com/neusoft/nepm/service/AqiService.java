package com.neusoft.nepm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.nepm.common.po.Aqi;

import java.util.List;

/**
 * <p>
 * 空气质量指数级别表 服务类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface AqiService extends IService<Aqi> {
    /**
     * 查询所有Aqi信息
     * @return
     */
    List<Aqi> AqiByAll();
}
