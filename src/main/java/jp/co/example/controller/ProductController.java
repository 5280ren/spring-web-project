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
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.dto.ImagesDto;
import jp.co.example.dto.OrderDto;
import jp.co.example.dto.ProductDto;
import jp.co.example.dto.UserDto;
import jp.co.example.service.ImagesService;
import jp.co.example.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	HttpSession session;

	@Autowired
	private ImagesService imagesservice;


	@RequestMapping("/product")
	public String index(@RequestParam(name = "product_id") String id,
			@ModelAttribute("productall") ProductDto productdto, ImagesDto imagesdto,UserDto userdto,
			Model model) { //list
		Integer product_id = productdto.getProduct_id();
		List<ProductDto> list = productService.findById(product_id);
        List<ImagesDto>li=imagesservice.findById(product_id);
        model.addAttribute("imagesList",li.get(0));
		model.addAttribute("productList", list.get(0));
		session.setAttribute("productList", list.get(0));//管理画面に遷移した際に商品情報を表示
		return "productDetails";

	}

	@RequestMapping(value = "/product", params = "a", method = RequestMethod.POST)
	public String list(@Validated @ModelAttribute("productall") UserDto userdto, BindingResult bindingResult,
			Model model,@ModelAttribute("product") ImagesDto product) {

		return "toppage";
	}

	@RequestMapping(value = "/product", params = "cart", method = RequestMethod.POST)
	public String find(@ModelAttribute("productsave") ProductDto productdto,OrderDto orderdto,ImagesDto imagedto,UserDto userdto, Model model) {
		Integer product_id = productdto.getProduct_id();
		String product_name = productdto.getProduct_name();
		Integer price = productdto.getPrice();
		Integer stock = productdto.getStock();
		String meker = productdto.getMeker();
		String img=imagedto.getImg();

		ArrayList<ProductDto> list = (ArrayList) session.getAttribute("dto");
		if (list == null) {
			 List<ImagesDto>images=new ArrayList<ImagesDto>();
			ArrayList<ProductDto> li = new ArrayList<ProductDto>();
			ImagesDto imgs=new ImagesDto(img);
			ProductDto dto = new ProductDto(product_id, product_name, price, stock, meker);
			li.add(dto);
			images.add(imgs);;
			session.setAttribute("dto", li);
			return "cart";
		} else {
			//ArrayList<ImagesDto> im = (ArrayList) session.getAttribute("imagesList");
			ProductDto dto = new ProductDto(product_id, product_name, price, stock, meker);
			list.add(dto);
			session.setAttribute("dto", list);
			return "cart";
		}
	}

	@RequestMapping(value = "/carts", params = "remove", method = RequestMethod.POST)
	public String remove(@Validated @ModelAttribute("productsave") ProductDto productdto, BindingResult bindingResult,
			Model model,@ModelAttribute("product") ProductDto product) {

		session.removeAttribute("dto");
		return "toppage";
	}

	@RequestMapping(value = "/carts", params = "top", method = RequestMethod.POST)
	public String top(@Validated @ModelAttribute("productsave") ProductDto productdto, BindingResult bindingResult,
			Model model,@ModelAttribute("product") ProductDto product) {

		return "toppage";
	}

	@RequestMapping(value = "/carts", params = "cash", method = RequestMethod.POST)//cashのsession処理を行う
	public String cash(@Validated @ModelAttribute("user") OrderDto orderdto, BindingResult bindingResult,
			Model model) {

		return "cash";
	}


	@RequestMapping(value = "/cash", params = "cart", method = RequestMethod.POST)
	public String cart(@Validated @ModelAttribute("productsave") ProductDto productdto, BindingResult bindingResult,
			Model model) {

		return "cart";
	}
}
