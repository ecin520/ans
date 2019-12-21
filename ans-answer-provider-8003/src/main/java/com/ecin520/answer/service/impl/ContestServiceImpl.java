package com.ecin520.answer.service.impl;

import com.ecin520.answer.dao.ContestDao;
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

    @Autowired
    private ContestDao contestDao;

    @Override
    public Boolean insertContest(Contest contest) {
        return contestDao.insertContest(contest);
    }

    @Override
    public Boolean updateContest(Contest contest) {
        return contestDao.updateContest(contest);
    }

    @Override
    public List<Contest> listContestsByUserAid(Integer uid) {
        return contestDao.listContestsByUserAid(uid);
    }

    @Override
    public List<Contest> listContestsByUserBid(Integer uid) {
        return contestDao.listContestsByUserBid(uid);
    }

    @Override
    public List<Contest> listAllContests() {
        return contestDao.listAllContests();
    }

    @Override
    public Integer getMaxId() {
        return contestDao.getMaxId();
    }

}
