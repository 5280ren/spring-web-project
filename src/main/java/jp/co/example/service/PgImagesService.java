package jp.co.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ImagesDao;
import jp.co.example.dto.ImagesDto;
@Service
public class PgImagesService implements ImagesService{
     @Autowired
     private ImagesDao imagesdao;
	@Override
	public List<ImagesDto> findById(int product_id) {
		// TODO 自動生成されたメソッド・スタブ
		return imagesdao.findById(product_id);
	}
	@Override
	public List<ImagesDto> findall() {
		// TODO 自動生成されたメソッド・スタブ
		return imagesdao.findall();
	}
	@Override
	public List<ImagesDto> category_id(Integer category_id) {
		// TODO 自動生成されたメソッド・スタブ
		return imagesdao.category_id(category_id);
	}
	@Override
	public void insert(Integer product_id,String img) {
		// TODO 自動生成されたメソッド・スタブ
		imagesdao.insert(product_id,img);
	}
	@Override
	public int update(Integer product_id, String img) {
		// TODO 自動生成されたメソッド・スタブ
		return imagesdao.update(product_id, img);
	}
	@Override
	public void delete(Integer product_id) {
		imagesdao.delete(product_id);
	}
	@Override
	public List<ImagesDto> productjoinimg(Integer product_id) {
		// TODO 自動生成されたメソッド・スタブ
		return imagesdao.productjoinimg(product_id);
	}

}
