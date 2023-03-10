package hh.sof3as3.Bookstore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long categoryid;
	public String name;
	
	@JsonIgnoreProperties("category")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List <Book> books;

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "categoryid=" + categoryid + ", name=" + name + "]";
	}
	
	
	
	
	
}
