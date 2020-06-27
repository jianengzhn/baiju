package com.eppear.baiju.backstage.dao.model.auto;

import javax.persistence.*;

@Table(name = "t_sys_role_spec_bind")
public class Sysrolespecbind {
    /**
     * 绑定ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Integer roleId;

    /**
     * 特定角色ID
     */
    @Column(name = "SPEC_ID")
    private Integer specId;

    /**
     * 备用
     */
    @Column(name = "EXT1")
    private String ext1;

    /**
     * 获取绑定ID
     *
     * @return ID - 绑定ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置绑定ID
     *
     * @param id 绑定ID
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取特定角色ID
     *
     * @return SPEC_ID - 特定角色ID
     */
    public Integer getSpecId() {
        return specId;
    }

    /**
     * 设置特定角色ID
     *
     * @param specId 特定角色ID
     */
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    /**
     * 获取备用
     *
     * @return EXT1 - 备用
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置备用
     *
     * @param ext1 备用
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }
}