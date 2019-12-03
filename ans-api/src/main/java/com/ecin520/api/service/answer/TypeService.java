package com.ecin520.api.service.answer;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:38
 */
@Component
@FeignClient(value = "ANSWER-PROVIDER")
@RequestMapping("/type")
public interface TypeService {

    @RequestMapping("/insertType")
    public JSONObject insertType(@RequestBody Type type);

    /**
     * 通过唯一的type_name来更新type
     * */
    @RequestMapping("/updateType")
    public JSONObject updateType(@RequestBody Type type);

    @RequestMapping("/listAllType")
    List<Type> listAllType();

    /**
     * 通过 typeName 获取 type
     * */
    @RequestMapping("/getTypeByTypeName")
    Type getTypeByTypeName(@RequestParam("typeName") String typeName);
}
