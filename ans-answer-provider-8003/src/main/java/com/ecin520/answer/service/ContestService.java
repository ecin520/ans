package com.ecin520.answer.service;

import com.ecin520.api.entity.Contest;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:57
 */
public interface ContestService {

    /**
     * 插入一场比赛
     * @param contest contest对象
     * @return Booleaen 是否插入成功
     * */
    Boolean insertContest(Contest contest);

    /**
     * 更新这场比赛的信息
     * @param contest contest对象
     * @return Boolean
     *
     * */
    Boolean updateContest(Contest contest);

    /**
     * 当第一个发起比赛者等待后，另一方对手匹配到后，另一方为user_a，发起者为user_b
     * @param uid user id
     * @return List<Contest>
     * */
    List<Contest> listContestsByUserAid(Integer uid);

    /**
     * 当第一个发起比赛者等待后，另一方对手匹配到后，另一方为user_a，发起者为user_b
     * @param uid user id
     * @return List<Contest>
     * */
    List<Contest> listContestsByUserBid(Integer uid);

    /**
     * 列出所有比赛记录
     * @return List<Contest>
     * */
    List<Contest> listAllContests();

    /**
     * 获取最大Id
     * @return Integer
     * */
    Integer getMaxId();

}
