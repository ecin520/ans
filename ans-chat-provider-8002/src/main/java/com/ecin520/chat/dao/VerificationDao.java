package com.ecin520.chat.dao;

import com.ecin520.api.entity.Verification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 18:00
 */
@Mapper
public interface VerificationDao {

	/**
	 * 添加验证
	 * @param verification 验证信息
	 * @return Boolean
	 * */
	Boolean insertVerification(Verification verification);

	/**
	 * 更新验证
	 * 列出未被认证的验证信息
	 * 若状态为 1 则验证通过，同时双方更新好友信息，调用 /friend/insertFriend 接口
	 * 若状态为 2 则验证不通过
	 * 若状态为 3 则表示这是一条未处理的验证信息，需要用socket等到另一方用户上线后处理
	 * @param verification 验证信息
	 * @return Boolean
	 * */
	Boolean updateVerificationsStatus(Verification verification);

	/**
	 * 用户登录后需要请求的接口，查询其是否有人添加为好友
	 * @param id 用户的id
	 * @return List<User>
	 */
	List<Verification> listUserUnverified(Integer id);


}
