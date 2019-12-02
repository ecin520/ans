package com.ecin520.answer.service.impl;

import com.ecin520.answer.service.ContestService;
import com.ecin520.api.entity.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:58
 */
@Service
public class ContestServiceImpl implements ContestService {

    private ContestService contestService;

    @Autowired
    public ContestServiceImpl(ContestService contestService) {
        this.contestService = contestService;
    }

    public Boolean insertContest(Contest contest) {
        return contestService.insertContest(contest);
    }

    public Boolean updateContest(Contest contest) {
        return contestService.updateContest(contest);
    }

    public List<Contest> listContestByUserAid(Integer uid) {
        return contestService.listContestByUserAid(uid);
    }

    public List<Contest> listContestByUserBid(Integer uid) {
        return contestService.listContestByUserBid(uid);
    }

    public List<Contest> listAllContest() {
        return contestService.listAllContest();
    }
}
