package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dto.ImagesDto;
import jp.co.example.dto.ProductDto;
import jp.co.example.dto.UserDto;
import jp.co.example.service.ImagesService;
import jp.co.example.service.ProductService;
import jp.co.example.service.UserService;

@Controller
public class ManagerContoroller {
	@Autowired
	private UserService userservice;
	@Autowired
	private HttpSession session;
	@Autowired
	private ImagesService imagesservice;
	@Autowired
	private ProductService productservice;

	@RequestMapping(value = "/cash", params = "manager", method = RequestMethod.POST) //トップ画面から管理画面を押した時
	public String manager(@ModelAttribute("user") UserDto userdto, Model model,
			@ModelAttribute("product") ProductDto product, @ModelAttribute("images") ImagesDto images) {
		return "manager";
	}

	@RequestMapping(value = "/manager", params = "insert", method = RequestMethod.POST) //登録を押した時
	public String insert(@ModelAttribute("user") UserDto userdto, @ModelAttribute("product") ProductDto product,
			@ModelAttribute("images") ImagesDto images, Model model, BindingResult bindingResult) {
		Integer product_id = product.getProduct_id();
		String img = images.getImg();
		String product_name = product.getProduct_name();
		Integer price = product.getPrice();
		Integer stock = product.getStock();
		String meker = product.getMeker();
		Integer category_id = product.getCategory_id();
		//Integer productid = images.getProduct_id();

		if (product_id == null || img == null || img.equals("") || product_name == null || product_name.equals("")
				|| price == null || stock == null || category_id == null||meker==null||meker.equals("")) {//formが未入力の場合
			return "manager";
		}

		List<ImagesDto> list = imagesservice.findById(product_id);

		if (list.size() == 1) {//商品idがDbにあった時は更新
			productservice.update(product_id, product_name, price, stock, meker, category_id);
			model.addAttribute("productservice", productservice);
			imagesservice.update(product_id, img);
			model.addAttribute("imginsert", imagesservice);
			return "manager02";
		} else {//商品idがDBになかったときは登録
			productservice.insert(product_id, product_name, price, stock, meker, category_id);
			model.addAttribute("productinsert", productservice);
			imagesservice.insert(product_id, img);
			model.addAttribute("imageinsert", imagesservice);
			return "manager02";
		}
	}

	@RequestMapping(value = "/manager", params = "delete", method = RequestMethod.POST) //トップに戻る押したとき
	public String delete(@ModelAttribute("user") UserDto userdto, @ModelAttribute("product") ProductDto product,
			@ModelAttribute("images") ImagesDto images) {
		Integer product_id = product.getProduct_id();
		String img = images.getImg();
		String product_name = product.getProduct_name();
		Integer price = product.getPrice();
		Integer stock = product.getStock();
		String meker = product.getMeker();
		Integer category_id = product.getCategory_id();
		Integer productid = images.getProduct_id();

		if (product_id == null || img == null || img.equals("") || product_name == null || product_name.equals("")
				|| price == null || stock == null || category_id == null||meker==null||meker.equals("")) {//formが未入力の場合
			return "manager";
		}
		List<ImagesDto> list = imagesservice.findById(product_id);
		if (list.size() == 1) {//商品idがdbにあった場合画像と商品情報削除
			imagesservice.delete(productid);
			productservice.delete(product_id);
			return "manager02";
		} else {//なかった場合は再表示
			return "manager";
		}
	}

	@RequestMapping(value = "/manager", params = "ab", method = RequestMethod.POST) //トップに戻る押したとき
	public String toppage(@ModelAttribute("user") UserDto userdto, @ModelAttribute("product") ProductDto product,
			@ModelAttribute("images") ImagesDto images) {
		return "toppage";
	}

	@RequestMapping(value = "/manager", params = "manager", method = RequestMethod.POST) //新たな管理人の追加を押した時
	public String managerinsert(@ModelAttribute("user") UserDto userdto, @ModelAttribute("product") ProductDto product,
			@ModelAttribute("images") ImagesDto images,Model model) {
		Integer user_id=userdto.getUser_id();
		//Integer manager=userdto.getManager();
		UserDto dto = new UserDto(user_id);
		List<UserDto> li = new ArrayList<UserDto>();
		li.add(dto);
		li=userservice.findall();
        model.addAttribute("userservice", li);
        session.setAttribute("userservice", li);
		return "managerinsert";
	}

	@RequestMapping(value = "/managerinsert",method = RequestMethod.POST) //新たな管理人の追加を押した時
	public String managerupdate(@ModelAttribute("user") UserDto userdto, @ModelAttribute("product") ProductDto product,
			@ModelAttribute("images") ImagesDto images) {
        Integer user_id=userdto.getUser_id();
        Integer manager=userdto.getManager();

        if(manager==null) {
        	return"managerinsert";
        }
        userservice.updatemanager(user_id, manager);


		return "manager02";
	}

	@RequestMapping(value = "/managerinsert", params = "delete", method = RequestMethod.POST) //登録完了画面からトップに戻る押したとき
	public String returnpage(@ModelAttribute("user") UserDto userdto, @ModelAttribute("product") ProductDto product,
			@ModelAttribute("images") ImagesDto images) {
		return "toppage";
	}

	@RequestMapping(value = "/top", params = "top", method = RequestMethod.POST) //登録完了画面からトップに戻る押したとき
	public String top(@ModelAttribute("user") UserDto userdto, @ModelAttribute("product") ProductDto product,
			@ModelAttribute("images") ImagesDto images) {
		return "toppage";
	}
}
