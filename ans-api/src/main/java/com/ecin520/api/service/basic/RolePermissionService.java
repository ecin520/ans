package com.ecin520.api.service.basic;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:18
 */
@Component
@FeignClient(value = "BASIC-PROVIDER")
@RequestMapping("/rolePermission")
public interface RolePermissionService {

    @RequestMapping("/insertRolePermission")
    JSONObject insertRolePermission(@RequestParam("rid") Integer rid, @RequestParam("pid") Integer pid);

    /**
     * 删除角色权限
     * @param id 角色权限id
     * */
    @RequestMapping("/deleteRolePermission")
    JSONObject deleteRolePermission(@RequestParam("id") Integer id);

    /**
     * 通过用户id获取其所有权限
     * @param id 用户ud
     * */
    @RequestMapping("/listPermissionsByUserId")
    List<Permission> listPermissionsByUserId(@RequestParam("id") Integer id);

    /**
     * 通过角色id获取该角色所有权限
     * @param rid 角色id
     * */
    @RequestMapping("/listPermissionsByRoleId")
    List<Permission> listPermissionsByRoleId(@RequestParam("rid") Integer rid);
}
