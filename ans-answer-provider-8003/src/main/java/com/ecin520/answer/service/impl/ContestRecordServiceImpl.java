package com.ecin520.answer.service.impl;

import com.ecin520.answer.service.ContestRecordService;
import com.ecin520.api.entity.ContestRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:58
 */
@Service
public class ContestRecordServiceImpl implements ContestRecordService {

	private ContestRecordService contestRecordService;

	@Autowired
	public ContestRecordServiceImpl(ContestRecordService contestRecordService) {
		this.contestRecordService = contestRecordService;
	}

	public Boolean insertContestRecord(ContestRecord contestRecord) {
		return contestRecordService.insertContestRecord(contestRecord);
	}

	public List<ContestRecord> listContestRecordByContestId(Integer contestId) {
		return contestRecordService.listContestRecordByContestId(contestId);
	}

	public List<ContestRecord> listContestRecordByQuestionId(Integer questionId) {
		return listContestRecordByQuestionId(questionId);
	}
}
