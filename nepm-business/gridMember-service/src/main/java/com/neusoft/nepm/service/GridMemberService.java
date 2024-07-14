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

    String gridMemberLogin(GridMember gridMember);
    Integer getGridMemberId(GridMember gridMember);
    String gmRegister(GridMember gridMember);


}
