package com.ecin520.api.service.answer;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.Contest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:44
 */
@Component
@FeignClient(value = "ANSWER-PROVIDER")
@RequestMapping("/contest")
public interface ContestService {

    @RequestMapping("/insertContest")
    JSONObject insertContest(@RequestBody Contest contest);

    @RequestMapping("/updateContest")
    JSONObject updateContest(@RequestBody Contest contest);

    @RequestMapping("/listContestsByUserAid")
    List<Contest> listContestsByUserAid(@RequestParam("uid") Integer uid);

    @RequestMapping("/listContestsByUserBid")
    List<Contest> listContestsByUserBid(@RequestParam("uid") Integer uid);

    @RequestMapping("/listAllContests")
    List<Contest> listAllContests();
}
