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
	
	public List<Resume> getByUserIdAndName(long user_id, String resumename) {
		List<Resume> resumes = new ArrayList<Resume>();
		try {
			begin();
			Query q = getSession().createQuery("from Resume where user_id= :user_id and resume_name= :resumename");
			q.setLong("user_id", user_id);
			q.setString("resumename", resumename);
            resumes = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return resumes;
	}

}
