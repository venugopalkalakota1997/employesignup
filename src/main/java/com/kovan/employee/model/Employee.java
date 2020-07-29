package com.kovan.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	int id;

	@NotNull
	@Column(name = "username")
	String userName;

	@NotNull
	@Column(name = "contact")
	long contact;

	@NotNull
	@Column(name = "address")
	String address;

	@NotNull
	@Column(name = "education")
	String education;

	@NotNull
	@Column(name = "skills")
	String skills;

	@NotNull
	@Column(name = "workexp")
	long workexp;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	List<Work> workList;

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", contact=" + contact + ", address=" + address
				+ ", education=" + education + ", skills=" + skills + ", workexp=" + workexp + ", workList=" + workList
				+ "]";
	}

	public Employee(@NotNull int id, @NotNull String userName, @NotNull long contact, @NotNull String address,
			@NotNull String education, @NotNull String skills, @NotNull long workexp, List<Work> workList) {
		super();
		this.id = id;
		this.userName = userName;
		this.contact = contact;
		this.address = address;
		this.education = education;
		this.skills = skills;
		this.workexp = workexp;
		this.workList = workList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public long getWorkexp() {
		return workexp;
	}

	public void setWorkexp(long workexp) {
		this.workexp = workexp;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public List<Work> getWorkList() {
		return workList;
	}

	public void setWorkList(List<Work> workList) {
		this.workList = workList;
	}

}
