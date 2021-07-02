package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dto.OrderDto;
import jp.co.example.dto.ProductDto;
import jp.co.example.dto.UserDto;
import jp.co.example.service.ProductService;

@Controller
public class OrderHistoryController {
	@Autowired
	ProductService productservice;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/cash", params = "historys", method = RequestMethod.POST)//トップページから注文履歴ボタン押した時
	public String history(@ModelAttribute("user") ProductDto productdto,Model model) {
		List<UserDto> li=(List<UserDto>)session.getAttribute("userList");//userDto
	    List<ProductDto>list;
		list=productservice.joinpath(li.get(0).getUser_id());
        model.addAttribute("productList",list);
        session.setAttribute("productList",list);
		return "history";
	}

	@RequestMapping(value="/orderhistory",params="ab",method = RequestMethod.POST)
	public String orderhistory(@ModelAttribute("user") OrderDto orderdto,@ModelAttribute("product") ProductDto product) {
		return"toppage";
	}
}
