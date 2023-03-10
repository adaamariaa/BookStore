package hh.sof3as3.Bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class BookController {

	@Autowired
	private BookRepository repository; 
	@Autowired
	public CategoryRepository crepository;
	
	
	@GetMapping("/booklist")
	public String getAll(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";	
	}
	
    @GetMapping(value="/books")
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

    @GetMapping(value="/books/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }      
    
    @PostMapping(value="/books")
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
    	return repository.save(book);
    }
	
	@GetMapping("/add")
	public String addBook(Model model){
	 model.addAttribute("book", new Book());
	 model.addAttribute("categories", crepository.findAll());
	 return "addbook";
	}
	
	@PostMapping("/save")
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model){
		repository.deleteById(bookId);
	 return "redirect:../booklist";
	}

	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
	 return "editbook";
	}
}
