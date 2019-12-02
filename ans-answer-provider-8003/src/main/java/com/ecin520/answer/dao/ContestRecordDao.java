package com.ecin520.answer.dao;

import com.ecin520.api.entity.ContestRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:56
 */
@Mapper
public interface ContestRecordDao {

	/**
	 * 插入比赛记录
	 * 若平局则win_id为0，反之则为用户id
	 * @param contestRecord 比赛记录
	 * @return Boolean
	 * */
	Boolean insertContestRecord(ContestRecord contestRecord);

	/**
	 * 通过比赛的id查询比赛记录
	 * @param contestId 比赛的id
	 * @return List<ContestRecord>
	 * */
	List<ContestRecord> listContestRecordByContestId(Integer contestId);

	/**
	 * 通过题目的id获取此题的回答的所有信息
	 * @param questionId 题目id
	 * @return List<ContestRecord>
	 * */
	List<ContestRecord> listContestRecordByQuestionId(Integer questionId);

}
