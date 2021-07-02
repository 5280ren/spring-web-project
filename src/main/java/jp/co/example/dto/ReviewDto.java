package jp.co.example.dto;

public class ReviewDto {
	public Integer user_id;
	public Integer review;
	public String review_data;
	public Integer product_id;
	public String date;

	public ReviewDto() {

	}

	public ReviewDto(Integer user_id, Integer review, String review_data, Integer product_id, String date) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.user_id = user_id;
		this.review = review;
		this.review_data = review_data;
		this.product_id = product_id;
		this.date = date;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getReview() {
		return review;
	}

	public void setReview(Integer review) {
		this.review = review;
	}

	public String getReview_data() {
		return review_data;
	}

	public void setReview_data(String review_data) {
		this.review_data = review_data;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
