package com.synergisticit.onlinebanking.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Range;
//import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.synergisticit.onlinebanking.validation.AccountValidator;

@Entity

public class Account {
	@Id
	@NotNull(message="account number cannot be null") //HERE VALIDATING USING JAVAX VALIDATION
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="accno")
	private long accno;

	private String accType;
	
	private String accholdername;
	
	//@DateTimeFormat(pattern="yyyy/mm/dd")

	private Date opendate;
	
	@Range(min=3000,max=5000,message="accBalance between 3000 and 5000") //HERE VALIDATING USING HIBERNATE VALIDATION
	private double accBalance;

	@ManyToOne
	@JoinColumn(name="bcode")
	//@JsonManagedReference
	@JsonIgnore
	private Branch branch;
	
	
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="account_transaction",joinColumns={@JoinColumn(name="accno")},inverseJoinColumns={@JoinColumn(name="id")})
	//@JsonManagedReference
	@JsonIgnore
	private Set<Transaction> transactions=new HashSet<Transaction>();
	
	
	public Account(){
		
	}
	
	public long getAccno() {
		return accno;
	}




	public void setAccno(long accno) {
		this.accno = accno;
	}




	public String getAccType() {
		return accType;
	}




	public void setAccType(String accType) {
		this.accType = accType;
	}




	public String getAccholdername() {
		return accholdername;
	}




	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}




	public Date getOpendate() {
		return opendate;
	}




	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}




	public double getAccBalance() {
		return accBalance;
	}




	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}




	public Branch getBranch() {
		return branch;
	}




	public void setBranch(Branch branch) {
		this.branch = branch;
	}




	public Set<Transaction> getTransactions() {
		return transactions;
	}




	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}




	@Override
	public String toString() {
		return "Account [accno=" + accno + ", accType=" + accType + ", accholdername=" + accholdername + ", opendate="
				+ opendate + ", accBalance=" + accBalance + ", branch=" + branch + ", transactions=" + transactions
				+ "]";
	}







	
	
	
	

}
