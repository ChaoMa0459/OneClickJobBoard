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
	
	public User getUserByUsername(String username) {
		User user = null;
		try {
			begin();
			Query q = getSession().createQuery("from User where username= :username");
            q.setString("username", username);
            user = q.uniqueResult() == null? null: (User)q.uniqueResult();   
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return user;
	}

}
