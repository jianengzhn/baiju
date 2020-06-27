package com.eppear.baiju.backstage.dao.model.auto;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_department")
public class Sysdepartment {
    /**
     * 企业ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 即营业执照上的统一社会信用代码
     */
    @Column(name = "ENT_CODE")
    private String entCode;

    /**
     * 企业的唯一标识，由系统生成，规则为：
     */
    @Column(name = "ENT_KEY")
    private String entKey;

    /**
     * 企业名称
     */
    @Column(name = "ENT_NAME")
    private String entName;

    /**
     * 联系人
     */
    @Column(name = "CONTACT")
    private String contact;

    /**
     * 联系电话
     */
    @Column(name = "TEL")
    private String tel;

    /**
     * 联系邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 联系地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 上级企业代码
     */
    @Column(name = "UP_ENT_CODE")
    private Integer upEntCode;

    /**
     * 描述部门的树结构,5位一个级别,如: 000001000010001
     */
    @Column(name = "UNICODE")
    private String unicode;

    /**
     * 备用自字段,用于标识企业的个性化属性
     */
    @Column(name = "ENT_TYPE")
    private String entType;

    /**
     * 备用自字段,用于标识企业的个性化属性
     */
    @Column(name = "ENT_FLAG")
    private String entFlag;

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
     * 企业相关的证明文件电子版
     */
    @Column(name = "ADDS")
    private String adds;

    /**
     * 获取企业ID
     *
     * @return ID - 企业ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置企业ID
     *
     * @param id 企业ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取即营业执照上的统一社会信用代码
     *
     * @return ENT_CODE - 即营业执照上的统一社会信用代码
     */
    public String getEntCode() {
        return entCode;
    }

    /**
     * 设置即营业执照上的统一社会信用代码
     *
     * @param entCode 即营业执照上的统一社会信用代码
     */
    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    /**
     * 获取企业的唯一标识，由系统生成，规则为：
     *
     * @return ENT_KEY - 企业的唯一标识，由系统生成，规则为：
     */
    public String getEntKey() {
        return entKey;
    }

    /**
     * 设置企业的唯一标识，由系统生成，规则为：
     *
     * @param entKey 企业的唯一标识，由系统生成，规则为：
     */
    public void setEntKey(String entKey) {
        this.entKey = entKey;
    }

    /**
     * 获取企业名称
     *
     * @return ENT_NAME - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取联系人
     *
     * @return CONTACT - 联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
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
     * 获取联系邮箱
     *
     * @return EMAIL - 联系邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置联系邮箱
     *
     * @param email 联系邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系地址
     *
     * @return ADDRESS - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取上级企业代码
     *
     * @return UP_ENT_CODE - 上级企业代码
     */
    public Integer getUpEntCode() {
        return upEntCode;
    }

    /**
     * 设置上级企业代码
     *
     * @param upEntCode 上级企业代码
     */
    public void setUpEntCode(Integer upEntCode) {
        this.upEntCode = upEntCode;
    }

    /**
     * 获取描述部门的树结构,5位一个级别,如: 000001000010001
     *
     * @return UNICODE - 描述部门的树结构,5位一个级别,如: 000001000010001
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置描述部门的树结构,5位一个级别,如: 000001000010001
     *
     * @param unicode 描述部门的树结构,5位一个级别,如: 000001000010001
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取备用自字段,用于标识企业的个性化属性
     *
     * @return ENT_TYPE - 备用自字段,用于标识企业的个性化属性
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置备用自字段,用于标识企业的个性化属性
     *
     * @param entType 备用自字段,用于标识企业的个性化属性
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * 获取备用自字段,用于标识企业的个性化属性
     *
     * @return ENT_FLAG - 备用自字段,用于标识企业的个性化属性
     */
    public String getEntFlag() {
        return entFlag;
    }

    /**
     * 设置备用自字段,用于标识企业的个性化属性
     *
     * @param entFlag 备用自字段,用于标识企业的个性化属性
     */
    public void setEntFlag(String entFlag) {
        this.entFlag = entFlag;
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

    /**
     * 获取企业相关的证明文件电子版
     *
     * @return ADDS - 企业相关的证明文件电子版
     */
    public String getAdds() {
        return adds;
    }

    /**
     * 设置企业相关的证明文件电子版
     *
     * @param adds 企业相关的证明文件电子版
     */
    public void setAdds(String adds) {
        this.adds = adds;
    }
}