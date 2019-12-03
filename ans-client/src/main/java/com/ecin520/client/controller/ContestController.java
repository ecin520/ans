package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Contest;
import com.ecin520.api.service.answer.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 10:03
 */
@RestController
@RequestMapping("/client/contest")
public class ContestController {

    private ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @RequestMapping("/insertContest")
    public JSONObject insertContest(@RequestBody Contest contest) {
        return contestService.insertContest(contest);
    }

    @RequestMapping("/updateContest")
    public JSONObject updateContest(@RequestBody Contest contest) {
        return contestService.updateContest(contest);
    }

    @RequestMapping("/listContestsByUserAid")
    public List<Contest> listContestsByUserAid(@RequestParam("uid") Integer uid) {
        return contestService.listContestsByUserAid(uid);
    }

    @RequestMapping("/listContestsByUserBid")
    public List<Contest> listContestsByUserBid(@RequestParam("uid") Integer uid) {
        return contestService.listContestsByUserBid(uid);
    }

    @RequestMapping("/listAllContests")
    public List<Contest> listAllContests() {
        return contestService.listAllContests();
    }

}
