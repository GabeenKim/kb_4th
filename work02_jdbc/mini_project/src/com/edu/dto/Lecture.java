package com.edu.dto;

public class Lecture {
	private int id;
	private String name;
	private String subject;
	private int like;
	private int price;
	
	public Lecture() {}
	//DB col : lecture_id, lecture_name, subject, likes
	public Lecture(int id, String name, String subject, int like, int price) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.like = like;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Lecture [id=" + id + ", name=" + name + ", subject=" + subject + ", like=" + like + ", price=" + price
				+ "]";
	}
	
}
