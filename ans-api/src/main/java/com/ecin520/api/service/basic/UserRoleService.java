package com.ecin520.api.service.basic;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:13
 */
@Component
@FeignClient(value = "BASIC-PROVIDER")
@RequestMapping("/userRole")
public interface UserRoleService {

    /**
     * 授予用户角色
     * @param uid 用户的id
     * @param rid 角色id
     * @return JSONObject
     * */
    @RequestMapping("/insertUserRole")
    JSONObject insertUserRole(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid);

    /**
     * 删除角色
     * @param uid 用户的id
     * @param rid 角色id
     * @return JSONObject
     * */
    @RequestMapping("/deleteUserRole")
    JSONObject deleteUserRole(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid);

    /**
     * 通过用户id获取其所有角色信息
     * @param id 用户id
     * @return List<Role>
     * */
    @RequestMapping("/listRolesByUserId")
    List<Role> listRolesByUserId(@RequestParam("id") Integer id);
}
