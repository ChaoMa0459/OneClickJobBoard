package com.me.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.pojo.JobApplication;

public class JobApplicationDao extends DAO {
	
	public JobApplication create(JobApplication application) {
		try {
			begin();
			getSession().save(application);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return application;
	}
	
	public List<JobApplication> getAll() {
		List<JobApplication> applications = new ArrayList<JobApplication>();
		try {
			begin();
			Query q = getSession().createQuery("from JobApplication");
			applications = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return applications;
	}
	
	public List<JobApplication> getByUserId(long user_id) {
		List<JobApplication> applications = new ArrayList<JobApplication>();
		try {
			begin();
			Query q = getSession().createQuery("from JobApplication where applicant_id= :user_id");
			q.setLong("user_id", user_id);
			applications = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return applications;
	}
	
	public List<JobApplication> getByJobId(long job_id) {
		List<JobApplication> applications = new ArrayList<JobApplication>();
		try {
			begin();
			Query q = getSession().createQuery("from Job where job_id= :job_id");
			q.setLong("job_id", job_id);
			applications = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return applications;
	}

}
