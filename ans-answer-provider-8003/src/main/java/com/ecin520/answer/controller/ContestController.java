package com.ecin520.answer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.answer.service.ContestService;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Contest;
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
@RequestMapping("/contest")
public class ContestController {

    private ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @RequestMapping("/insertContest")
    public JSONObject insertContest(@RequestBody Contest contest) {
        if (contestService.insertContest(contest)) {
            return JsonObject.backStatus(200, "Success!");
        } else {
            return JsonObject.backStatus(500, "Fail!");
        }
    }

    @RequestMapping("/updateContest")
    public JSONObject updateContest(@RequestBody Contest contest) {
        if (contestService.updateContest(contest)) {
            return JsonObject.backStatus(200, "Success!");
        } else {
            return JsonObject.backStatus(500, "Fail!");
        }
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

    @RequestMapping("/getMaxId")
    public Integer getMaxId() {
        return contestService.getMaxId();
    }

}
