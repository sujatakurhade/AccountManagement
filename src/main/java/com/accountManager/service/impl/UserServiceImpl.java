package com.accountManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountManager.dao.UserDao;
import com.accountManager.model.User;
import com.accountManager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	@Override
	public List<User> fetchAll() {
		List<User> userList = userdao.findAll();
		return userList;
	}

	@Override
	public User fetchOne(Long id) {
		return userdao.findOne(id);
	}

	@Override
	public User createUser(User user) {
		if(user.getId()!=null){
			return null;
		}
		return userdao.save(user);
	}

	@Override
	public User updateUser(User user) {
		User userExists = userdao.findOne(user.getId());
		if(userExists==null){
			return null;
		}
		return userdao.save(user);
	}

	@Override
	public void removeUser(Long id) {
		userdao.delete(id);
	}

}
