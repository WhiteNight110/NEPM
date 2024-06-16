package com.neusoft.nepm.service;

import com.neusoft.nepm.po.Aqi;
import com.baomidou.mybatisplus.extension.service.IService;

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
    List<Aqi> AqiByAll();
}
