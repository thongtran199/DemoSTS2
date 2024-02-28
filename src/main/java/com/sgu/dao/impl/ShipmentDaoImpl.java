package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.ShipmentDao;
import com.sgu.entity.Shipment;

public class ShipmentDaoImpl extends AbstractDao<Shipment> implements ShipmentDao{

	@Override
	public Shipment findById(Integer id) {
		return super.findById(Shipment.class, id);
	}


	@Override
	public List<Shipment> findAll() {
		return super.findAll(Shipment.class, true);
	}

	@Override
	public Shipment findByShipTEL(String tel) {
		String sql = "SELECT o FROM Shipment o WHERE o.shipTEL = ?0";
		return super.findOne(Shipment.class, sql, tel);
	}


}
