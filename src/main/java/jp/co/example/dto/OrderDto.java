package jp.co.example.dto;

public class OrderDto {
	private Integer order_number;
	private String order_date;
	private Integer product_id;
	private Integer user_id;
	private String postcode;
	private String from_add;
	private String from_add2;
	private Integer payment;

	public OrderDto() {

	}

	public OrderDto(int user_id) {
		this.user_id=user_id;
	}

	public OrderDto( String order_date, Integer product_id, Integer user_id, String postcode, String from, String from2,
			 Integer payment) {
		//this.order_number = order_number;
		this.order_date = order_date;
		this.product_id = product_id;
		this.user_id = user_id;
		this.postcode = postcode;
		this.from_add = from;
		this.from_add2 = from2;
		this.payment = payment;
	}


	public OrderDto(Integer cash) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.payment=cash;
	}

	public OrderDto(String post, String add, String add2, Integer cash) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.postcode=post;
		this.from_add=add;
		this.from_add2=add2;
		this.payment=cash;

	}

	public OrderDto(Integer productid, Integer userid,String date, String post, String add, String add2, Integer cash) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.product_id=productid;
		this.user_id=userid;
		this.order_date=date;
		this.postcode=post;
		this.from_add=add;
		this.from_add2=add2;
		this.payment=cash;
	}

	public OrderDto(Integer product_id, Integer user_id, String postcode, String from_add, String from_add2,
			 Integer payment) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.product_id=product_id;
		this.user_id=user_id;
		this.postcode=postcode;
		this.from_add=from_add;
		this.from_add2=from_add2;
		this.payment=payment;
	}

	public Integer getOrder_number() {
		return order_number;
	}

	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getFrom_add() {
		return from_add;
	}

	public void setFrom_add(String from_add) {
		this.from_add = from_add;
	}

	public String getFrom_add2() {
		return from_add2;
	}

	public void setFrom_add2(String from_add2) {
		this.from_add2 = from_add2;
	}



	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}



}
