package jp.co.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dto.OrderDto;
@Repository
public class PgOrderDao implements OrderDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public void insert(String order_date, Integer product_id, Integer user_id, String postcode,
			String from_add, String from_add2,  Integer payment) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "INSERT INTO orders VALUES((SELECT COALESCE(MAX(order_number),111)+1 FROM orders),:order_date,:product_id,:user_id,:postcode,:from_add,:from_add2,:payment)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("order_date", order_date);
		param.addValue("product_id", product_id);
		param.addValue("user_id", user_id);
		param.addValue("postcode", postcode);
		param.addValue("from_add", from_add);
		param.addValue("from_add2", from_add2);
		param.addValue("payment", payment);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<OrderDto> findpath(Integer order_number) {
		String sql="SELECT order_number,order_date,product_id,user_id, FROM orders WHERE order_number=:order_number";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("order_number", order_number);

		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<OrderDto>(OrderDto.class));
	}

	@Override
	public List<OrderDto> joinpath(Integer user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql= "SELECT user_id,product_name,price,meker FROM orders JOIN product ON orders.product_id=product.product_id WHERE user_id=:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<OrderDto>(OrderDto.class));
	}



}
