package com.synergisticit.onlinebanking.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Customer {
	@Id
	private int customerid;
	
	private int passportid;
	private String customerfname;
	private String customerlname;
	private String gender;
	private Date dob;

	private long mobile;
	//@NotEmpty(message="please enter email id")
	//@Email
	private String email;
	
	@OneToMany
	@JoinColumn(name="loanid")
	private List<Loan> loans=new ArrayList<Loan>();
	
	@OneToOne
	@JoinColumn(name="accno")
	private Account account;

	

	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public int getPassportid() {
		return passportid;
	}


	public void setPassportid(int passportid) {
		this.passportid = passportid;
	}


	public String getCustomerfname() {
		return customerfname;
	}


	public void setCustomerfname(String customerfname) {
		this.customerfname = customerfname;
	}


	public String getCustomerlname() {
		return customerlname;
	}


	public void setCustomerlname(String customerlname) {
		this.customerlname = customerlname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Loan> getLoans() {
		return loans;
	}


	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", passportid=" + passportid + ", customerfname=" + customerfname
				+ ", customerlname=" + customerlname + ", gender=" + gender + ", dob=" + dob + ", mobile=" + mobile
				+ ", email=" + email + ", loans=" + loans + ", account=" + account + "]";
	}



	
}
