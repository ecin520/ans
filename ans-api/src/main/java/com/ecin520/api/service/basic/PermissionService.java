package com.ecin520.api.service.basic;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:22
 */
@Component
@FeignClient(value = "BASIC-PROVIDER")
@RequestMapping("/permission")
public interface PermissionService {

    /**
     * 插入权限
     * url: /permission/insertPermission
     * @param permission 权限信息，包含permission_name,permission_describe
     * @return JSONObject
     * */
    @RequestMapping("/insertPermission")
    JSONObject insertPermission(@RequestBody Permission permission);

    /**
     * 获取所有权限
     * @return List<Permission>
     * */
    @RequestMapping("/listAllPermissions")
    List<Permission> listAllPermissions();

    /**
     * 更新权限信息
     * @param permission 权限信息
     * @return JSONObject
     * */
    @RequestMapping("/updatePermission")
    JSONObject updatePermission(@RequestBody Permission permission);

    /**
     * 通过权限id获取权限信息
     * @param id 权限id
     * @return Permission
     * */
    @RequestMapping("/getPermissionById")
    Permission getPermissionById(@RequestParam("id")Integer id);

    /**
     * 通过权限id删除权限
     * @param id 权限id
     * @return JSONObject
     * */
    @RequestMapping("/deletePermissionById")
    JSONObject deletePermissionById(@RequestParam("id")Integer id);
}
