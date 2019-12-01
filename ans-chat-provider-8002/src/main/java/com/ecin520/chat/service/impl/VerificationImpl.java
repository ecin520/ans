package com.ecin520.chat.service.impl;

import com.ecin520.api.entity.Verification;
import com.ecin520.chat.dao.VerificationDao;
import com.ecin520.chat.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ecin520
 * @date: 2019/12/1 20:05
 */
@Service
public class VerificationImpl implements VerificationService {

	private VerificationDao verificationDao;

	@Autowired
	public VerificationImpl(VerificationDao verificationDao) {
		this.verificationDao = verificationDao;
	}

	public Boolean insertVerification(Verification verification) {
		return verificationDao.insertVerification(verification);
	}

	public Boolean updateVerificationsStatus(Verification verification) {
		return verificationDao.updateVerificationsStatus(verification);
	}

	public List<Verification> listUserUnverified(Integer id) {
		return verificationDao.listUserUnverified(id);
	}
}
