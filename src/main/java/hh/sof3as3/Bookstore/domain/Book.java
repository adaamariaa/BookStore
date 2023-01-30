package hh.sof3as3.Bookstore.domain;

public class Book {
	 public String title;
	 public String author;
	 public Integer year;
	 public String isbn;
	 public double price;
	 
	public Book(String title, String author, Integer year, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.year = null;
		this.isbn = null;
		this.price = 0.00;
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

	@Override
	public String toString() {
		return "title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price;
	}
	
	
	
	 
}
