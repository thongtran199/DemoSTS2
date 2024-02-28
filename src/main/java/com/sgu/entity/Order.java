package com.sgu.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderID;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;

    @Column(name = "Total")
    private Float total;

    @OneToOne
    @JoinColumn(name = "PaymentID", referencedColumnName = "PaymentID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Payment payment;

    @Column(name = "PaymentDate")
    @CreationTimestamp
    private Timestamp paymentDate;

    @Column(name = "OrderDate")
    @CreationTimestamp
    private Timestamp orderDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ShippingID", referencedColumnName = "ShippingID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Shipment shipment;

    public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	@Column(name = "Status")
    private Integer status;

	@Column(name = "IsActive")
	private Boolean isActive;
	
    @ManyToOne
    @JoinColumn(name = "SellerID", referencedColumnName = "UserID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User seller;



    public Order() {
 
    }



	public int getOrderID() {
		return orderID;
	}



	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Float getTotal() {
		return total;
	}



	public void setTotal(Float total) {
		this.total = total;
	}



	public Payment getPayment() {
		return payment;
	}



	public void setPayment(Payment payment) {
		this.payment = payment;
	}



	public Timestamp getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}



	public Timestamp getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}



	public Shipment getShipment() {
		return shipment;
	}



	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public User getSeller() {
		return seller;
	}



	public void setSeller(User seller) {
		this.seller = seller;
	}



	public Order(int orderID, User user, Float total, Payment payment, Timestamp paymentDate, Timestamp orderDate,
			Shipment shipment, Integer status, User seller) {
		super();
		this.orderID = orderID;
		this.user = user;
		this.total = total;
		this.payment = payment;
		this.paymentDate = paymentDate;
		this.orderDate = orderDate;
		this.shipment = shipment;
		this.status = status;
		this.seller = seller;
	}
    
    }