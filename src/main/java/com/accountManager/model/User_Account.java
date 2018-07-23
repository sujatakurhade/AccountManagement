package com.accountManager.model;

import javax.persistence.*;

@Entity
@Table(name = "user_account")
public class User_Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne(optional = true, targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User users;

	@Column(name = "balance")
	private String balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
