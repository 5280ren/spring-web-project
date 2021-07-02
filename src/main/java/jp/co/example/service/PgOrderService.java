package jp.co.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.OrderDao;
import jp.co.example.dto.OrderDto;
@Service
public class PgOrderService implements OrderService{

	@Autowired
	OrderDao orderdao;

	@Override
	public void insert(String order_date, Integer product_id, Integer user_id, String postcode,
			String from_add, String from_add2, Integer payment) {
		// TODO 自動生成されたメソッド・スタブ
		orderdao.insert(order_date, product_id, user_id, postcode, from_add, from_add2,  payment);

	}

	@Override
	public List<OrderDto> findpath(Integer order_number) {
		// TODO 自動生成されたメソッド・スタブ
		return orderdao.findpath(order_number);
	}

	@Override
	public List<OrderDto> joinpath(Integer user_id) {
		// TODO 自動生成されたメソッド・スタブ
		return orderdao.joinpath(user_id);
	}



}
