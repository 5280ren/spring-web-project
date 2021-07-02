package jp.co.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {
	@NotNull(message="商品IDは必須です。")
	private Integer product_id;

	@NotBlank(message="商品名は必須です。")
	private String product_name;

	@NotNull(message="価格を入力してください。")
	private Integer price;

	@NotNull(message="在庫数を入力してください。")
	private Integer stock;

	@NotBlank(message="メーカーは必須です。")
	private String meker;

	@NotNull(message="IDは必須です。")
	private Integer user_id;

	@NotNull(message="カテゴリを入力してください")
	private Integer category_id;


	private String img;


	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ProductDto() {

	}

	public ProductDto(Integer product_id) {
        this.product_id=product_id;
	}

	public ProductDto(Integer product_id,String product_name,Integer price,Integer stock,String meker) {
		 this.product_id=product_id;
		 this.product_name=product_name;
		 this.price=price;
		 this.stock=stock;
		 this.meker=meker;
	}

	public ProductDto(Integer user_id,Integer Product_id,String product_name,Integer price,Integer stock,String meker) {
		this.user_id=user_id;
		this.product_id=Product_id;
		this.product_name=product_name;
		this.price=price;
		this.stock=stock;
		this.meker=meker;
	}

	public ProductDto(int user_id) {
		this.user_id=user_id;
	}
	@Override
	public String toString() {
		return "ProductDto [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price + ", stock="
				+ stock + ",meker=" + meker + "]";
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getMeker() {
		return meker;
	}

	public void setMeker(String meker) {
		this.meker = meker;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

}
