package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.OrderDto;

public interface OrderDao {
     public void insert(String order_date,Integer product_id,Integer user_id,String postcode,String from_add,String from_add2,Integer payment);

     public List<OrderDto>findpath(Integer order_number);

     public List<OrderDto> joinpath(Integer user_id);
}
