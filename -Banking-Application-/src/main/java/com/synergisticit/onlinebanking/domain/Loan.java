package com.synergisticit.onlinebanking.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Loan {
	@Id
	private int loanid;
	private long amount;
	
	private int bcode;
	private String loanType;
	@DateTimeFormat(pattern="yyyy/mm/dd")
	private Date loandate;
	
	@ManyToOne 
	@JoinColumn(name="customerid")
	private Customer customer;
	
	

	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Date getLoandate() {
		return loandate;
	}
	public void setLoandate(Date loandate) {
		this.loandate = loandate;
	}
	public int getLoanid() {
		return loanid;
	}
	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Loan [loanid=" + loanid + ", amount=" + amount + ", bcode=" + bcode + ", loanType=" + loanType
				+ ", loandate=" + loandate + ", customer=" + customer + "]";
	}
	
	

}
