package com.eppear.baiju.backstage.dao.model.system;

public class SysAuthorization {
    /**
     * 菜单ID
     */
    private Integer id;

    /**
     * 上级ID
     */
    private Integer upId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单资源
     */
    private String url;

    /**
     * Y-是叶子结点，其它-不是叶子结点
     */
    private String isLeaf;

    /**
     * 到排序，即此列值越大，排序越靠前,同级别之间的排序
     */
    private Integer orderCol;

    /**
     * 删除标志,Y:已删除，N（默认值）或其它:正常未删除
     */
    private String delFlag;

    /**
     * 预留字段1
     */
    private String preCol1;

    /**
     * 预留字段2
     */
    private String preCol2;

    /**
     * 授权值： 1查，2增，4改，8删，16审，AND关系
     */
    private Integer grantFlag;

    /**
     * 获取菜单ID
     *
     * @return ID - 菜单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单ID
     *
     * @param id 菜单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取上级ID
     *
     * @return UP_ID - 上级ID
     */
    public Integer getUpId() {
        return upId;
    }

    /**
     * 设置上级ID
     *
     * @param upId 上级ID
     */
    public void setUpId(Integer upId) {
        this.upId = upId;
    }

    /**
     * 获取菜单名称
     *
     * @return NAME - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单图标
     *
     * @return ICON - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取菜单资源
     *
     * @return URL - 菜单资源
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单资源
     *
     * @param url 菜单资源
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取Y-是叶子结点，其它-不是叶子结点
     *
     * @return IS_LEAF - Y-是叶子结点，其它-不是叶子结点
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置Y-是叶子结点，其它-不是叶子结点
     *
     * @param isLeaf Y-是叶子结点，其它-不是叶子结点
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取到排序，即此列值越大，排序越靠前,同级别之间的排序
     *
     * @return ORDER_COL - 到排序，即此列值越大，排序越靠前,同级别之间的排序
     */
    public Integer getOrderCol() {
        return orderCol;
    }

    /**
     * 设置到排序，即此列值越大，排序越靠前,同级别之间的排序
     *
     * @param orderCol 到排序，即此列值越大，排序越靠前,同级别之间的排序
     */
    public void setOrderCol(Integer orderCol) {
        this.orderCol = orderCol;
    }

    /**
     * 获取删除标志,Y:已删除，N（默认值）或其它:正常未删除
     *
     * @return DEL_FLAG - 删除标志,Y:已删除，N（默认值）或其它:正常未删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标志,Y:已删除，N（默认值）或其它:正常未删除
     *
     * @param delFlag 删除标志,Y:已删除，N（默认值）或其它:正常未删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取预留字段1
     *
     * @return PRE_COL1 - 预留字段1
     */
    public String getPreCol1() {
        return preCol1;
    }

    /**
     * 设置预留字段1
     *
     * @param preCol1 预留字段1
     */
    public void setPreCol1(String preCol1) {
        this.preCol1 = preCol1;
    }

    /**
     * 获取预留字段2
     *
     * @return PRE_COL2 - 预留字段2
     */
    public String getPreCol2() {
        return preCol2;
    }

    /**
     * 设置预留字段2
     *
     * @param preCol2 预留字段2
     */
    public void setPreCol2(String preCol2) {
        this.preCol2 = preCol2;
    }

    public Integer getGrantFlag(){
        return grantFlag;
    }

    public void setGrantFlag(Integer grantFlag){
        this.grantFlag = grantFlag;
    }
}