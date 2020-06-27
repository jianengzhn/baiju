package com.eppear.baiju.backstage.dao.model.auto;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_dictionary")
public class Sysdictionary {
    /**
     * 字典ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 信息分类
     */
    @Column(name = "DIC_TYPE_FLAG")
    private String dicTypeFlag;

    /**
     * 代码标识
     */
    @Column(name = "DIC_TYPE_CODE")
    private String dicTypeCode;

    /**
     * 代码名称
     */
    @Column(name = "DIC_TYPE_NAME")
    private String dicTypeName;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 是否可更新,0:可维护（默认值） 1:不可维护
     */
    @Column(name = "CAN_UPDATE")
    private String canUpdate;

    /**
     * 说明
     */
    @Column(name = "REMAIN")
    private String remain;

    /**
     * 获取字典ID
     *
     * @return ID - 字典ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置字典ID
     *
     * @param id 字典ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取信息分类
     *
     * @return DIC_TYPE_FLAG - 信息分类
     */
    public String getDicTypeFlag() {
        return dicTypeFlag;
    }

    /**
     * 设置信息分类
     *
     * @param dicTypeFlag 信息分类
     */
    public void setDicTypeFlag(String dicTypeFlag) {
        this.dicTypeFlag = dicTypeFlag;
    }

    /**
     * 获取代码标识
     *
     * @return DIC_TYPE_CODE - 代码标识
     */
    public String getDicTypeCode() {
        return dicTypeCode;
    }

    /**
     * 设置代码标识
     *
     * @param dicTypeCode 代码标识
     */
    public void setDicTypeCode(String dicTypeCode) {
        this.dicTypeCode = dicTypeCode;
    }

    /**
     * 获取代码名称
     *
     * @return DIC_TYPE_NAME - 代码名称
     */
    public String getDicTypeName() {
        return dicTypeName;
    }

    /**
     * 设置代码名称
     *
     * @param dicTypeName 代码名称
     */
    public void setDicTypeName(String dicTypeName) {
        this.dicTypeName = dicTypeName;
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
     * 获取是否可更新,0:可维护（默认值） 1:不可维护
     *
     * @return CAN_UPDATE - 是否可更新,0:可维护（默认值） 1:不可维护
     */
    public String getCanUpdate() {
        return canUpdate;
    }

    /**
     * 设置是否可更新,0:可维护（默认值） 1:不可维护
     *
     * @param canUpdate 是否可更新,0:可维护（默认值） 1:不可维护
     */
    public void setCanUpdate(String canUpdate) {
        this.canUpdate = canUpdate;
    }

    /**
     * 获取说明
     *
     * @return REMAIN - 说明
     */
    public String getRemain() {
        return remain;
    }

    /**
     * 设置说明
     *
     * @param remain 说明
     */
    public void setRemain(String remain) {
        this.remain = remain;
    }
}