package com.zhu.bootsecurity.dao;

import com.zhu.bootsecurity.bean.SysRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zpm
 * @version 1.0
 */
public interface RoleMapper extends Mapper<SysRole> {

    /**
     * 通过id查找 role
     * @param uid id
     * @return roles
     */
    @Select("SELECT r.id id,r.role_name roleName,r.role_desc roleDesc from sys_role r,sys_user_role ur WHERE r.id=ur.rid and ur.uid=#{uid}")
    List<SysRole> findRoleById(Integer uid);
}
