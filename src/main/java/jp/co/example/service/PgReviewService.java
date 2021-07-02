package jp.co.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ReviewDao;
@Service
public class PgReviewService implements ReviewService{
	@Autowired
	private ReviewDao reviewdao;
	@Override
	public int insert(Integer user_id, Integer review, String review_data, Integer product_id, String date) {
		// TODO 自動生成されたメソッド・スタブ
		return reviewdao.insert(user_id, review, review_data, product_id, date);
	}

}
