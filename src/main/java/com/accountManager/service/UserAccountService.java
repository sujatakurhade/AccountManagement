package com.accountManager.service;

import com.accountManager.model.User_Account;

import java.util.List;

/**
 * Created by SU392030 on 7/23/2018.
 */
public interface UserAccountService {

    public List<User_Account> findAll();

    public User_Account fetchBalance(Long user_id);

    public User_Account transferFund(Long user_id);

}
