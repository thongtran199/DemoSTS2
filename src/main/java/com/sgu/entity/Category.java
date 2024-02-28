package com.sgu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int categoryID;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "Image")
    private String image;

	@Column(name = "IsActive")
	private Boolean isActive;

    public Category() {
        // Default constructor
    }

    public Boolean getIsActive() {
		return isActive;
	}

	public Category(int categoryID, String categoryName, String image, Boolean isActive) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.image = image;
		this.isActive = isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", image=" + image + "]";
	}

	public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

	public Category(int categoryID, String categoryName, String image) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.image = image;
	}
    
}