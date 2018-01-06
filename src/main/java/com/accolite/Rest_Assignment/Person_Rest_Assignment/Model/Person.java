package com.accolite.Rest_Assignment.Person_Rest_Assignment.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
public class Person {
	int P_id;
	String name;
	String email;
	String phone;
	public Person(){
		this.P_id = 0;
		this.name = "";
		this.email = "";
		this.phone = "";
	}
	public Person(int p_id, String name, String email, String phone) {
		super();
		P_id = p_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public int getP_id() {
		return P_id;
	}
	public void setP_id(int p_id) {
		P_id = p_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
}
