package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.Contest;
import com.ecin520.api.service.answer.ContestService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequiresRoles("normal user")
    @CrossOrigin
    public JSONObject insertContest(@RequestBody Contest contest) {
        return contestService.insertContest(contest);
    }

    @RequestMapping("/updateContest")
    @RequiresRoles("normal user")
    @CrossOrigin
    public JSONObject updateContest(@RequestBody Contest contest) {
        return contestService.updateContest(contest);
    }

    @RequestMapping("/listContestsByUserAid")
    @RequiresRoles("normal user")
    @CrossOrigin
    public List<Contest> listContestsByUserAid(@RequestParam("uid") Integer uid) {
        return contestService.listContestsByUserAid(uid);
    }

    @RequestMapping("/listContestsByUserBid")
    @RequiresRoles("normal user")
    @CrossOrigin
    public List<Contest> listContestsByUserBid(@RequestParam("uid") Integer uid) {
        return contestService.listContestsByUserBid(uid);
    }

    @RequestMapping("/listAllContests")
    @RequiresRoles("normal user")
    @CrossOrigin
    public List<Contest> listAllContests() {
        return contestService.listAllContests();
    }

    @RequestMapping("/getMaxId")
    @RequiresRoles("normal user")
    @CrossOrigin
    public Integer getMaxId() {
        return contestService.getMaxId();
    }

}
