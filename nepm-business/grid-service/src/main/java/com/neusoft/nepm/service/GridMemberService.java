package com.neusoft.nepm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.nepm.common.po.GridMember;

/**
 * <p>
 * 空气质量监测网格员表 服务类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface GridMemberService extends IService<GridMember> {

    /**
     * 网格员登陆验证
     * @param gridMember
     * @return String
     */
    String gridMemberLogin(GridMember gridMember);

    /**
     * 查询网格员id
     * @param gridMember
     * @return Integer
     */
    Integer getGridMemberId(GridMember gridMember);

    /**
     * 网格员注册
     * @param gridMember
     * @return String
     */
    String gmRegister(GridMember gridMember);


}
