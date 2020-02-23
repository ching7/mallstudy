package com.cyn.mallstudy.service;

import com.cyn.mallstudy.mbg.model.UmsAdmin;
import com.cyn.mallstudy.mbg.model.UmsPermission;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.service
 * @Date 2020/2/23 22:20
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 后台管理员Service
 **/
@Service
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);
}