package com.zhu.bootsecurity.dao;

import com.zhu.bootsecurity.bean.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zpm
 * @version 1.0
 */
public interface UserMapper extends Mapper<SysUser> {

    /**
     * 通过用户名查找用户对象
     *
     * @param name name
     * @return sysUser
     */
    @Select("SELECT id,username,password,status FROM sys_user WHERE username=#{name}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "roles",javaType = List.class,many = @Many(select = "com.zhu.bootsecurity.dao.RoleMapper.findRoleById"))
    })
    SysUser findUserByName(String name);
}
