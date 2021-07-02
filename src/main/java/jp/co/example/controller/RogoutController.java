package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dto.ImagesDto;
import jp.co.example.dto.ProductDto;
import jp.co.example.dto.UserDto;
@Controller
public class RogoutController {

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/cash", params = "rogout", method = RequestMethod.POST)
	public String rogout(@ModelAttribute("user") UserDto userdto,@ModelAttribute("product")ProductDto product,@ModelAttribute("images")ImagesDto images, Model model) {

		session.removeAttribute("dto");
		session.removeAttribute("userList");
		return "register03";
	}

}
