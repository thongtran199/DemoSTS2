package com.sgu.dto;


public class ByMonthDTO {
	public ByMonthDTO() {
	}
	
    private String month;
    private Float revenue;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Float getRevenue() {
		return revenue;
	}
	public void setRevenue(Float revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		return "ByMonthDTO [month=" + month + ", revenue=" + revenue + "]";
	}
	
    
}