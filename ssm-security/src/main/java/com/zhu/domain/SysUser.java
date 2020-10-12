package com.zhu.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZPM
 */
@Data
public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private List<SysRole> roles = new ArrayList<>();
}
