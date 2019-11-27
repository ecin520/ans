package com.ecin520.api.entity;

import java.io.Serializable;

/**
 * @author NICE
 */
public class User implements Serializable {
    private Integer id;
    private String password;
    private String avatarUrl;
    private String telNumber;
    private String rank;
    private String sign;
    private Integer status;
    private String ansNumber;
    private String correctNumber;
    private String goodAt;
    private String registerTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAnsNumber() {
        return ansNumber;
    }

    public void setAnsNumber(String ansNumber) {
        this.ansNumber = ansNumber;
    }

    public String getCorrectNumber() {
        return correctNumber;
    }

    public void setCorrectNumber(String correctNumber) {
        this.correctNumber = correctNumber;
    }

    public String getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", rank='" + rank + '\'' +
                ", sign='" + sign + '\'' +
                ", status=" + status +
                ", ansNumber='" + ansNumber + '\'' +
                ", correctNumber='" + correctNumber + '\'' +
                ", goodAt='" + goodAt + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
