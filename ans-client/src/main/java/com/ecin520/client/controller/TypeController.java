package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Type;
import com.ecin520.api.service.answer.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 10:02
 */
@RestController
@RequestMapping("/client/type")
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping("/insertType")
    public JSONObject insertType(@RequestBody Type type) {
        return typeService.insertType(type);
    }

    /**
     * 通过唯一的type_name来更新type
     * */
    @RequestMapping("/updateType")
    public JSONObject updateType(@RequestBody Type type) {
        return typeService.updateType(type);
    }

    @RequestMapping("/listAllType")
    public List<Type> listAllType() {
        return typeService.listAllType();
    }

    /**
     * 通过 typeName 获取 type
     * */
    @RequestMapping("/getTypeByTypeName")
    public Type getTypeByTypeName(@RequestParam("typeName") String typeName) {
        return typeService.getTypeByTypeName(typeName);
    }
}
