package hh.sof3as3.Bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryController {

	@Autowired
	public CategoryRepository crepository;
	
	@GetMapping("/categorylist")
	public String getAll(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	 @GetMapping(value="/categories")
	    public @ResponseBody List<Category> categoryListRest() {	
	        return (List<Category>) crepository.findAll();
	    }    

	    @GetMapping(value="/categories/{id}")
	    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {	
	    	return crepository.findById(categoryId);
	    }      
	    
	    @PostMapping(value="/categories")
	    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {	
	    	return crepository.save(category);
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
