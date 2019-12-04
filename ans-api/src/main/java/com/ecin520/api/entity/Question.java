package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
@Accessors(chain = true)
public class Question implements Serializable {
    private Integer id;
    private String create_time;
    private String type_name;
    private Integer question_owner;
    private String question_describe;
    private String question_explain;
    private String item_a;
    private String item_b;
    private String item_c;
    private String item_d;
    private String item_ans;
    private Integer question_status;

}
