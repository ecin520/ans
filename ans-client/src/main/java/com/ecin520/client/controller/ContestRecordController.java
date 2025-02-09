package com.ecin520.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.entity.ContestRecord;
import com.ecin520.api.service.answer.ContestRecordService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 10:04
 */
@RestController
@RequestMapping("/client/contestRecord")
public class ContestRecordController {

    private ContestRecordService contestRecordService;

    @Autowired
    public ContestRecordController(ContestRecordService contestRecordService) {
        this.contestRecordService = contestRecordService;
    }

    @RequestMapping("/insertContestRecord")
    @RequiresRoles("normal user")
    @CrossOrigin
    public JSONObject insertContestRecord(@RequestBody ContestRecord contestRecord) {
        return contestRecordService.insertContestRecord(contestRecord);
    }

    @RequestMapping("/listContestRecordByContestId")
    @RequiresRoles("normal user")
    @CrossOrigin
    public List<ContestRecord> listContestRecordByContestId(@RequestParam("contestId") Integer contestId) {
        return contestRecordService.listContestRecordByContestId(contestId);
    }

    @RequestMapping("/listContestRecordByQuestionId")
    @RequiresRoles("normal user")
    @CrossOrigin
    public List<ContestRecord> listContestRecordByQuestionId(@RequestParam("questionId") Integer questionId) {
        return contestRecordService.listContestRecordByQuestionId(questionId);
    }
}
