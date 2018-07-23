package com.accountManager.service.impl;

import com.accountManager.dao.UserAccountDao;
import com.accountManager.model.User_Account;
import com.accountManager.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SU392030 on 7/23/2018.
 */
@Service
public class UserAccountImpl implements UserAccountService {

	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public List<User_Account> findAll() {
		List<User_Account> userAccountLst = userAccountDao.findAll();
		return userAccountLst;
	}

	@Override
	public User_Account fetchBalance(Long user_id) {
		if (!userAccountDao.exists(user_id)) {
			return null;
		}
		return userAccountDao.findByUserId(user_id);
	}

	@Override
	public User_Account transferFund(Long user_id) {
		return null;
	}
}
