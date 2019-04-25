package com.me.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.pojo.Resume;

public class ResumeDao extends DAO {
	
	public Resume create(Resume resume) {
		try {
			begin();
			getSession().save(resume);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return resume;
	}
	
	public Resume getById(long resume_id) {
		Resume resume = null;
		try {
			begin();
			Query q = getSession().createQuery("from Resume where resumeId= :resume_id");
			q.setLong("resume_id", resume_id);
            resume = q.uniqueResult() == null ? null : (Resume)q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return resume;
	}
	
	public List<Resume> getByUserId(long user_id) {
		List<Resume> resumes = new ArrayList<Resume>();
		try {
			begin();
			Query q = getSession().createQuery("from Resume where user_id= :user_id");
			q.setLong("user_id", user_id);
            resumes = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return resumes;
	}
	
	public List<Resume> getByResumeName(String resumename) {
		List<Resume> resumes = new ArrayList<Resume>();
		try {
			begin();
			Query q = getSession().createQuery("from Resume where resume_name= :resumename");
			q.setString("resumename", resumename);
            resumes = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return resumes;
	}
	
	public Resume getByUserIdAndName(long user_id, String resumename) {
		Resume resume = null;
		try {
			begin();
			Query q = getSession().createQuery("from Resume where user_id= :user_id and resume_name= :resumename");
			q.setLong("user_id", user_id);
			q.setString("resumename", resumename);
            resume = q.uniqueResult() == null ? null : (Resume)q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return resume;
	}

}
