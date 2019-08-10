package com.spring.boot.common.domain;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-21 17:03
 **/
public class Col {
    private String field;
    private String title;
    private Boolean sort=true;
    private Boolean excel=true;
    /***
     * checkbox,radio
     */
    private String type;

    private String toolbar;

    public Col() {
    }

    public Col(String field) {
        this.field = field;
        this.title = field;
    }

    public Col(String field, String title) {
        this.field = field;
        this.title = title;
    }

    public static Col bulidHead(){
        Col col=new Col("fux","复选框");
        col.setType(Type.checkbox.name());
        col.setExcel(false);
        return  col;
    }
    public static Col bulidEnd(){
        Col col=new Col("oper","操作");
        col.setToolbar("#funTool");
        col.setExcel(false);
        return  col;
    }
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getSort() {
        return sort;
    }

    public void setSort(Boolean sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToolbar() {
        return toolbar;
    }

    public void setToolbar(String toolbar) {
        this.toolbar = toolbar;
    }

    enum  Type{
        checkbox,
    }

    public Boolean getExcel() {
        return excel;
    }

    public void setExcel(Boolean excel) {
        this.excel = excel;
    }
}
