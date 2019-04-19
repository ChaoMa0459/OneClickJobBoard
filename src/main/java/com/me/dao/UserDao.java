package com.me.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

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
	
	public List<User> getUserByUsername(String username) {
		List<User> users = new ArrayList<User>();
		try {
			begin();
			Query q = getSession().createQuery("from User where username= :username");
            q.setString("username", username);
            users = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return users;
	}

}
