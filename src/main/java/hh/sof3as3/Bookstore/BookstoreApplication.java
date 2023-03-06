package hh.sof3as3.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	///@Bean
	//public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {return (args) -> {
		
	//crepository.save(new Category("Fantasy"));
	//crepository.save(new Category("Nonfiction"));
	//crepository.save(new Category("Mystery"));
		
		
	//for (Category category : crepository.findAll()) {
	//log.info(category.toString());
	//}
		
	//repository.save( new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 2018, "9789520401801", 24.95, crepository.findByName("Fantasy").get(0)));
	//repository.save(new Book("Harry Potter ja salaisuuksien kammio", "J.K. Rowling", 2021, "9789520433543", 32.95, crepository.findByName("Fantasy").get(0)));
	//repository.save(new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 2020, "9789520426415", 24.95, crepository.findByName("Fantasy").get(0)));
		
		
		
	//for (Book book : repository.findAll()) {
	//log.info(book.toString());
	//}
	//};
	//}
	
}
