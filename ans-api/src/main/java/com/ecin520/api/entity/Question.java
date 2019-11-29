package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
public class Question implements Serializable {
    private Integer id;
    private String create_time;
    private String question_type;
    private String question_owner;
    private String question_describe;
    private String question_explain;
    private String item_a;
    private String item_b;
    private String item_c;
    private String item_d;
    private String item_ans;

}
