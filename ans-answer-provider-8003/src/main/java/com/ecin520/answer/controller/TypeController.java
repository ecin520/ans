package com.ecin520.answer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.answer.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ecin520
 * @date: 2019/12/2 10:02
 */
@RestController
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

}
