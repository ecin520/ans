package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Type;
import com.ecin520.api.service.answer.TypeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequiresRoles("admin")
    @CrossOrigin
    public JSONObject insertType(@RequestBody Type type) {
        return typeService.insertType(type);
    }

    /**
     * 通过唯一的type_name来更新type
     * */
    @RequestMapping("/updateType")
    @RequiresRoles("admin")
    @CrossOrigin
    public JSONObject updateType(@RequestBody Type type) {
        return typeService.updateType(type);
    }

    @RequestMapping("/listAllType")
    @RequiresRoles("normal user")
    @CrossOrigin
    public List<Type> listAllType() {
        return typeService.listAllType();
    }

    /**
     * 通过 typeName 获取 type
     * */
    @RequestMapping("/getTypeByTypeName")
    @RequiresRoles("normal user")
    @CrossOrigin
    public Type getTypeByTypeName(@RequestParam("typeName") String typeName) {
        return typeService.getTypeByTypeName(typeName);
    }
}
