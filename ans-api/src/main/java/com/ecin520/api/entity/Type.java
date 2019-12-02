package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ecin520
 * @date: 2019/12/2 10:06
 */
@Data
@Accessors(chain = true)
public class Type {
    private Integer id;
    private String type_name;
    private String type_describe;
    private Integer hot;
    private Integer difficulty;
}
