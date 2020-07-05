package com.eppear.baiju.backstage.dao.mapper.system;

import com.eppear.baiju.backstage.dao.config.MyMapper;
import com.eppear.baiju.backstage.dao.model.system.SysAuthorization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhangjf
 * @date 2020-06-29 21:30:39
 */
@Mapper
public interface SysAuthorizationDao extends MyMapper<SysAuthorization> {

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
