package jp.co.example.dto;

import javax.validation.constraints.NotBlank;

public class ImagesDto {
	private Integer img_id;
	private Integer product_id;
	@NotBlank(message="画像は必須です。")
	private String img;
    private Integer category_id;


	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public ImagesDto() {

	}

	public ImagesDto(Integer product_id) {
		this.product_id=product_id;
	}

	public ImagesDto(Integer product_id,String img) {
		this.product_id=product_id;
		this.img=img;
	}

	public ImagesDto(String img) {
		this.img=img;
	}

	public Integer getImg_id() {
		return img_id;
	}

	public void setImg_id(Integer img_id) {
		this.img_id = img_id;
	}


	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
