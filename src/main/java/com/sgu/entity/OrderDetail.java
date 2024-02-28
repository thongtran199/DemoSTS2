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
@Table(name = "order_detail")
public class OrderDetail {
    @Override
	public String toString() {
		return "OrderDetail [orderDetailID=" + orderDetailID + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
	public String toStringMail() {
		return "["
				+ "Tên sản phẩm=" + product.getProductName()
				+ ", Số lượng =" + quantity 
				+ ", Đơn giá= $" + unitPrice 
				+ "]";
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private int orderDetailID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Order order;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Product product;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice")
    private Float unitPrice;


    public OrderDetail() {
    }


	public int getOrderDetailID() {
		return orderDetailID;
	}


	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Float getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}


	public OrderDetail(int orderDetailID, Order order, Product product, Integer quantity, Float unitPrice) {
		super();
		this.orderDetailID = orderDetailID;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
    
}