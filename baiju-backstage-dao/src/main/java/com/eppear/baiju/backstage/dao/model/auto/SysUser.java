package com.eppear.baiju.backstage.dao.model.auto;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_user")
public class SysUser {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属企业ID
     */
    @Column(name = "ENT_ID")
    private Integer entId;

    /**
     * 登录账号
     */
    @Column(name = "ACCOUNT")
    private String account;

    /**
     * 用户名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 联系电话
     */
    @Column(name = "TEL")
    private String tel;

    /**
     * 个人邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 状态，1：正常（默认值）；2：删除；3：冻结
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 账号是否可用
     */
    @Column(name = "ENABLED")
    private Integer enabled;

    /**
     * 账号是否过期
     */
    @Column(name = "ACCT_NON_EXP")
    private Integer acctNonExp;

    /**
     * 密码是否过期
     */
    @Column(name = "PWD__NON_EXP")
    private Integer pwdNonExp;

    /**
     * 账号是否锁定
     */
    @Column(name = "ACCT_NON_LOCKED")
    private Integer acctNonLocked;

    /**
     * 系统特定角，色管理员：1，普通用户：2
     */
    @Column(name = "ROLE")
    private Integer role;

    /**
     * 创建人ID
     */
    @Column(name = "CREATOR_ID")
    private Integer creatorId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 最后修改人ID
     */
    @Column(name = "LAST_UP_ID")
    private Integer lastUpId;

    /**
     * 最后修改时间
     */
    @Column(name = "LAST_UPTIME")
    private Date lastUptime;

    /**
     * 获取用户ID
     *
     * @return ID - 用户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取所属企业ID
     *
     * @return ENT_ID - 所属企业ID
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * 设置所属企业ID
     *
     * @param entId 所属企业ID
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * 获取登录账号
     *
     * @return ACCOUNT - 登录账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置登录账号
     *
     * @param account 登录账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取用户名称
     *
     * @return NAME - 用户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名称
     *
     * @param name 用户名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取联系电话
     *
     * @return TEL - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取个人邮箱
     *
     * @return EMAIL - 个人邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置个人邮箱
     *
     * @param email 个人邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取状态，1：正常（默认值）；2：删除；3：冻结
     *
     * @return STATUS - 状态，1：正常（默认值）；2：删除；3：冻结
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态，1：正常（默认值）；2：删除；3：冻结
     *
     * @param status 状态，1：正常（默认值）；2：删除；3：冻结
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取账号是否可用
     *
     * @return ENABLED - 账号是否可用
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * 设置账号是否可用
     *
     * @param enabled 账号是否可用
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取账号是否过期
     *
     * @return ACCT_NON_EXP - 账号是否过期
     */
    public Integer getAcctNonExp() {
        return acctNonExp;
    }

    /**
     * 设置账号是否过期
     *
     * @param acctNonExp 账号是否过期
     */
    public void setAcctNonExp(Integer acctNonExp) {
        this.acctNonExp = acctNonExp;
    }

    /**
     * 获取密码是否过期
     *
     * @return PWD__NON_EXP - 密码是否过期
     */
    public Integer getPwdNonExp() {
        return pwdNonExp;
    }

    /**
     * 设置密码是否过期
     *
     * @param pwdNonExp 密码是否过期
     */
    public void setPwdNonExp(Integer pwdNonExp) {
        this.pwdNonExp = pwdNonExp;
    }

    /**
     * 获取账号是否锁定
     *
     * @return ACCT_NON_LOCKED - 账号是否锁定
     */
    public Integer getAcctNonLocked() {
        return acctNonLocked;
    }

    /**
     * 设置账号是否锁定
     *
     * @param acctNonLocked 账号是否锁定
     */
    public void setAcctNonLocked(Integer acctNonLocked) {
        this.acctNonLocked = acctNonLocked;
    }

    /**
     * 获取系统特定角，色管理员：1，普通用户：2
     *
     * @return ROLE - 系统特定角，色管理员：1，普通用户：2
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置系统特定角，色管理员：1，普通用户：2
     *
     * @param role 系统特定角，色管理员：1，普通用户：2
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 获取创建人ID
     *
     * @return CREATOR_ID - 创建人ID
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人ID
     *
     * @param creatorId 创建人ID
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后修改人ID
     *
     * @return LAST_UP_ID - 最后修改人ID
     */
    public Integer getLastUpId() {
        return lastUpId;
    }

    /**
     * 设置最后修改人ID
     *
     * @param lastUpId 最后修改人ID
     */
    public void setLastUpId(Integer lastUpId) {
        this.lastUpId = lastUpId;
    }

    /**
     * 获取最后修改时间
     *
     * @return LAST_UPTIME - 最后修改时间
     */
    public Date getLastUptime() {
        return lastUptime;
    }

    /**
     * 设置最后修改时间
     *
     * @param lastUptime 最后修改时间
     */
    public void setLastUptime(Date lastUptime) {
        this.lastUptime = lastUptime;
    }
}