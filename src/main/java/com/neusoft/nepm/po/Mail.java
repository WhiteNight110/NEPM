package com.neusoft.nepm.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 邮件
 */
@Data
@ToString
public class Mail implements Serializable {

    private String mailId;
    private String content;

    public Mail() {
    }

    public Mail(String mailId, String content) {
        this.mailId = mailId;
        this.content = content;
    }
}
