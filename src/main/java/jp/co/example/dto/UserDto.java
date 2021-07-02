package jp.co.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {
	@NotNull(message="IDは必須です。")
	private Integer user_id;

	@NotBlank(message="名前は必須です。")
	private String nickname;

	@NotBlank(message="パスワードは必須です。")
	private String pass_word;

	@NotBlank(message="住所は必須です。")
	private String from_add;

	@NotBlank(message="住所は必須です。")
	private String from_add2;

	@NotBlank(message="電話番号は必須です。")
	private String tel_no;

	@NotBlank(message="郵便番号は必須です。")
	private String post_code;

	private Integer manager;

	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", nickname=" + nickname + ", pass_word=" + pass_word + ", from_add="
				+ from_add + ",from_add2=" + from_add2 + ",tel_no=" + tel_no + ",post_code=" + post_code + "]";
	}

	public UserDto() {

	}

	public UserDto(Integer user_id2, String nickname2, String pass_word2, String from_add3, String from_add22,
			String tel_no2, String post_code2,Integer manager) {
		this.user_id = user_id2;
		this.nickname = nickname2;
		this.pass_word = pass_word2;
		this.from_add = from_add3;
		this.from_add2 = from_add22;
		this.tel_no = tel_no2;
		this.post_code = post_code2;
		this.manager=manager;
	}

	public UserDto(Integer user_id) {
		this.user_id=user_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getFrom_add() {
		return from_add;
	}

	public void setFrom_add(String from_add) {
		this.from_add = from_add;
	}

	public String getFrom_add2() {
		return from_add2;
	}

	public void setFrom_add2(String from_add2) {
		this.from_add2 = from_add2;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}


	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}
}
