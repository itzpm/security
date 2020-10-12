package com.zhu.service;



import com.zhu.domain.SysRole;

import java.util.List;

/**
 * @author ZPM
 */
public interface RoleService {

    public void save(SysRole role);

    public List<SysRole> findAll();

}
