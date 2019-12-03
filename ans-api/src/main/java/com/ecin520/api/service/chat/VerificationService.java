package com.ecin520.api.service.chat;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Verification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:32
 */
@Component
@FeignClient(value = "CHAT-PROVIDER")
@RequestMapping("/verification")
public interface VerificationService {

    /**
     * 当用户点击添加好友后，将 send_id 和 receive_id 发送到后台，后台自动设定认证状态为 3（未验证）,
     * 每当用户进入app，都会发送请求服务端是否有人要添加其为好友，若存在一个 receive_id 为自己且 ver_status 为 3 的字段，就渲染到客户端
     * SELECT `username` FROM `user` WHERE `id` IN ( SELECT `send_id` FROM `verification` WHERE `receive_id` = #{id} AND `ver_status` = 3 );
     * 检查自己是否有人添加
     * */
    @RequestMapping("/insertVerification")
    JSONObject insertVerification(@RequestBody Verification verification);

    /**
     * 当用户点击同意添加好友后，就将双方互相添加为好友
     * 前端数据要求 1 同意添加好友 2 不同意添加好友 3 未处理的验证
     * */
    @RequestMapping("/updateVerificationsStatus")
    JSONObject updateVerificationsStatus(@RequestBody Verification verification);


    /**
     * 用户登录后需要请求的接口，查询其是否有人添加为好友
     * 通过 receive_id 为当前用户来返回 Verification 数据
     * @param id 用户的id
     */
    @RequestMapping("/listUserUnverified")
    List<Verification> listUserUnverified(@RequestParam("id") Integer id);
}
