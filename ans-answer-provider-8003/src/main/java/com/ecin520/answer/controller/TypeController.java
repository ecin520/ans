package com.ecin520.answer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.answer.service.TypeService;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Type;
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
@RequestMapping("/type")
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping("/insertType")
    public JSONObject insertType(@RequestBody Type type) {
        if (null != typeService.insertType(type)) {
            return JsonObject.backStatus(200, "插入题目类型成功！");
        } else {
            return JsonObject.backStatus(500, "插入题目类型失败！");
        }
    }

    /**
     * 通过唯一的type_name来更新type
     * */
    @RequestMapping("/updateType")
    public JSONObject updateType(@RequestBody Type type) {
        if (null != typeService.updateType(type)) {
            return JsonObject.backStatus(200, "更新题目类型成功！");
        } else {
            return JsonObject.backStatus(500, "更新题目类型失败！");
        }
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
