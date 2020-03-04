package com.Harish.web.model;

public class user {
	//private int sno;
	private String uname;
	private String password;
	/*public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}*/
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return uname;
	}
	

}
