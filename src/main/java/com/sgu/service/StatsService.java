package com.sgu.service;

import java.util.List;

import com.sgu.dto.ByDayDTO;
import com.sgu.dto.ByMonthDTO;
import com.sgu.dto.Top10ProductDTO;
import com.sgu.dto.Top5CustomerDTO;
import com.sgu.dto.Top5SellerDTO;


public interface StatsService {
	List<Top5SellerDTO> findTop5SellerDTO();
	List<Top5CustomerDTO> findTop5CustomerDTO();
	List<Top10ProductDTO> findTop10ProductDTO();
	List<ByMonthDTO> findByMonthDTO();
	List<ByDayDTO> findByDayDTO();
}
