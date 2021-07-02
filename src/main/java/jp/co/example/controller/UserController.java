package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dto.ImagesDto;
import jp.co.example.dto.ProductDto;
import jp.co.example.dto.UserDto;
import jp.co.example.service.ImagesService;
import jp.co.example.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private HttpSession session;

	@Autowired
	private ImagesService imageservice;

	@RequestMapping("/register")
	public String find(@ModelAttribute("user") UserDto userdto, Model model) {

		return "register";
	}

	@RequestMapping(value = "/register", params = "in", method = RequestMethod.POST)
	public String index(@Validated @ModelAttribute("user") UserDto userdto, BindingResult bindingResult, Model model) {
		Integer user_id = userdto.getUser_id();
		String nickname = userdto.getNickname();
		String pass_word = userdto.getPass_word();
		String from_add = userdto.getFrom_add();
		String from_add2 = userdto.getFrom_add2();
		String tel_no = userdto.getTel_no();
		String post_code = userdto.getPost_code();

		if (bindingResult.hasErrors()) {
			return "register";
		} else {
			session.setAttribute("user_id", user_id);
			session.setAttribute("nickname", nickname);
			session.setAttribute("pass_word", pass_word);
			session.setAttribute("from_add", from_add);
			session.setAttribute("from_add2", from_add2);
			session.setAttribute("tel_no", tel_no);
			session.setAttribute("post_code", post_code);
			return "register02";
		}
	}

	@RequestMapping(value = "/register", params = "login", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute("user") UserDto userdto, BindingResult bindingResult, Model model) {

		return "register03";
	}

	@RequestMapping(value = "/register02", params = "insert", method = RequestMethod.POST)
	public String insert(@Validated @ModelAttribute("user") UserDto userdto, BindingResult bindingResult,
			Model model) {
		Integer user_id = userdto.getUser_id();
		String nickname = userdto.getNickname();
		String pass_word = userdto.getPass_word();
		String from_add = userdto.getFrom_add();
		String from_add2 = userdto.getFrom_add2();
		String tel_no = userdto.getTel_no();
		String post_code = userdto.getPost_code();
		userservice.insert(user_id, nickname, pass_word, from_add, from_add2, tel_no, post_code);
		model.addAttribute("userinsert", userservice);
		session.setAttribute("userinsert", userservice);
		return "register03";
	}

	@RequestMapping(value = "/register02", params = "reset", method = RequestMethod.POST)
	public String list(@Validated @ModelAttribute("user") UserDto userdto, BindingResult bindingResult,
			Model model) {

		return "register";
	}

	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String findidpath(@Validated @ModelAttribute("user") UserDto userdto, BindingResult bindingResult,
			Model model,@ModelAttribute("product")ProductDto product,@ModelAttribute("images")ImagesDto images) {
		Integer user_id = userdto.getUser_id();
		String nickname = userdto.getNickname();
		String pass_word = userdto.getPass_word();
		String from_add = userdto.getFrom_add();
		String from_add2 = userdto.getFrom_add2();
		String tel_no = userdto.getTel_no();
		String post_code = userdto.getPost_code();
		Integer product_id=images.getProduct_id();
		String img=images.getImg();
		Integer category_id=product.getCategory_id();
		Integer manager=userdto.getManager();
		List<UserDto> list = userservice.find(user_id, pass_word);

		if (user_id == null || pass_word == null || pass_word.equals("")) {
			return "register03";
		}

		if (list.size()==1) {
			UserDto dto = new UserDto(user_id, nickname, pass_word, from_add, from_add2, tel_no, post_code,manager);
			List<UserDto> li = new ArrayList<UserDto>();
			li.add(dto);
			li=userservice.findwhere(user_id);
			model.addAttribute("userList",li );
			session.setAttribute("userList",li);
			ImagesDto imagesdto=new ImagesDto(product_id,img);
			List<ImagesDto>imagelist=new ArrayList<ImagesDto>();
			imagelist.add(imagesdto);
			imagelist=imageservice.findall();
			model.addAttribute("imagelist",imagelist);
			ProductDto productlist=new ProductDto(category_id);
			model.addAttribute("productList",productlist);//トップページから管理に遷移する際の値の紐づけ
			return "toppage";
		}else {
		return "register03";
		}
	}

	@RequestMapping(value = "/cash", params = "update", method = RequestMethod.POST)//トップページからユーザー情報変更ボタン押した場合
	public String update(@ModelAttribute("user") UserDto orderdto,Model model) {

		return "update";
	}



	@RequestMapping(value = "/update", params = "update", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute("user") UserDto userdto, BindingResult bindingResult,
			Model model) {
		Integer user_id = userdto.getUser_id();
		String nickname = userdto.getNickname();
		//String name = userdto.getNickname();
		String pass_word = userdto.getPass_word();
		//String pass = userdto.getPass_word();
		if (user_id==null||user_id == 0 || nickname == null || nickname.equals("") ||nickname.equals(",")|| pass_word == null || pass_word.equals("")||pass_word.equals(",")) {
			return "update";
		} else {
			userservice.update(user_id, pass_word, nickname);
			model.addAttribute("update", userservice);
			return "register03";
		}
	}
	@RequestMapping(value = "/update", params = "return", method = RequestMethod.POST)//ユーザー情報変更ボタンからトップに戻る押した場合
	public String top(@ModelAttribute("user") UserDto orderdto,Model model,@ModelAttribute("product")ProductDto product) {

		return "toppage";
	}
}