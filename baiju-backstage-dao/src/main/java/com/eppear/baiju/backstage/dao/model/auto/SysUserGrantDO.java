package com.eppear.baiju.backstage.dao.model.auto;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_user_grant")
public class SysUserGrantDO {
    /**
     * 权限ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Integer roleId;

    /**
     * 代理标志
     */
    @Column(name = "PROXY_FLAG")
    private String proxyFlag;

    /**
     * 代理人ID
     */
    @Column(name = "PROXY_ID")
    private Integer proxyId;

    /**
     * 备用标志
     */
    @Column(name = "FLAG")
    private String flag;

    /**
     * 授权者ID
     */
    @Column(name = "OPER_ID")
    private Integer operId;

    /**
     * 授权时间
     */
    @Column(name = "OPER_TIME")
    private Date operTime;

    /**
     * 获取权限ID
     *
     * @return ID - 权限ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置权限ID
     *
     * @param id 权限ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return USER_ID - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取角色ID
     *
     * @return ROLE_ID - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取代理标志
     *
     * @return PROXY_FLAG - 代理标志
     */
    public String getProxyFlag() {
        return proxyFlag;
    }

    /**
     * 设置代理标志
     *
     * @param proxyFlag 代理标志
     */
    public void setProxyFlag(String proxyFlag) {
        this.proxyFlag = proxyFlag;
    }

    /**
     * 获取代理人ID
     *
     * @return PROXY_ID - 代理人ID
     */
    public Integer getProxyId() {
        return proxyId;
    }

    /**
     * 设置代理人ID
     *
     * @param proxyId 代理人ID
     */
    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
    }

    /**
     * 获取备用标志
     *
     * @return FLAG - 备用标志
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置备用标志
     *
     * @param flag 备用标志
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取授权者ID
     *
     * @return OPER_ID - 授权者ID
     */
    public Integer getOperId() {
        return operId;
    }

    /**
     * 设置授权者ID
     *
     * @param operId 授权者ID
     */
    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    /**
     * 获取授权时间
     *
     * @return OPER_TIME - 授权时间
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * 设置授权时间
     *
     * @param operTime 授权时间
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }
}