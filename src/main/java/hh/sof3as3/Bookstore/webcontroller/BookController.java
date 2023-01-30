package hh.sof3as3.Bookstore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	
	@GetMapping("/index")
	public String addBook() {
		
		return "bookWelcome";
		
	}

}
