package com.ecin520.client.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.websocket.Session;

/**
 * @author ecin520
 * @date: 2019/12/11 10:26
 */
@Data
@Accessors(chain = true)
public class Client {
    private String userId;
    private Session session;
}
