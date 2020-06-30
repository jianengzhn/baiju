package com.eppear.baiju.backstage.dao.model.auto;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_role_grant")
public class SysRoleGrantDO {
    /**
     * 权限ID
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
     * 菜单ID
     */
    @Column(name = "MENU_ID")
    private Integer menuId;

    /**
     * M-菜单授权，B-按钮授权
     */
    @Column(name = "GRANT_TYPE")
    private String grantType;

    /**
     * 1查，2增，4改，8删，16审，AND关系
     */
    @Column(name = "GRANT_FLAG")
    private Integer grantFlag;

    /**
     * 备用，暂时用不到 
     */
    @Column(name = "BUTTON_ID")
    private Integer buttonId;

    /**
     * 存这个按钮在页面上的组件ID，在一个页面下应该保持唯一。
     */
    @Column(name = "BTN_CODE")
    private String btnCode;

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
     * 获取菜单ID
     *
     * @return MENU_ID - 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取M-菜单授权，B-按钮授权
     *
     * @return GRANT_TYPE - M-菜单授权，B-按钮授权
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * 设置M-菜单授权，B-按钮授权
     *
     * @param grantType M-菜单授权，B-按钮授权
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    /**
     * 获取1查，2增，4改，8删，16审，AND关系
     *
     * @return GRANT_FLAG - 1查，2增，4改，8删，16审，AND关系
     */
    public Integer getGrantFlag() {
        return grantFlag;
    }

    /**
     * 设置1查，2增，4改，8删，16审，AND关系
     *
     * @param grantFlag 1查，2增，4改，8删，16审，AND关系
     */
    public void setGrantFlag(Integer grantFlag) {
        this.grantFlag = grantFlag;
    }

    /**
     * 获取备用，暂时用不到 
     *
     * @return BUTTON_ID - 备用，暂时用不到 
     */
    public Integer getButtonId() {
        return buttonId;
    }

    /**
     * 设置备用，暂时用不到 
     *
     * @param buttonId 备用，暂时用不到 
     */
    public void setButtonId(Integer buttonId) {
        this.buttonId = buttonId;
    }

    /**
     * 获取存这个按钮在页面上的组件ID，在一个页面下应该保持唯一。
     *
     * @return BTN_CODE - 存这个按钮在页面上的组件ID，在一个页面下应该保持唯一。
     */
    public String getBtnCode() {
        return btnCode;
    }

    /**
     * 设置存这个按钮在页面上的组件ID，在一个页面下应该保持唯一。
     *
     * @param btnCode 存这个按钮在页面上的组件ID，在一个页面下应该保持唯一。
     */
    public void setBtnCode(String btnCode) {
        this.btnCode = btnCode;
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