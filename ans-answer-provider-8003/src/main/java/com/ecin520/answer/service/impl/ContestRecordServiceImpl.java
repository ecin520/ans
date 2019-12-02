package com.ecin520.answer.service.impl;

import com.ecin520.answer.dao.ContestRecordDao;
import com.ecin520.answer.service.ContestRecordService;
import com.ecin520.api.entity.ContestRecord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:58
 */
@Service
public class ContestRecordServiceImpl implements ContestRecordService {

	private ContestRecordDao contestRecordDao;

	public ContestRecordServiceImpl(ContestRecordDao contestRecordDao) {
		this.contestRecordDao = contestRecordDao;
	}


	public Boolean insertContestRecord(ContestRecord contestRecord) {
		return contestRecordDao.insertContestRecord(contestRecord);
	}

	public List<ContestRecord> listContestRecordByContestId(Integer contestId) {
		return contestRecordDao.listContestRecordByContestId(contestId);
	}

	public List<ContestRecord> listContestRecordByQuestionId(Integer questionId) {
		return contestRecordDao.listContestRecordByQuestionId(questionId);
	}
}
