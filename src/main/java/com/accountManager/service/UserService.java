package com.accountManager.service;

import java.util.List;
import com.accountManager.model.User;

public interface UserService {

	public List<User> fetchAll();
	
	public User fetchOne(Long id);
}
