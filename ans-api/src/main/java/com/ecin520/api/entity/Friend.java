package com.ecin520.api.entity;

import java.io.Serializable;

/**
 * @author NICE
 * 好友表
 * id：自增id
 * sid：自己的id
 * oid：对方id
 * addTime：添加好友的时间
 */
public class Friend implements Serializable {

    private Integer id;
    private Integer sid;
    private Integer oid;
    private String addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", sid=" + sid +
                ", oid=" + oid +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
