package jp.co.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dto.ImagesDto;

@Repository
public class PgImagesDao implements ImagesDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<ImagesDto> findById(int product_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "SELECT product_id,img FROM images WHERE product_id=:product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", product_id);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<ImagesDto>(ImagesDto.class));
	}

	@Override
	public List<ImagesDto> findall() {
		// TODO 自動生成されたメソッド・スタブ
		String sql="SELECT product_id,img FROM images ORDER BY product_id ASC ";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ImagesDto>(ImagesDto.class) );
	}

	@Override
	public List<ImagesDto> category_id(Integer category_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql="SELECT img,images.product_id FROM images JOIN product ON images.product_id=product.product_id WHERE category_id=:category_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_id", category_id);

		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<ImagesDto>(ImagesDto.class));
	}

	@Override
	public void insert(Integer product_id,String img) {
		String sql="INSERT INTO images VALUES ((SELECT (MAX(img_id))+1 FROM images ),:product_id,:img)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", product_id);
		param.addValue("img",img);
		jdbcTemplate.update(sql, param);
	}

	@Override
	public int update(Integer product_id, String img) {
		String sql="UPDATE images SET img=:img WHERE product_id=:product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("img", img);
		param.addValue("product_id", product_id);
		return jdbcTemplate.update(sql, param);
	}

	@Override
	public void delete(Integer product_id) {
		String sql="DELETE FROM images WHERE product_id=:product_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", product_id);
		jdbcTemplate.update(sql, param);
	}


	public List<ImagesDto>productjoinimg(Integer product_id){
        String sql="SELECT img,product.product_id,product_name,price,stock,meker FROM images JOIN product ON images.product_id=product.product_id WHERE images.product_id=:product_id";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id", product_id);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<ImagesDto>(ImagesDto.class));
	}
}
