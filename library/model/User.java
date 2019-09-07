package com.library.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "user")

public class User{
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private int age;
	private long phone;
	private String section;
	
	
    @JsonBackReference

	@ManyToMany(fetch = FetchType.LAZY,cascade = 
		{CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "user")

	private Set<Library> library= new HashSet<>();

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Set<Library> getLibrary() {
		return library;
	}

	public void setLibrary(Set<Library> library) {
		this.library = library;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getSection() {
		return section;
	}
	@JsonBackReference
	@Override
	public String toString() {
		return "Library [user_id=" + user_id + ", age=" + age + ", phone=" + phone + ", section=" + section + "]";
	}
	

}
