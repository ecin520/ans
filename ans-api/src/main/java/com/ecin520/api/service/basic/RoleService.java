package com.ecin520.api.service.basic;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:20
 */
@Component
@FeignClient(value = "BASIC-PROVIDER")
@RequestMapping("/role")
public interface RoleService {

    /**
     * 插入角色
     * @param roleName 角色名称
     * @param roleDescribe 角色描述
     * */
    @RequestMapping("/insertRole")
    JSONObject insertRole(@RequestParam("role_name") String roleName, @RequestParam("role_describe") String roleDescribe);

    /**
     * 获取所有角色
     * @return List<Role>
     * */
    @RequestMapping("/listAllRoles")
    List<Role> listAllRoles();

    /**
     * 修改角色
     * @param role 传入的角色
     * */
    @RequestMapping("/updateRole")
    JSONObject updateRole(@RequestBody Role role);

    /**
     * 通过角色id获取角色
     * @param id 角色id
     * @return Role
     * */
    @RequestMapping("/getRoleById")
    Role getRoleById(@RequestParam("id") Integer id);

    /**
     * 通过角色id删除角色
     * @param id 角色id
     * @return JSONObject
     * */
    @RequestMapping("/deleteRoleById")
    JSONObject deleteRoleById(@RequestParam("id") Integer id);
}
