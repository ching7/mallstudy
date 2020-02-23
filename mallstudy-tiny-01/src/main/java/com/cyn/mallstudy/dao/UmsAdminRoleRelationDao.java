package com.cyn.mallstudy.dao;


import com.cyn.mallstudy.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * @Author chenyn
 */
@Component
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     *
     * @param adminId
     * @return
     */
    @Select("select * from ums_permission where pid = #{adminId}")
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
