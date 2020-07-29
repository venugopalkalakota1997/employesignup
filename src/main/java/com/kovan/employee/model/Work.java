package com.kovan.employee.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "work")
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	int id;

	@NotNull
	@Column(name = "company")
	String company;

	@NotNull
	@Column(name = "designation")
	String designation;

	@NotNull
	@Column(name = "companyexp")
	int companyexp;

	@NotNull
	@Column(name = "jobdes")
	String jobdes;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Column(name = "startdate")
	private Date startdate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Column(name = "enddate")
	private Date enddate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "fk_employee_id")
	Employee employee;

	public Work() {
		super();
	}

	public Work(@NotNull int id, @NotNull String company, @NotNull String designation, @NotNull int companyexp,
			@NotNull String jobdes, @NotNull Date startdate, @NotNull Date enddate, Employee employee) {
		super();
		this.id = id;
		this.company = company;
		this.designation = designation;
		this.companyexp = companyexp;
		this.jobdes = jobdes;
		this.startdate = startdate;
		this.enddate = enddate;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getCompanyexp() {
		return companyexp;
	}

	public void setCompanyexp(int companyexp) {
		this.companyexp = companyexp;
	}

	public String getJobdes() {
		return jobdes;
	}

	public void setJobdes(String jobdes) {
		this.jobdes = jobdes;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "Work [id=" + id + ", company=" + company + ", designation=" + designation + ", companyexp=" + companyexp
				+ ", jobdes=" + jobdes + ", startdate=" + startdate + ", enddate=" + enddate + ", employee=" + employee
				+ "]";
	}

}
