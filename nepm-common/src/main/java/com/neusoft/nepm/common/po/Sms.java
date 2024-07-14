package com.neusoft.nepm.common.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Sms implements Serializable {
    private String smsId;
    private String content;

    public Sms() {
    }
    public Sms(String smsId, String content) {
        this.smsId = smsId;
        this.content = content;
    }

}
