package app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="MY_BOOKS")
public class MyBookList {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="book_id")
	private int id;

	private String name;
	
    private String author;
	
    private String price;
	
    public MyBookList() {
		super();
	}

	public MyBookList(int id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	@Override
    public String toString() {
        return String.format("MyBookList[id=%d, name='%s', author='%s', price='%s']", id, name, author, price);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}