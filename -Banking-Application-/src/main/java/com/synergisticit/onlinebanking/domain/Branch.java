package com.synergisticit.onlinebanking.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Branch {
	@Id
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="bcode")
	private int bcode;
	private String name;
	private String location;
	
	@OneToMany
	@JoinColumn(name="accno")
	@JsonBackReference
	private Set<Account> account=new HashSet<Account>();
	
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Branch [bcode=" + bcode + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
