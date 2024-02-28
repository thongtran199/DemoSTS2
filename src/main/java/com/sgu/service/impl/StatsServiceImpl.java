package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.StatsDao;
import com.sgu.dao.impl.StatsDaoImpl;
import com.sgu.dto.ByDayDTO;
import com.sgu.dto.ByMonthDTO;
import com.sgu.dto.Top10ProductDTO;
import com.sgu.dto.Top5CustomerDTO;
import com.sgu.dto.Top5SellerDTO;
import com.sgu.service.StatsService;

public class StatsServiceImpl implements StatsService{
private StatsDao dao;
	
public StatsServiceImpl()
{
	dao = new StatsDaoImpl();
}
	@Override
	public List<Top5SellerDTO> findTop5SellerDTO() {
		return dao.findTop5SellerDTO();
	}

	@Override
	public List<Top5CustomerDTO> findTop5CustomerDTO() {
		return dao.findTop5CustomerDTO();
	}

	@Override
	public List<Top10ProductDTO> findTop10ProductDTO() {
		return dao.findTop10ProductDTO();
	}

	@Override
	public List<ByMonthDTO> findByMonthDTO() {
		return dao.findByMonthDTO();
	}

	@Override
	public List<ByDayDTO> findByDayDTO() {
		return dao.findByDayDTO();
	}


}
