package jp.co.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ProductDao;
import jp.co.example.dto.ProductDto;
@Service
public class PgProductService implements ProductService{
	@Autowired
	private ProductDao productdao;
	@Override
	public List<ProductDto> findById(Integer product_id) {
		// TODO 自動生成されたメソッド・スタブ
		return productdao.findById(product_id);
	}

	@Override
	public List<ProductDto> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return productdao.findAll();
	}

	@Override
	public List<ProductDto> joinpath(Integer user_id) {
		// TODO 自動生成されたメソッド・スタブ
		return productdao.joinpath(user_id);
	}

	public List<ProductDto>category_id(Integer product_id){
		return productdao.category_id(product_id);
	}

	@Override
	public void insert(Integer product_id, String product_name, Integer price, Integer stock, String meker,
			Integer category_id) {
		   productdao.insert(product_id, product_name, price, stock, meker, category_id);

	}

	@Override
	public int update(Integer product_id, String product_name, Integer price, Integer stock, String meker,Integer category_id) {
		// TODO 自動生成されたメソッド・スタブ
		return productdao.update(product_id, product_name, price, stock, meker,category_id);
	}

	@Override
	public void delete(Integer product_id) {
         productdao.delete(product_id);
	}
}
