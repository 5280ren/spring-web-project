package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.ProductDto;

public interface ProductService {
	public List<ProductDto> findById(Integer product_id);

	public List<ProductDto> findAll();

	public List<ProductDto>joinpath(Integer user_id);

	public List<ProductDto>category_id(Integer product_id);

	public void insert(Integer product_id,String product_name,Integer price,Integer stock,String meker,Integer category_id);

    public int update(Integer product_id,String product_name,Integer price,Integer stock,String meker,Integer category_id);

    public void delete(Integer product_id);
}
