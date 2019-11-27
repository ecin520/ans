package com.ecin520.api.entity;

import java.io.Serializable;

/**
 * @author NICE
 */
public class Question implements Serializable {
    private Integer id;
    private String createTime;
    private String quesType;
    private String quesUser;
    private String quesDescribe;
    private String quesExplain;
    private String aItem;
    private String bItem;
    private String cItem;
    private String dItem;
    private String ansItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getQuesType() {
        return quesType;
    }

    public void setQuesType(String quesType) {
        this.quesType = quesType;
    }

    public String getQuesUser() {
        return quesUser;
    }

    public void setQuesUser(String quesUser) {
        this.quesUser = quesUser;
    }

    public String getQuesDescribe() {
        return quesDescribe;
    }

    public void setQuesDescribe(String quesDescribe) {
        this.quesDescribe = quesDescribe;
    }

    public String getQuesExplain() {
        return quesExplain;
    }

    public void setQuesExplain(String quesExplain) {
        this.quesExplain = quesExplain;
    }

    public String getaItem() {
        return aItem;
    }

    public void setaItem(String aItem) {
        this.aItem = aItem;
    }

    public String getbItem() {
        return bItem;
    }

    public void setbItem(String bItem) {
        this.bItem = bItem;
    }

    public String getcItem() {
        return cItem;
    }

    public void setcItem(String cItem) {
        this.cItem = cItem;
    }

    public String getdItem() {
        return dItem;
    }

    public void setdItem(String dItem) {
        this.dItem = dItem;
    }

    public String getAnsItem() {
        return ansItem;
    }

    public void setAnsItem(String ansItem) {
        this.ansItem = ansItem;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", createTime='" + createTime + '\'' +
                ", quesType='" + quesType + '\'' +
                ", quesUser='" + quesUser + '\'' +
                ", quesDescribe='" + quesDescribe + '\'' +
                ", quesExplain='" + quesExplain + '\'' +
                ", aItem='" + aItem + '\'' +
                ", bItem='" + bItem + '\'' +
                ", cItem='" + cItem + '\'' +
                ", dItem='" + dItem + '\'' +
                ", ansItem='" + ansItem + '\'' +
                '}';
    }
}
