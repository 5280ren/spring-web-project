package jp.co.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dto.UserDto;

@Repository
public class PgUserDao implements UserDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void insert(Integer user_id, String nickname, String pass_word, String from_add, String from_add2,
			String tel_no, String post_code) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "INSERT INTO users VALUES (:user_id,:nickname,:pass_word,:from_add,:from_add2,:tel_no,:post_code)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);
		param.addValue("nickname", nickname);
		param.addValue("pass_word", pass_word);
		param.addValue("from_add", from_add);
		param.addValue("from_add2", from_add2);
		param.addValue("tel_no", tel_no);
		param.addValue("post_code", post_code);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<UserDto> findnamepath(Integer user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql="SELECT user_id, nickname, pass_word,from_add,from_add2,tel_no,post_code,manager FROM users WHERE user_id =:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<UserDto>(UserDto.class));
	}

	@Override
	public List<UserDto> find(Integer user_id, String pass_word) {
		// TODO 自動生成されたメソッド・スタブ
		String sql="SELECT user_id, nickname, pass_word,from_add,from_add2,tel_no,post_code,manager FROM users WHERE user_id =:user_id AND pass_word=:pass_word";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);
		param.addValue("pass_word", pass_word);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<UserDto>(UserDto.class));

	}

	@Override
	public int update(Integer user_id, String pass_word, String nickname) {
		String sql="UPDATE users SET nickname=:nickname,pass_word=:pass_word WHERE user_id=:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nickname", nickname);
		param.addValue("pass_word", pass_word);
		param.addValue("user_id", user_id);
		return jdbcTemplate.update(sql, param);
	}

    public List<UserDto>findall(){
    	String sql="SELECT user_id FROM users  ORDER BY user_id ASC";
    	return jdbcTemplate.query(sql,new BeanPropertyRowMapper<UserDto>(UserDto.class));
    }

	@Override
	public int managerupdate(Integer user_id,Integer manager) {
		String sql="UPDATE users SET manager=:manager WHERE user_id=:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("manager", manager);
		param.addValue("user_id", user_id);
		return jdbcTemplate.update(sql, param);

	}



}
