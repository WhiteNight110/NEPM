package com.neusoft.nepm.service;

import com.neusoft.nepm.po.Admins;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统管理员表 服务类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface AdminsService extends IService<Admins> {
    /**
     * 根据管理员编码和密码进行查询，用于登录
     * @param admins
     * @return success failed
     */
    String adminsLogin(Admins admins);

    String adminRegister(Admins admins);

    int adminsInsert(Admins admins);
}
