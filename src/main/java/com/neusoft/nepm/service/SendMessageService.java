package com.neusoft.nepm.service;

import java.util.Map;

public interface SendMessageService {

    public boolean send(String phone, String templateCode, Map<String,Object> code);
}
