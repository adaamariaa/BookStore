package hh.sof3as3.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {return (args) -> {

		Book b1 = new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 2018, "9789520401801", 24.95);
		Book b2 = new Book("Harry Potter ja salaisuuksien kammio", "J.K. Rowling", 2021, "9789520433543", 32.95);
		Book b3 = new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 2020, "9789520426415", 24.95);
		
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
		};
	}
	
}
