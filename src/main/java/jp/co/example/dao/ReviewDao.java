package jp.co.example.dao;

public interface ReviewDao {
    public int insert(Integer user_id,Integer review,String review_data,Integer product_id,String date);
}
