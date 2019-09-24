package com.synergisticit.onlinebanking.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
public class Transaction {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable=false,nullable=false)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
	private long id;
	
	private long fromAccount;
	@NotNull(message="account number cannot be null")
	private long toAccount;
	private Date txdate;
	private String comments;
	private double amounttx;
	//@Range(min=100,max=4000,message=" balance should be between 100 to 4000")
	private double depositamt;
	//@Range(max=2000,min=200,message="withdraw only upto 2000")
	private double withdrawamt;
	
	
	@ManyToMany(mappedBy="transactions")
	//@JsonBackReference
	private Set<Account> accounts=new HashSet<Account>();
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getFromAccount() {
		return fromAccount;
	}


	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}


	public long getToAccount() {
		return toAccount;
	}


	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}


	public Date getTxdate() {
		return txdate;
	}


	public void setTxdate(Date txdate) {
		this.txdate = txdate;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public double getAmounttx() {
		return amounttx;
	}


	public void setAmounttx(double amounttx) {
		this.amounttx = amounttx;
	}


	public double getDepositamt() {
		return depositamt;
	}


	public void setDepositamt(double depositamt) {
		this.depositamt = depositamt;
	}


	public double getWithdrawamt() {
		return withdrawamt;
	}


	public void setWithdrawamt(double withdrawamt) {
		this.withdrawamt = withdrawamt;
	}


	public Set<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", txdate="
				+ txdate + ", comments=" + comments + ", amounttx=" + amounttx + ", depositamt=" + depositamt
				+ ", withdrawamt=" + withdrawamt + ", accounts=" + accounts + "]";
	}



	
	
	
	

}
