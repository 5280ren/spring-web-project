package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.UserDto;

public interface UserService {
	public void insert(Integer user_id, String nickname, String pass_word, String from_add, String from_add2,
			String tel_no, String post_code);

	public  List<UserDto> findwhere(Integer user_id);

	public  List<UserDto> find(Integer user_id,String pass_word);

	public int update(Integer user_id,String pass_word,String nickname);

	public List<UserDto>findall();

	public int updatemanager(Integer user_id,Integer manager);
}
