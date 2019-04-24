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
	@Column(name = "resume_id")
	private long resumeId;
	@Column(name = "job_id")
	private long jobId;
	@Column
	private String status;

	public long getJobApplyId() {
		return jobApplyId;
	}

	public void setJobApplyId(long jobApplyId) {
		this.jobApplyId = jobApplyId;
	}

	public long getResumeId() {
		return resumeId;
	}

	public void setResumeId(long resumeId) {
		this.resumeId = resumeId;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
