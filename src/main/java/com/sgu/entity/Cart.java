package com.sgu.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private int cartID;

    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="UserID", referencedColumnName = "UserID")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;


	@Column(name = "Quantity")
    private Integer quantity;
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


    public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public Cart() {

    }

	public Cart(int cartID, User user, Integer quantity) {
		super();
		this.cartID = cartID;
		this.user = user;
		this.quantity = quantity;
	}
	
}