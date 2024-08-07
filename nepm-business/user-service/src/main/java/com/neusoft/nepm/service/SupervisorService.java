package com.neusoft.nepm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.nepm.common.po.Supervisor;

/**
 * <p>
 * 公众监督员表 服务类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface SupervisorService extends IService<Supervisor> {

    /**
     * 根据公众监督员手机号码和密码查询，用于登录。
     * @param supervisor
     * @return success failed
     */
    String supervisorLogin(Supervisor supervisor);

    String supervisorRegister(Supervisor supervisor);
}
