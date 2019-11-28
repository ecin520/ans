package com.ecin520.api.common;

import java.util.Random;

/**
 * @Author: ecin520
 * @Date: 2019/11/28 16:37
 */
public class RandomName {

	private static String[] firstName = new String[]{"张", "李", "尤", "奚", "魏", "陶", "潘", "岑", "倪", "许", "邵", "姚", "樊", "嵇", "於"
			, "詹", "戈", "阚", "游", "郭", "仲孙", "淳于", "尉迟" };
	private static String[] lastName = new String[]{"梦琪", "语蓉", "妙彤", "曼易", "若南", "怀蝶", "痴梦", "幼蓉", "寒香", "雁枫", "疏影", "清绮", "安" +
			"然", "然可", "羽沁", "玲鸢", "添馨", "曦洁", "婉尥", "绍云", "貌睿", "缨凝", "子琴"};

	public static StringBuilder getRandomName() {

		StringBuilder nickName = new StringBuilder();
		nickName.append(firstName[new Random().nextInt(firstName.length)]);
		nickName.append(lastName[new Random().nextInt(lastName.length)]);

		return nickName;
	}
}
