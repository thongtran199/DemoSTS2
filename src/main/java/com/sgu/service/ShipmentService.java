package com.sgu.service;

import java.util.List;

import com.sgu.entity.Shipment;

public interface ShipmentService {
	Shipment findById(Integer id);
	Shipment findByShipTEL(String tel);
	List<Shipment> findAll();
	Shipment create(Shipment entity);
	Shipment update(Shipment entity);
	Shipment delete(Integer id);
}
