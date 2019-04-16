package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resumeId;
	
	// basic information
	@Column
	private String first;
	@Column
	private String last;
	@Column
	private String email;
	@Column
	private String phoneNumber;
	@Column
	private Address address;
	@Column
	private Education education;
	@Column
	private WorkExperience workExp;
	@Column
	private String skills;
	@Column
	private String website;
	@Column
	private boolean authorized;
	@Column
	private boolean needSponsorship;
	@Column
	private boolean workRemote;
	
	// self identify
	@Column
	private String gender;
	@Column
	private boolean ifVeteran;
	@Column
	private boolean hispanicOrLatino;
	@Column
	private String race;
	@Column
	private boolean ifDisabled;

	public long getResumeId() {
		return resumeId;
	}

	public void setResumeId(long resumeId) {
		this.resumeId = resumeId;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public WorkExperience getWorkExp() {
		return workExp;
	}

	public void setWorkExp(WorkExperience workExp) {
		this.workExp = workExp;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public boolean isNeedSponsorship() {
		return needSponsorship;
	}

	public void setNeedSponsorship(boolean needSponsorship) {
		this.needSponsorship = needSponsorship;
	}

	public boolean isWorkRemote() {
		return workRemote;
	}

	public void setWorkRemote(boolean workRemote) {
		this.workRemote = workRemote;
	}

	public boolean isIfVeteran() {
		return ifVeteran;
	}

	public void setIfVeteran(boolean ifVeteran) {
		this.ifVeteran = ifVeteran;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isHispanicOrLatino() {
		return hispanicOrLatino;
	}

	public void setHispanicOrLatino(boolean hispanicOrLatino) {
		this.hispanicOrLatino = hispanicOrLatino;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public boolean isIfDisabled() {
		return ifDisabled;
	}

	public void setIfDisabled(boolean ifDisabled) {
		this.ifDisabled = ifDisabled;
	}
	
}
