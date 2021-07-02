package jp.co.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UserDao;
import jp.co.example.dto.UserDto;
@Service
public class PgUserService implements UserService {
	@Autowired
	private UserDao userdao;

	@Override
	public void insert(Integer user_id, String nickname, String pass_word, String from_add, String from_add2,
			String tel_no, String post_code) {
		// TODO 自動生成されたメソッド・スタブ
		userdao.insert(user_id, nickname, pass_word, from_add, from_add2, tel_no, post_code);

	}

	@Override
	public List<UserDto> findwhere(Integer user_id) {
		// TODO 自動生成されたメソッド・スタブ
		return userdao.findnamepath(user_id);
	}

	@Override
	public List<UserDto> find(Integer user_id, String pass_word) {
		// TODO 自動生成されたメソッド・スタブ
		return userdao.find(user_id, pass_word);
	}

	@Override
	public int update(Integer user_id,String pass_word,String nickname) {

		return userdao.update(user_id, pass_word, nickname);
	}

	@Override
	public List<UserDto> findall() {
		// TODO 自動生成されたメソッド・スタブ
		return userdao.findall();
	}

	@Override
	public int updatemanager(Integer user_id, Integer manager) {
		// TODO 自動生成されたメソッド・スタブ
		return userdao.managerupdate(user_id, manager);
	}


}
