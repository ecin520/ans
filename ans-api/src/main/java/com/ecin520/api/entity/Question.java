package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
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

}
