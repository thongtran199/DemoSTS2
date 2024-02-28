package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.ShipmentDao;
import com.sgu.dao.impl.ShipmentDaoImpl;
import com.sgu.entity.Shipment;
import com.sgu.service.ShipmentService;

public class ShipmentServiceImpl implements ShipmentService {

	private ShipmentDao dao;
	
	public ShipmentServiceImpl()
	{
		dao = new ShipmentDaoImpl();
	}

	@Override
	public Shipment findByShipTEL(String tel) {
		return dao.findByShipTEL(tel);
	}

	@Override
	public Shipment create(Shipment entity) {
		
		return dao.create(entity);
	}

	@Override
	public Shipment update(Shipment entity) {
		return dao.update(entity);
	}

	@Override
	public Shipment delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Shipment> findAll() {
		return dao.findAll();
	}
}
