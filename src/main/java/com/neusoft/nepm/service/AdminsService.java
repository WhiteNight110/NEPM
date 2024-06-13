package com.neusoft.nepm.service;

import com.neusoft.nepm.mbg.model.Admins;

public interface AdminsService {
    /**
     * 根据管理员编码和密码进行查询，用于登录
     * @param admins
     * @return Admins对象
     */
    public String getAdminsByCode(Admins admins);
}
