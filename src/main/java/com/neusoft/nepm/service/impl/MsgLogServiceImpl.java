package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.nepm.mapper.GridProvinceMapper;
import com.neusoft.nepm.mapper.MsgServiceMapper;
import com.neusoft.nepm.po.GridProvince;
import com.neusoft.nepm.po.MsgLog;
import com.neusoft.nepm.service.MsgLogService;
import org.springframework.stereotype.Service;

@Service
public class MsgLogServiceImpl extends ServiceImpl<MsgServiceMapper, MsgLog> implements MsgLogService {
}
