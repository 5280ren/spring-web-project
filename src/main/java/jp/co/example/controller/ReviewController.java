package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dto.ProductDto;
import jp.co.example.dto.ReviewDto;
import jp.co.example.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewservice;

	@RequestMapping(value="/cash",params="reviews", method = RequestMethod.POST)
	public String find(@ModelAttribute("data") ReviewDto reviewdto, Model model) {

		return "review";
	}

	@RequestMapping(value = "/review", params = "a", method = RequestMethod.POST)
	public String index(@Validated @ModelAttribute("data") ReviewDto reviewdto, BindingResult bindingResult,
			Model model) {
	      Integer user_id=reviewdto.getUser_id();
	      Integer review=reviewdto.getReview();
	      String review_data=reviewdto.getReview_data();
	      Integer product_id=reviewdto.getProduct_id();
	      String date=reviewdto.getDate();

	     if(user_id==null||review==null||review_data==null||product_id==null||date==null) {
	    	 return "review";
	     }
	      reviewservice.insert(user_id, review, review_data, product_id, date);
	      model.addAttribute("insert",reviewservice);
		return "review2";
	}

	@RequestMapping(value = "/review", params = "return", method = RequestMethod.POST)
	public String top(@ModelAttribute("data") ReviewDto reviewdto, Model model,@ModelAttribute("product") ProductDto product) {

		return "toppage";
	}
	@RequestMapping("/top")
	public String toppage(@ModelAttribute("data") ReviewDto reviewdto, Model model,@ModelAttribute("product") ProductDto product) {

		return "toppage";
	}

}