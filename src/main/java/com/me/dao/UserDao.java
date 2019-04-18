package com.me.dao;

import org.hibernate.HibernateException;

import com.me.pojo.User;

public class UserDao extends DAO {
	public User create(User user) {
		try {
			begin();
			getSession().save(user);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return user;
	}
}
