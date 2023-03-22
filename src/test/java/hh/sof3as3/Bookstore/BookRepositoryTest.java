package hh.sof3as3.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByBookTitleReturnYear() {
		List<Book> books = brepository.findByTitle("Harry Potter ja viisasten kivi");
        assertThat(books.get(0).getYear()).isEqualTo(2018);
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Rósa & Björk", "Satu Rämö", 2023, "9789510481271", 28.95, crepository.findByName("Mystery").get(0));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		brepository.delete(brepository.findByTitle("Harry Potter ja viisasten kivi").get(0));
		List<Book> books = brepository.findByTitle("Harry Potter ja viisasten kivi");
		assertThat(books).hasSize(0);
	}

}
