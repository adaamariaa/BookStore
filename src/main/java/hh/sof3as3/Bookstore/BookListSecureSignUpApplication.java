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
import hh.sof3as3.Bookstore.domain.User;
import hh.sof3as3.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookListSecureSignUpApplication {

		private static final Logger log = LoggerFactory.getLogger(BookListSecureSignUpApplication.class);

		public static void main(String[] args) {
			SpringApplication.run(BookListSecureSignUpApplication.class, args);
		}
		
		
		@Bean
		public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
			return (args) -> {
				log.info("save a couple of books");
				crepository.save(new Category("Fantasy"));
				crepository.save(new Category("Nonfiction"));
				crepository.save(new Category("Mystery"));
				
				brepository.save( new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 2018, "9789520401801", 24.95, crepository.findByName("Fantasy").get(0)));
				brepository.save(new Book("Harry Potter ja salaisuuksien kammio", "J.K. Rowling", 2021, "9789520433543", 32.95, crepository.findByName("Fantasy").get(0)));
				brepository.save(new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 2020, "9789520426415", 24.95, crepository.findByName("Fantasy").get(0)));	
				
				// Create users: admin/admin user/user
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
				
				log.info("fetch all books");
				for (Book book : brepository.findAll()) {
					log.info(book.toString());
				}

			};
		}

	}
