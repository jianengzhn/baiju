package com.eppear.baiju.backstage.dao.mapper.auto;

import com.eppear.baiju.backstage.dao.config.MyMapper;
import com.eppear.baiju.backstage.dao.model.auto.SysMenuDO;
import com.eppear.baiju.backstage.dao.model.system.SysAuthorization;

import java.util.List;

public interface SysMenuDao extends MyMapper<SysMenuDO> {
    /**
     * 根据用户ID查询此用户的系统管理员标识
     * @param userId 用户ID
     * @return 0 不是，1 是
     */
    Integer getSaFlag(Integer userId );

    /**
     * 根据用户ID查询此用户被授权的菜单项，及授权值
     * @param userId 用户ID
     * @return 权限项信息
     */
    List<SysAuthorization> getGranMenuInfo(Integer userId );

    /**
     * 根据用户ID查询此用户被授权的菜单项，及授权值,用于系统管理员的情况
     * @param userId 用户ID
     * @return 权限项信息
     */
    List<SysAuthorization> getGranMenuInfoForSA(Integer userId );
}