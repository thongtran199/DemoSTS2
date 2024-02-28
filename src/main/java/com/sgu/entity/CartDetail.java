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
@Table(name = "cart_detail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartDetailID")
    private int cartDetailID;

    @ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="CartID", referencedColumnName = "CartID")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Cart cart;

    public CartDetail(int cartDetailID, Cart cart, Product product, Float unitPrice, Integer quantity) {
		this.cartDetailID = cartDetailID;
		this.cart = cart;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "CartDetail [cartDetailID=" + cartDetailID + ", cart=" + cart + ", product=" + product + ", unitPrice="
				+ unitPrice + ", quantity=" + quantity + "]";
	}



	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ProductID", referencedColumnName = "ProductID")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Product product;

    @Column(name = "UnitPrice")
    private Float unitPrice;

    public int getCartDetailID() {
		return cartDetailID;
	}



	public void setCartDetailID(int cartDetailID) {
		this.cartDetailID = cartDetailID;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
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



	@Column(name = "Quantity")
    private Integer quantity;



    public CartDetail() {
    }
}