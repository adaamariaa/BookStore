package hh.sof3as3.Bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository; 
	
	@GetMapping("/booklist")
	public String getAll(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookWelcome";
		
	}
	
	@GetMapping("/add")
	public String addBook(Model model){
	 model.addAttribute("student", new Book());
	 return "addstudent";
	}
	
	@PostMapping("/save")
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}

}
