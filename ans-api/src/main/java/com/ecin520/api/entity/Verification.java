package com.ecin520.api.entity;

import java.io.Serializable;

/**
 * @author NICE
 * 验证表
 */
public class Verification implements Serializable {
    private Integer id;
    private String sendId;
    private String receiveId;
    private String verTime;
    private String verStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getVerTime() {
        return verTime;
    }

    public void setVerTime(String verTime) {
        this.verTime = verTime;
    }

    public String getVerStatus() {
        return verStatus;
    }

    public void setVerStatus(String verStatus) {
        this.verStatus = verStatus;
    }

    @Override
    public String toString() {
        return "Verification{" +
                "id=" + id +
                ", sendId='" + sendId + '\'' +
                ", receiveId='" + receiveId + '\'' +
                ", verTime='" + verTime + '\'' +
                ", verStatus='" + verStatus + '\'' +
                '}';
    }
}
