package com.accountManager.dao;

import com.accountManager.model.User_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by SU392030 on 7/23/2018.
 */
@Repository
public interface UserAccountDao extends JpaRepository<User_Account, Long> {

	@Query(value = "select * from user_account a where a.user_id=(:user_id)", nativeQuery = true)
	User_Account findByUserId(@Param("user_id") Long user_id);

}
