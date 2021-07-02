package jp.co.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dto.ProductDto;
    @Repository
public class PgProductDao implements ProductDao{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<ProductDto> findById(Integer product_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql="SELECT product_id,product_name,price,stock,meker FROM product WHERE product_id=:product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", product_id);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	@Override
	public List<ProductDto> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		String sql="SELECT product_id,product_name,price,stock,meker FROM product;";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	@Override
	public List<ProductDto> joinpath(Integer user_id) {
		String sql= "SELECT user_id,product_name,price,meker FROM product JOIN orders ON orders.product_id=product.product_id WHERE user_id=:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	@Override
	public List<ProductDto> category_id(Integer product_id) {
		String sql="SELECT img,product.product_id,product_name,price,stock,meker FROM images JOIN product ON images.product_id=product.product_id WHERE product.product_id=:product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", product_id);

		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	@Override
	public void insert(Integer product_id, String product_name, Integer price, Integer stock, String meker,
			Integer category_id) {
		String sql="INSERT INTO product VALUES(:product_id,:product_name,:price,:stock,:meker,:category_id)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", product_id);
		param.addValue("product_name", product_name);
		param.addValue("price", price);
		param.addValue("stock", stock);
		param.addValue("meker", meker);
		param.addValue("category_id", category_id);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public int update(Integer product_id, String product_name, Integer price, Integer stock, String meker,Integer category_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql="UPDATE product SET product_name=:product_name,price=:price,stock=:stock,meker=:meker,category_id=:category_id WHERE product_id=:product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_name", product_name);
		param.addValue("price", price);
		param.addValue("stock", stock);
		param.addValue("meker", meker);
		param.addValue("category_id", category_id);
		param.addValue("product_id", product_id);
		return jdbcTemplate.update(sql, param);
	}

	@Override
	public void delete(Integer product_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql="DELETE FROM product WHERE product_id=:product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", product_id);
		jdbcTemplate.update(sql, param);
	}

}
