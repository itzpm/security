package com.zhu.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author zpm
 * @version 1.0
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
