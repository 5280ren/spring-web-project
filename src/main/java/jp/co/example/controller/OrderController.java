package jp.co.example.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dto.ImagesDto;
import jp.co.example.dto.OrderDto;
import jp.co.example.dto.ProductDto;
import jp.co.example.dto.UserDto;
import jp.co.example.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderservice;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/order", params = "b", method = RequestMethod.POST) //購入をキャンセルした時の処理
	public String toppage(@ModelAttribute("user") OrderDto orderdto,@ModelAttribute("product")ProductDto productdto, Model model) {
		return "toppage";
	}

	@RequestMapping(value = "/order", params = "a", method = RequestMethod.POST)//購入を確定した時の処理
	public String insert(@ModelAttribute("user") OrderDto orderdto, Model model) {
		String order_date = orderdto.getOrder_date();
		Integer product_id = orderdto.getProduct_id();
		Integer user_id = orderdto.getUser_id();
		String postcode = orderdto.getPostcode();
		String from_add = orderdto.getFrom_add();
		String from_add2 = orderdto.getFrom_add2();

		Integer payment = orderdto.getPayment();
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		order_date = time.format(java8Format);
		OrderDto dto = new OrderDto(order_date, product_id, user_id, postcode, from_add, from_add2, payment);

		if (payment == 1) {
			orderservice.insert(order_date, product_id, user_id, postcode, from_add, from_add2, payment);
			model.addAttribute("order", orderservice);
			session.setAttribute("order", dto);
			session.removeAttribute("dto");
			return "cash02";
		} else if (payment == 2) {
			orderservice.insert(order_date, product_id, user_id, postcode, from_add, from_add2,  payment);
			model.addAttribute("order", orderservice);
			session.setAttribute("order", dto);
			session.removeAttribute("dto");
			return "cash02";
		} else

			return "cash";
	}

	@RequestMapping(value = "/cash", params = "top", method = RequestMethod.POST)//トップに戻る押した時
	public String toppage(@ModelAttribute("user") UserDto userdto,@ModelAttribute("product")ProductDto productdto,OrderDto orderdto,ImagesDto imagesdto,BindingResult bindingResult) {
		return "toppage";
	}


}
