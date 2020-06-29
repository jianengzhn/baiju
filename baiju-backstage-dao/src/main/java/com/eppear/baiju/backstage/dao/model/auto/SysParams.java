package com.eppear.baiju.backstage.dao.model.auto;

import javax.persistence.*;

@Table(name = "t_sys_params")
public class SysParams {
    /**
     * 参数ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 备用，做为参数类别的标识
     */
    @Column(name = "PARM_TYPE")
    private String parmType;

    /**
     * 排序字段，数据越大越靠前，倒序排列
     */
    @Column(name = "PARM_ORDER")
    private Integer parmOrder;

    /**
     * 此标识为逻辑主键，在此表中不可重复
     */
    @Column(name = "PARM_KEY")
    private String parmKey;

    /**
     * 中文名称
     */
    @Column(name = "PARM_NAME")
    private String parmName;

    /**
     * 参数值
     */
    @Column(name = "PARM_VALUE")
    private String parmValue;

    /**
     * 参数说明
     */
    @Column(name = "PARM_DICR")
    private String parmDicr;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 获取参数ID
     *
     * @return ID - 参数ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置参数ID
     *
     * @param id 参数ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取备用，做为参数类别的标识
     *
     * @return PARM_TYPE - 备用，做为参数类别的标识
     */
    public String getParmType() {
        return parmType;
    }

    /**
     * 设置备用，做为参数类别的标识
     *
     * @param parmType 备用，做为参数类别的标识
     */
    public void setParmType(String parmType) {
        this.parmType = parmType;
    }

    /**
     * 获取排序字段，数据越大越靠前，倒序排列
     *
     * @return PARM_ORDER - 排序字段，数据越大越靠前，倒序排列
     */
    public Integer getParmOrder() {
        return parmOrder;
    }

    /**
     * 设置排序字段，数据越大越靠前，倒序排列
     *
     * @param parmOrder 排序字段，数据越大越靠前，倒序排列
     */
    public void setParmOrder(Integer parmOrder) {
        this.parmOrder = parmOrder;
    }

    /**
     * 获取此标识为逻辑主键，在此表中不可重复
     *
     * @return PARM_KEY - 此标识为逻辑主键，在此表中不可重复
     */
    public String getParmKey() {
        return parmKey;
    }

    /**
     * 设置此标识为逻辑主键，在此表中不可重复
     *
     * @param parmKey 此标识为逻辑主键，在此表中不可重复
     */
    public void setParmKey(String parmKey) {
        this.parmKey = parmKey;
    }

    /**
     * 获取中文名称
     *
     * @return PARM_NAME - 中文名称
     */
    public String getParmName() {
        return parmName;
    }

    /**
     * 设置中文名称
     *
     * @param parmName 中文名称
     */
    public void setParmName(String parmName) {
        this.parmName = parmName;
    }

    /**
     * 获取参数值
     *
     * @return PARM_VALUE - 参数值
     */
    public String getParmValue() {
        return parmValue;
    }

    /**
     * 设置参数值
     *
     * @param parmValue 参数值
     */
    public void setParmValue(String parmValue) {
        this.parmValue = parmValue;
    }

    /**
     * 获取参数说明
     *
     * @return PARM_DICR - 参数说明
     */
    public String getParmDicr() {
        return parmDicr;
    }

    /**
     * 设置参数说明
     *
     * @param parmDicr 参数说明
     */
    public void setParmDicr(String parmDicr) {
        this.parmDicr = parmDicr;
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