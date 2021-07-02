package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dto.ImagesDto;
import jp.co.example.service.ImagesService;
import jp.co.example.service.ProductService;
@Controller
public class CategoryController {
	@Autowired
	ImagesService imageservice;

	@Autowired
	ProductService productservice;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/category",  method = RequestMethod.POST)//トップページからradiobutton押下時
	public String oklok(@ModelAttribute("product") ImagesDto categorydto,Model model) {
		Integer category_id=categorydto.getCategory_id();
		if(category_id==null||category_id==0) {
			return"toppage";
		}
		List<ImagesDto>list=new ArrayList<ImagesDto>();
        list=imageservice.category_id(category_id);
        model.addAttribute("imagelist",list);
        session.setAttribute("imagelist", list);
		return "toppage";
	}

}
