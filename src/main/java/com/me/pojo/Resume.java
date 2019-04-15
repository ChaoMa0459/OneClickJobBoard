package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resumeId;
	
	@Column
	private String first;
	@Column
	private String last;
	@Column
	private String email;
	@Column
	private String nuid;
	@Column
	private String gpa;
	@Column
	private String major;
	@Column
	private String entrance;
	@Column
	private String graduation;
	@Column
	private String aboutme;
	@Column
	private String skills;
	@Column
	private String coop;
	@Column
	private String prevta;
	@Column
	private String courses;
	@Column
	private String whichclass;
	@Transient
	private MultipartFile photo;
	@Transient
	private MultipartFile resume;
}
