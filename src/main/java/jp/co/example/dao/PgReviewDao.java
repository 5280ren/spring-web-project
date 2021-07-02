package jp.co.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class PgReviewDao implements ReviewDao{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public int insert(Integer user_id,Integer review,String review_data,Integer product_id,String date) {
		String sql="INSERT INTO reviews (user_id,review,review_data,product_id,date)VALUES(:user_id,:review,:review_data,:product_id,:date)";
		MapSqlParameterSource param = new MapSqlParameterSource();
         param.addValue("user_id", user_id);
         param.addValue("review", review);
         param.addValue("review_data", review_data);
         param.addValue("product_id", product_id);
         param.addValue("date", date);
		return jdbcTemplate.update(sql, param);
	}

}
