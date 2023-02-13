package hh.sof3as3.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	List <Book> findByTitle(String title);
	List <Book> findByAuthor(String author);
	List <Book> findById(long id);
	List <Book> findByYear(int year);


}
