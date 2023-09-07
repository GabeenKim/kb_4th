package com.service.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//vo class...
@Entity
@Table(name="member")
public class Member {
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(nullable = false)
	private String password; 
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 100)
	private String address;
}
