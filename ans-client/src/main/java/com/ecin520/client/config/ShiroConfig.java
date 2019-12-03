package com.ecin520.client.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ecin520
 * @date: 2019/12/3 9:49
 */
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean =
				new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		shiroFilterFactoryBean.setLoginUrl("/unauth");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
		Map<String,String> map = new LinkedHashMap<>();
		map.put("/login","anon");
		map.put("/register", "anon");
		// map.put("/perms","perms[vip2]");
		map.put("/*","authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

		return shiroFilterFactoryBean;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager =
				new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(realm());
		defaultWebSecurityManager.setRememberMeManager(cookieRememberMeManager());
		defaultWebSecurityManager.setSessionManager(defaultWebSessionManager());
		defaultWebSecurityManager.setCacheManager(redisCacheManager());
		return defaultWebSecurityManager;
	}

	/**配置redis缓存管理器*/
	@Bean
	public RedisManager redisManager() {
		RedisManager manager = new RedisManager();
		manager.setHost("127.0.0.1");
		manager.setPort(6379);
		manager.setExpire(1800);
		return manager;
	}

	/**配置RedisSessionDao*/
	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO sessionDAO = new RedisSessionDAO();
		sessionDAO.setRedisManager(redisManager());
		return sessionDAO;
	}

	/**Session管理器*/
	@Bean
	public DefaultWebSessionManager defaultWebSessionManager() {
		DefaultWebSessionManager manager = new DefaultWebSessionManager();
		manager.setSessionDAO(redisSessionDAO());
		return manager;
	}

	/**shiro缓存管理*/
	@Bean
	public RedisCacheManager redisCacheManager() {
		RedisCacheManager manager = new RedisCacheManager();
		manager.setRedisManager(redisManager());
		return manager;
	}

	@Bean(name = "realm")
	public Realm realm() {
		Realm realm = new Realm();
		// 用来验证密文，用户的密码转化成密文与数据库进行对比
		realm.setCredentialsMatcher(hashedCredentialsMatcher());
		realm.setCachingEnabled(false);
		return realm;
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}

	/**加密方式*/
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		hashedCredentialsMatcher.setHashIterations(3);
		// 默认是true，true使用Hex编码；false使用Base64编码
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}

	/**
	 * 配置cookie，设置用户cookie失效时间，实现rememberMe功能。
	 * */
	@Bean
	public SimpleCookie simpleCookie(){
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		cookie.setMaxAge(60*60*24);
		return cookie;
	}

	/**管理对象*/
	@Bean
	public CookieRememberMeManager cookieRememberMeManager(){
		CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
		rememberMeManager.setCookie(simpleCookie());
		rememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		return rememberMeManager;
	}
}
