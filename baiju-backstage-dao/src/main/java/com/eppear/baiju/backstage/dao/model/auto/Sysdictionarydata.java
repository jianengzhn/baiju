package com.eppear.baiju.backstage.dao.model.auto;

import javax.persistence.*;

@Table(name = "t_sys_dictionary_data")
public class Sysdictionarydata {
    /**
     * 信息ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对应字典ID
     */
    @Column(name = "DIC_TYPE_ID")
    private Integer dicTypeId;

    /**
     * 信息值
     */
    @Column(name = "DIC_VALUE")
    private String dicValue;

    /**
     * 信息名称
     */
    @Column(name = "DIC_NAME")
    private String dicName;

    /**
     * 排序列
     */
    @Column(name = "DIC_ORDER")
    private Integer dicOrder;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 获取信息ID
     *
     * @return ID - 信息ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置信息ID
     *
     * @param id 信息ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取对应字典ID
     *
     * @return DIC_TYPE_ID - 对应字典ID
     */
    public Integer getDicTypeId() {
        return dicTypeId;
    }

    /**
     * 设置对应字典ID
     *
     * @param dicTypeId 对应字典ID
     */
    public void setDicTypeId(Integer dicTypeId) {
        this.dicTypeId = dicTypeId;
    }

    /**
     * 获取信息值
     *
     * @return DIC_VALUE - 信息值
     */
    public String getDicValue() {
        return dicValue;
    }

    /**
     * 设置信息值
     *
     * @param dicValue 信息值
     */
    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    /**
     * 获取信息名称
     *
     * @return DIC_NAME - 信息名称
     */
    public String getDicName() {
        return dicName;
    }

    /**
     * 设置信息名称
     *
     * @param dicName 信息名称
     */
    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    /**
     * 获取排序列
     *
     * @return DIC_ORDER - 排序列
     */
    public Integer getDicOrder() {
        return dicOrder;
    }

    /**
     * 设置排序列
     *
     * @param dicOrder 排序列
     */
    public void setDicOrder(Integer dicOrder) {
        this.dicOrder = dicOrder;
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