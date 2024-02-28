package com.sgu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShippingID")
    private int shippingID;

    @Column(name = "ShipTEL")
    private String shipTEL;

    @Column(name = "ShipperName")
    private String shipperName;
    
    public Shipment() {}

	public int getShippingID() {
		return shippingID;
	}

	public void setShippingID(int shippingID) {
		this.shippingID = shippingID;
	}

	public String getShipTEL() {
		return shipTEL;
	}

	public void setShipTEL(String shipTEL) {
		this.shipTEL = shipTEL;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	@Override
	public String toString() {
		return "Shipment [shippingID=" + shippingID + ", shipTEL=" + shipTEL + ", shipperName=" + shipperName + "]";
	}

	public Shipment(int shippingID, String shipTEL, String shipperName) {
		super();
		this.shippingID = shippingID;
		this.shipTEL = shipTEL;
		this.shipperName = shipperName;
	}
    

}