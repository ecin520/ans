package com.ecin520.client.config;

import com.ecin520.api.entity.Permission;
import com.ecin520.api.entity.Role;
import com.ecin520.api.entity.RolePermission;
import com.ecin520.api.entity.User;
import com.ecin520.api.service.basic.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ecin520
 * @date: 2019/12/3 17:13
 */
@Slf4j
public class Realm extends AuthorizingRealm {


	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private RolePermissionService rolePermissionService;

	/**
	 * 权限认证，登陆后每个访问权限的限制
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		log.info("执行授权逻辑");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = (String) SecurityUtils.getSubject().getPrincipal();

		// 将该用户角色与权限放入set中，执行授权逻辑
		Set<String> roles = new HashSet<>();
		Set<String> permissions = new HashSet<>();

		User user = userService.getUserByUsername(username);


		// 获取并添加该用户角色
		List<Role> roleList = userRoleService.listRolesByUserId(user.getId());
		for(Role role: roleList){
			roles.add(role.getRole_name());
		}

		// 获取并添加该用户权限
		List<Permission> permissionList = rolePermissionService.listPermissionsByUserId(user.getId());
		for(Permission permission: permissionList){
			permissions.add(permission.getPermission_name());
		}

		authorizationInfo.addRoles(roles);
		authorizationInfo.addStringPermissions(permissions);

		return authorizationInfo;
	}

	/**
	 * 身份认证
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		log.info("执行认证逻辑");

		UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
		User user = userService.getUserByUsername(token.getUsername());

		if (user == null) {
			return null;
		}

		return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getUsername()), getName());
	}
}
