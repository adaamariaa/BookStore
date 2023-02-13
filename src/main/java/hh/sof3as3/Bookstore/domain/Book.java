package hh.sof3as3.Bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long id;
		public String title;
		public String author;
		@Column(name="publyear")
		public Integer year;
		public String isbn;
		public double price;
	 
		@ManyToOne
	    @JoinColumn(name = "categoryid")
	    public Category category;
		
	public Book(String title, String author, Integer year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book() {
		
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if(this.category != null)
			return "id=" + id + "title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + " category =" + this.getCategory();
		
		else
			return "id=" + id + "title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price;
			
	}
	
	
	
	 
}
