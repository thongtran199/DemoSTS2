package com.sgu.dao.impl;



import java.util.ArrayList;
import java.util.List;


import com.sgu.dao.AbstractDao;
import com.sgu.dao.StatsDao;
import com.sgu.dto.ByDayDTO;
import com.sgu.dto.ByMonthDTO;
import com.sgu.dto.Top10ProductDTO;
import com.sgu.dto.Top5CustomerDTO;
import com.sgu.dto.Top5SellerDTO;


public class StatsDaoImpl extends AbstractDao<Object[]> implements StatsDao {

	@Override
	public List<Top5SellerDTO> findTop5SellerDTO() {
		String sql = "SELECT u.userID, u.fullName,u.email, o.total_money, o.total_orders\r\n"
				+ "FROM user u\r\n"
				+ "JOIN (\r\n"
				+ "    SELECT o.sellerID, SUM(o.Total) AS total_money, COUNT(*) AS total_orders\r\n"
				+ "    FROM orders o\r\n"
				+ "    GROUP BY o.sellerID\r\n"
				+ "    ORDER BY total_money\r\n"
				+ ") o ON u.userID = o.sellerID\r\n"
				+ "ORDER BY o.total_money DESC";
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<Top5SellerDTO> result = new ArrayList<>();
		objects.forEach(Item -> {
			Top5SellerDTO e = new Top5SellerDTO();
			e = setDataTop5SellerDTO(Item);
			result.add(e);
		});
		return result;
	}

	@Override
	public List<Top5CustomerDTO> findTop5CustomerDTO() {
		String sql = "SELECT u.userID, u.fullName, u.email, o.total_money, o.total_orders\r\n"
				+ "FROM user u\r\n"
				+ "JOIN (\r\n"
				+ "    SELECT o.userID, SUM(o.Total) AS total_money, COUNT(*) AS total_orders\r\n"
				+ "    FROM orders o\r\n"
				+ "    WHERE o.IsActive = true\r\n"
				+ "    GROUP BY o.userID\r\n"
				+ "    ORDER BY total_money\r\n"
				+ ") o ON u.userID = o.userID\r\n"
				+ "ORDER BY o.total_money DESC\r\n"
				+ "LIMIT 5;";
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<Top5CustomerDTO> result = new ArrayList<>();
		objects.forEach(Item -> {
			Top5CustomerDTO e = new Top5CustomerDTO();
			e = setDataTop5CustomerDTO(Item);
			result.add(e);
		});
		return result;
	}

	@Override
	public List<Top10ProductDTO> findTop10ProductDTO() {
		String sql = "SELECT p.ProductID, p.ProductName, p.UnitPrice, p.Quantity, o.sold_quantity, p.Image\r\n"
				+ "FROM product p\r\n"
				+ "JOIN (\r\n"
				+ "SELECT o.ProductID ,SUM(o.Quantity) AS sold_quantity\r\n"
				+ "FROM order_detail o\r\n"
				+ "GROUP BY o.ProductID\r\n"
				+ ") o ON o.productID = p.productID\r\n"
				+ "ORDER BY o.sold_quantity DESC\r\n"
				+ "LIMIT 10;";
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<Top10ProductDTO> result = new ArrayList<>();
		objects.forEach(Item -> {
			Top10ProductDTO Top10ProductDTO = new Top10ProductDTO();
			Top10ProductDTO = setDataTop10ProductDTO(Item);
			result.add(Top10ProductDTO);
		});
		return result;
	}
	private Top10ProductDTO setDataTop10ProductDTO(Object[] object)
	{
		Top10ProductDTO top10ProductDTO = new Top10ProductDTO();
		top10ProductDTO.setProductID((Integer)object[0]);
		top10ProductDTO.setProductName((String)object[1]);
		top10ProductDTO.setUnitPrice(Float.valueOf(object[2].toString()));
		top10ProductDTO.setQuantity(Integer.valueOf(object[3].toString()) );
		top10ProductDTO.setSoldQuantity(Integer.valueOf(object[4].toString()));
		top10ProductDTO.setImage((String)object[5]);

		return top10ProductDTO;
	}
	private Top5SellerDTO setDataTop5SellerDTO(Object[] object)
	{
		Top5SellerDTO e = new Top5SellerDTO();
		e.setUserID((Integer)object[0]);
		e.setFullName((String)object[1]);
		e.setEmail((String)object[2]);
		e.setTotal((float) Double.parseDouble(object[3].toString()));
		e.setTotal_order(Integer.parseInt(object[4].toString()));

		return e;
	}
	private Top5CustomerDTO setDataTop5CustomerDTO(Object[] object)
	{
		Top5CustomerDTO e = new Top5CustomerDTO();
		e.setUserID((Integer)object[0]);
		e.setFullName((String)object[1]);
		e.setEmail((String)object[2]);
		e.setTotal((float) Double.parseDouble(object[3].toString()));
		e.setTotal_order(Integer.parseInt(object[4].toString()));

		return e;
	}
	private ByMonthDTO setDataByMonthDTO(Object[] object)
	{
		ByMonthDTO byMonthDTO = new ByMonthDTO();
		byMonthDTO.setMonth((String)object[0]);
		byMonthDTO.setRevenue((float) Double.parseDouble(object[1].toString()));

		return byMonthDTO;
	}
	private ByDayDTO setDataByDayDTO(Object[] object)
	{
		ByDayDTO byDayDTO = new ByDayDTO();
		byDayDTO.setDayOfWeek((String)object[0]);
		byDayDTO.setRevenue((float) Double.parseDouble(object[1].toString()));


		return byDayDTO;
	}

	@Override
	public List<ByMonthDTO> findByMonthDTO() {
		String sql = "SELECT\r\n"
				+ "    DATE_FORMAT(OrderDate, '%Y-%m') AS month,\r\n"
				+ "    SUM(Total) AS monthly_revenue\r\n"
				+ "FROM orders\r\n"
				+ "WHERE IsActive = 1\r\n"
				+ "    AND YEAR(OrderDate) = YEAR(CURRENT_DATE())\r\n"
				+ "GROUP BY month\r\n"
				+ "ORDER BY month;";
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<ByMonthDTO> result = new ArrayList<>();
		objects.forEach(Item -> {
			ByMonthDTO byMonthDTO = new ByMonthDTO();
			byMonthDTO = setDataByMonthDTO(Item);
			result.add(byMonthDTO);
		});
		return result;
	}

	@Override
	public List<ByDayDTO> findByDayDTO() {
		String sql = "SELECT\r\n"
				+ "    DAYNAME(OrderDate) AS day_of_week,\r\n"
				+ "    SUM(Total) AS daily_revenue\r\n"
				+ "FROM orders\r\n"
				+ "WHERE IsActive = 1\r\n"
				+ "GROUP BY DAYOFWEEK(OrderDate), DAYNAME(OrderDate)\r\n"
				+ "ORDER BY DAYOFWEEK(OrderDate);";
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<ByDayDTO> result = new ArrayList<>();
		objects.forEach(Item -> {
			ByDayDTO byDayDTO = new ByDayDTO();
			byDayDTO = setDataByDayDTO(Item);
			result.add(byDayDTO);
		});
		return result;
	}

}
