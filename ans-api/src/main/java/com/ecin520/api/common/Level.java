package com.ecin520.api.common;

/**
 * @author: ecin520
 * @date: 2019/12/22 9:33
 */
public class Level {

	public static Integer getLevelByExp(Integer exp) {
		return exp/100;
	}

	public static String getRankByExp(Integer exp) {
		int level = exp/100;
		if (level >= 0 && level <=1) {
			return "学前班";
		} else if (level >= 2 && level <= 3) {
			return "小班";
		} else if (level >= 4 && level <= 5) {
			return "大班";
		} else if (level >= 6 && level <= 8) {
			return "一年级";
		} else if (level >= 9 && level <= 11) {
			return "二年级";
		} else if (level >= 12 && level <= 14) {
			return "三年级";
		} else if (level >= 15 && level <= 17) {
			return "四年级";
		} else if (level >= 18 && level <= 20) {
			return "五年级";
		} else if (level >= 21 && level <= 23) {
			return "六年级";
		} else if (level >= 24 && level <= 27) {
			return "初一";
		} else if (level >= 28 && level <= 31) {
			return "初二";
		} else if (level >= 32 && level <= 35) {
			return "初三";
		} else if (level >= 36 && level <= 39) {
			return "高一";
		} else if (level >= 40 && level <= 43) {
			return "高二";
		} else if (level >= 44 && level <= 47) {
			return "高三";
		} else if (level >= 48 && level <= 52) {
			return "大一";
		} else if (level >= 53 && level <= 57) {
			return "大二";
		} else if (level >= 58 && level <= 62) {
			return "大三";
		} else if (level >= 63 && level <= 67) {
			return "大四";
		} else if (level >= 68 && level <= 73) {
			return "硕士";
		} else if (level >= 74 && level <= 80) {
			return "博士";
		} else if (level >= 81 && level <= 88) {
			return "博士后";
		} else if (level >= 89 && level <= 97) {
			return "副教授";
		} else if (level >= 98) {
			return "教授";
		}
		return "null";
	}
}
