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
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private int reviewID;

    @Column(name = "Content")
    private String content;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Product product;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;

	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Review() {
		
	}
	public Review(int reviewID, String content, Product product, User user) {
		super();
		this.reviewID = reviewID;
		this.content = content;
		this.product = product;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [reviewID=" + reviewID + ", content=" + content + ", product=" + product + ", user=" + user
				+ "]";
	}

}