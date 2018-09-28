package sms.function;

import java.io.Serializable;

public class SchoolDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name,address, email, phone;
	private Teacher[] teacher;
	
	public SchoolDTO() {
		super();
	}

	public SchoolDTO(String name, String address, String email, String phone, Teacher[] teacher) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Teacher[] getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher[] teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "SchoolDTO [name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + "]";
	}

	
	
	
}
