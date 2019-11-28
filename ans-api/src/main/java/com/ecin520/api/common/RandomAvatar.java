package com.ecin520.api.common;

import java.util.Random;

/**
 * @Author: ecin520
 * @Date: 2019/11/28 16:58
 */
public class RandomAvatar {

	private static String[] randomAvatar = new String[]{"http://148.70.50.70/source/1572837893695.jpg", "http://148.70.50.70/source/15" +
			"72837893695.jpg", "http://148.70.50.70/source/1572837893695.jpg", "http://148.70.50.70/source/1572837893695.jpg"};

	public static String getRandomAvatar() {
		return randomAvatar[new Random().nextInt(randomAvatar.length)];
	}

}
