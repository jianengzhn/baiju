package com.eppear.baiju.backstage.dao.model.auto;

import javax.persistence.*;

@Table(name = "t_sys_role_spec")
public class Sysrolespec {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色标识
     */
    @Column(name = "ROLE_CODE")
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 获取角色ID
     *
     * @return ID - 角色ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色ID
     *
     * @param id 角色ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色标识
     *
     * @return ROLE_CODE - 角色标识
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色标识
     *
     * @param roleCode 角色标识
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色名称
     *
     * @return ROLE_NAME - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取备注
     *
     * @return REMARK - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}