package com.service.mybatis.vo;

public class MySawon {
	private int num, age;	//컬럼명과 필드가 다를 수도 있으니 주의. 현재는 동일
	private String id, pwd, name, hiredate;
	
	//프레임워크에서는 기본생성자가 무조건 필요함... -> 명시적 생성자가 있기도 하고 Container가 생성해주기 때문. 
	public MySawon() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "MySawon [num=" + num + ", age=" + age + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", hiredate="
				+ hiredate + "]";
	}
	
	
}
