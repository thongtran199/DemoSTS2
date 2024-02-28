package com.sgu.dto;


public class Top5CustomerDTO {
	public Top5CustomerDTO() {
	}
	
    private int userID;
    private String fullName;

    private String email;
    private Float total;
    private Integer total_order;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Integer getTotal_order() {
		return total_order;
	}
	public void setTotal_order(Integer total_order) {
		this.total_order = total_order;
	}
	public Top5CustomerDTO(int userID, String fullName, String email, Float total, Integer total_order) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
		this.total = total;
		this.total_order = total_order;
	}
	@Override
	public String toString() {
		return "Top5CustomerDTO [userID=" + userID + ", fullName=" + fullName + ", email=" + email + ", total=" + total
				+ ", total_order=" + total_order + "]";
	}



}
