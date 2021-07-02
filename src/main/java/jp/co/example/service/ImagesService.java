package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.ImagesDto;

public interface ImagesService {
	public List<ImagesDto> findById(int product_id);

	public List<ImagesDto>findall();

	public List<ImagesDto>category_id(Integer category_id);

	public void insert(Integer product_id,String img);

    public int update(Integer product_id,String img);

    public void delete(Integer product_id);

    public List<ImagesDto>productjoinimg(Integer product_id);
}
