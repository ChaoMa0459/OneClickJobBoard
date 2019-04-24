package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobApplication {
	@Id
	@Column(name = "job_apply_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long jobApplyId;
	@Column(name = "applicant_id")
	private long applicantId;
	@Column(name = "job_id")
	private long jobId;
	
	@Column
	private String state;

	public long getJobApplyId() {
		return jobApplyId;
	}

	public void setJobApplyId(long jobApplyId) {
		this.jobApplyId = jobApplyId;
	}

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
