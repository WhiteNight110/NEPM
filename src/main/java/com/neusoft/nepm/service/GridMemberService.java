package com.neusoft.nepm.service;

import com.neusoft.nepm.po.GridMember;
import com.baomidou.mybatisplus.extension.service.IService;

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
