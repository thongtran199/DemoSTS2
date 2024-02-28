package com.sgu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
public class Product {
	public Product() {
	}
	
	
    public Product(int productID, String productName, Supplier supplier, Category category, Float unitPrice,
			Integer quantity, String color, String image, String description) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.color = color;
		this.image = image;
		this.description = description;
	}


	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", supplier=" + supplier
				+ ", category=" + category + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", color=" + color
				+ ", image=" + image + ", description=" + description + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productID;

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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	@Column(name = "ProductName")
    private String productName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Supplier supplier;

    public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Category category;

    @Column(name = "UnitPrice")
    private Float unitPrice;

	@Column(name = "IsActive")
	private Boolean isActive;
	
    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Color")
    private String color;

    @Column(name = "Image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;
}