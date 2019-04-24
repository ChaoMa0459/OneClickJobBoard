package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long resumeId;
	
	// basic information
	@Column(name = "resume_name")
	private String resumeName;
	@Column
	private String first;
	@Column
	private String last;
	@Column
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column
	private String skills;
	@Column
	private String website;
	@Column
	private boolean authorized;
	@Column
	private boolean needSponsorship;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = true)
	private User user;
	
	// address
	@Column
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipcode;
	
	// education
	@Column
	private String degree;
	@Column
	private String university;
	@Column
	private String major;
	@Column
	private float gpa;
	
	// work experience
	@Column
	private String title;
	@Column
	private String company;
	@Column(name = "work_city")
	private String workCity;
	@Column(name = "work_description")
	private String workDescription;
	@Column(name = "work_length")
	private String workLength;
	
	// self identify
	@Column
	private String gender;
	@Column
	private String ifVeteran;
	@Column
	private String hispanicOrLatino;
	@Column
	private String race;
	@Column
	private String ifDisabled;

	public long getResumeId() {
		return resumeId;
	}

	public void setResumeId(long resumeId) {
		this.resumeId = resumeId;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public String getWorkLength() {
		return workLength;
	}

	public void setWorkLength(String workLength) {
		this.workLength = workLength;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIfVeteran() {
		return ifVeteran;
	}

	public void setIfVeteran(String ifVeteran) {
		this.ifVeteran = ifVeteran;
	}

	public String getHispanicOrLatino() {
		return hispanicOrLatino;
	}

	public void setHispanicOrLatino(String hispanicOrLatino) {
		this.hispanicOrLatino = hispanicOrLatino;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getIfDisabled() {
		return ifDisabled;
	}

	public void setIfDisabled(String ifDisabled) {
		this.ifDisabled = ifDisabled;
	}

}
