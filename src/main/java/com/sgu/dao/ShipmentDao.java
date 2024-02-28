package com.sgu.dao;

import java.util.List;

import com.sgu.entity.Shipment;

public interface ShipmentDao {
	Shipment findById(Integer id);
	Shipment findByShipTEL(String tel);
	List<Shipment> findAll();
	Shipment create(Shipment entity);
	Shipment update(Shipment entity);
	Shipment delete(Shipment entity);
}
