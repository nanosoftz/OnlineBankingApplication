package com.synergisticit.onlinebanking.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users=new HashSet<User>();	
	
	
	
	public Role() {
		super();
	}
	
	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	

}
