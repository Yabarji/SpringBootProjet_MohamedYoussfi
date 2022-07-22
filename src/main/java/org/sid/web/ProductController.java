package org.sid.web;

import java.util.Optional;

import javax.validation.Valid;

import org.sid.dao.ProductRepository;
import org.sid.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model, 
			@RequestParam(name="page", defaultValue="0")int p, 
			@RequestParam(name="size", defaultValue="10")int s,
			@RequestParam(name="motCle", defaultValue="")String mc) {
		Pageable pageable = PageRequest.of(p, s);
		Page<Product> pageProducts = productRepository.chercher("%"+mc+"%", pageable);
		model.addAttribute("listProducts", pageProducts.getContent());
		int[] pages = new int[pageProducts.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "product";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(Long id, String mc, int page, int size) {
		productRepository.deleteById(id);
		return "redirect:/index?page="+page+"&size="+size+"&mc="+mc;
	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String formProduct(Model model) {
		model.addAttribute("product", new Product());
		return "FormProduct";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(Model model, Long id) {
		Product p = productRepository.findById(id).orElse(null);
        model.addAttribute("product", p);
        return "EditProduct";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model, @Valid  Product product, 
			BindingResult bindingResult ) {
		if(bindingResult.hasErrors())
			return "FormProduct" ;
		productRepository.save(product);
		return "Confirmation";
	}
}