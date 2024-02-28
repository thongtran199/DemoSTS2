package com.sgu.dto;


public class ByDayDTO {
	public ByDayDTO() {
	}
	
    private String dayOfWeek;
    private Float revenue;
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Float getRevenue() {
		return revenue;
	}
	public void setRevenue(Float revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		return "ByDayDTO [dayOfWeek=" + dayOfWeek + ", revenue=" + revenue + "]";
	}



    
}