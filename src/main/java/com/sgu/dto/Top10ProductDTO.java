package com.sgu.dto;





public class Top10ProductDTO {
	public Top10ProductDTO() {
	}
    private int productID;
    private Float unitPrice;

	private Boolean isActive;
	
    private Integer quantity;

    private String color;

    private String image;

    private String description;
    private String productName;
    private Integer soldQuantity;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getSoldQuantity() {
		return soldQuantity;
	}
	public void setSoldQuantity(Integer soldQuantity) {
		this.soldQuantity = soldQuantity;
	}
	public Top10ProductDTO(int productID, Float unitPrice, Boolean isActive, Integer quantity, String color,
			String image, String description, String productName, Integer soldQuantity) {
		super();
		this.productID = productID;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
		this.quantity = quantity;
		this.color = color;
		this.image = image;
		this.description = description;
		this.productName = productName;
		this.soldQuantity = soldQuantity;
	}
	@Override
	public String toString() {
		return "Top10ProductDTO [productID=" + productID + ", unitPrice=" + unitPrice + ", isActive=" + isActive
				+ ", quantity=" + quantity + ", color=" + color + ", image=" + image + ", description=" + description
				+ ", productName=" + productName + ", soldQuantity=" + soldQuantity + "]";
	}
    
	
    

}
