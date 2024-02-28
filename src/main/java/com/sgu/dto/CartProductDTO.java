package com.sgu.dto;

import com.sgu.entity.Product;

public class CartProductDTO {
	public CartProductDTO() {
	}
	
    private int productID;
    private String productName;
    private Float unitPrice;
    private Integer quantity;
    private Integer total;
    private String color;
    private String image;
    private String describe;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
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
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public CartProductDTO(int productID, String productName, Float unitPrice, Integer quantity, Integer total,
			String color, String image, String describe) {
		this.productID = productID;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.total = total;
		this.color = color;
		this.image = image;
		this.describe = describe;
	}
	public CartProductDTO(Product product)
	{
		this.productID = product.getProductID();
		this.productName = product.getProductName();
		this.unitPrice = product.getUnitPrice();
		this.quantity = product.getQuantity();
		this.color = product.getColor();
		this.image = product.getImage();
		this.describe = product.getDescription();
	}
	public void updateTotal()
	{
		this.total = (int)Math.floor(this.unitPrice * this.quantity);
	}
	@Override
	public String toString() {
		return "CartProductDTO [productID=" + productID + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", total=" + total + ", color=" + color + ", image=" + image
				+ ", describe=" + describe + "]";
	}
    
}
