package com.nt.bean;

import java.util.ArrayList;

public class UserList_bean {
	
	String acnt_no , pin, fname,lname,email,dob, mobile,gender , user;
	int id;
	
	public ArrayList<ArrayList<Object>> al  = new ArrayList<>();

	public String getAcnt_no() {
		return acnt_no;
	}

	public void setAcnt_no(String acnt_no) {
		this.acnt_no = acnt_no;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public void getArraylist() {
		
		al.add( new ArrayList<Object>());
		
		int n = al.size()-1;
		al.get(n).add(acnt_no);
		al.get(n).add(pin);
		al.get(n).add(fname);
		al.get(n).add(lname);
		al.get(n).add(email);
		al.get(n).add(dob);
		al.get(n).add(mobile);
		al.get(n).add(gender);
		al.get(n).add(user);
		al.get(n).add(id);
		
		return;

	}

}
