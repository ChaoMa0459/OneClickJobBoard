package com.me.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.pojo.Job;

public class JobDao extends DAO {
	
	public Job create(Job job) {
		try {
			begin();
			getSession().save(job);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return job;
	}
	
	public List<Job> getByUserId(long user_id) {
		List<Job> jobs = new ArrayList<Job>();
		try {
			begin();
			Query q = getSession().createQuery("from Resume where user_id= :user_id");
			q.setLong("user_id", user_id);
			jobs = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return jobs;
	}
	
	public List<Job> getByTitle(String title) {
		List<Job> jobs = new ArrayList<Job>();
		try {
			begin();
			Query q = getSession().createQuery("from Resume where title= :title");
			q.setString("title", title);
			jobs = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return jobs;
	}
	
	public Job getByUserIdAndName(long user_id, String job_name) {
		Job job = null;
		try {
			begin();
			Query q = getSession().createQuery("from Job where user_id= :user_id and job_name= :job_name");
			q.setLong("user_id", user_id);
			q.setString("job_name", job_name);
			job = q.uniqueResult() == null ? null : (Job)q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return job;
	}

}
