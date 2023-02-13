package hh.sof3as3.Bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	public CategoryRepository crepository;
	
	@GetMapping("/categorylist")
	public String getAll(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	
	}
	
	@GetMapping("/addcategory")
	public String addCategory(Model model){
	 model.addAttribute("category", new Category());
	 return "addcategory";
	}
	
	@PostMapping("/savecategory")
	public String save(Category category){
	 crepository.save(category);
	 return "redirect:categorylist";
	}
	
}
