package com.ecin520.api.service.answer;

import com.alibaba.fastjson.JSONObject;
import com.ecin520.api.common.JsonObject;
import com.ecin520.api.entity.ContestRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/3 9:43
 */
@Component
@FeignClient(value = "ANSWER-PROVIDER")
@RequestMapping("/contestRecord")
public interface ContestRecordService {

    @RequestMapping("/insertContestRecord")
    JSONObject insertContestRecord(@RequestBody ContestRecord contestRecord);

    @RequestMapping("/listContestRecordByContestId")
    List<ContestRecord> listContestRecordByContestId(@RequestParam("contestId") Integer contestId);

    @RequestMapping("/listContestRecordByQuestionId")
    List<ContestRecord> listContestRecordByQuestionId(@RequestParam("questionId") Integer questionId);
}
