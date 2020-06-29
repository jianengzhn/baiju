package com.eppear.baiju.backstage.service.system;

import com.eppear.baiju.backstage.dao.model.auto.SysUser;
import com.eppear.baiju.backstage.dao.model.system.SysAuthorization;

import java.util.List;

/**
 * 系统授权服务，服务用户名查询与密码支持，用户权限的查询
 * @author zhangjf
 * @date 2020-06-29 20:03:45
 */
public interface SysAuthorizationService {

    /**
     * 根据用户账号查询用户信息，用于登录认证
     * @param userName 用户账号
     * @return 用户对像
     */
    SysUser getUserByName(String userName);

    /**
     * 根据用户ID查询此用户被授权的菜单项，及授权值
     * @param userId
     * @return 权限项信息
     */
    List<SysAuthorization> getGranMenuInfos(Integer userId);
}
