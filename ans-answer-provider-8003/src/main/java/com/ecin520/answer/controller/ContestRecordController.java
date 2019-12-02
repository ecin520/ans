package com.ecin520.answer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.answer.service.ContestRecordService;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.ContestRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 10:04
 */
@RestController
@RequestMapping("/contestRecord")
public class ContestRecordController {
    private ContestRecordService contestRecordService;

    @Autowired
    public ContestRecordController(ContestRecordService contestRecordService) {
        this.contestRecordService = contestRecordService;
    }

    @RequestMapping("/insertContestRecord")
    public JSONObject insertContestRecord(@RequestBody ContestRecord contestRecord) {
        if (contestRecordService.insertContestRecord(contestRecord)) {
            return JsonObject.backStatus(200, "Success!");
        } else {
            return JsonObject.backStatus(500, "Fail!");
        }
    }

    @RequestMapping("/listContestRecordByContestId")
    public List<ContestRecord> listContestRecordByContestId(@RequestParam("contestId") Integer contestId) {
        return contestRecordService.listContestRecordByContestId(contestId);
    }

    @RequestMapping("/listContestRecordByQuestionId")
    public List<ContestRecord> listContestRecordByQuestionId(@RequestParam("questionId") Integer questionId) {
        return contestRecordService.listContestRecordByQuestionId(questionId);
    }
}
