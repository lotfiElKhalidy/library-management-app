package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		List<String> list = Arrays.asList(strings);
		if (list.contains("bookStore")) {
			jdbcTemplate.execute("DROP TABLE MY_BOOKS IF EXISTS");
			jdbcTemplate.execute(
			"CREATE TABLE MY_BOOKS (" +
			"book_id       IDENTITY PRIMARY KEY," +
			"name       VARCHAR(500) NOT NULL," +
			"author       VARCHAR(500) NOT NULL," +
			"price       VARCHAR(500) NOT NULL" +
			");"
			);
			log.info("MY_BOOKS TABLE CREATED");
            jdbcTemplate.execute("DROP TABLE IF EXISTS UserApp");
jdbcTemplate.execute(
    "CREATE TABLE UserApp (" +
    "id            BIGINT AUTO_INCREMENT PRIMARY KEY," +
    "username      VARCHAR(255) NOT NULL UNIQUE," +
    "password      VARCHAR(255) NOT NULL," +
    "roles         VARCHAR(255) NOT NULL" + // Assuming roles are stored as a comma-separated string
    ");"
);
log.info("UserApp TABLE CREATED");
jdbcTemplate.update(
    "INSERT INTO UserApp (username, password, roles) VALUES (?, ?, ?)",
    "user1", "password1", "ROLE_USER"
);

jdbcTemplate.update(
    "INSERT INTO UserApp (username, password, roles) VALUES (?, ?, ?)",
    "user2", "password2", "ROLE_USER"
);

log.info("Users inserted into UserApp table");
			// jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('The age of Adaline', 'Lorde', '22$'); ");
			// jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('Harry Potter', 'J. K. Rowling', '96$'); ");
			// jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('True Story', 'Ari', '596$'); ");
			// jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('The Lucky One', 'T Swizle', '13$'); ");
			log.info("MY_BOOKS TABLE POPULATED");

			jdbcTemplate.execute("DROP TABLE books IF EXISTS");
			jdbcTemplate.execute(
			"CREATE TABLE books (" +
			"book_id       IDENTITY PRIMARY KEY," +
			"name       VARCHAR(500) NOT NULL," +
			"author       VARCHAR(500) NOT NULL," +
			"price       VARCHAR(500) NOT NULL" +
			");"
			);
			log.info("books TABLE CREATED");

			jdbcTemplate.update("INSERT INTO books (name, author, price) values('A Court of Mist and Fury', 'Sarah J. Maas', '11.50€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('La Quinta Montaña', 'Paulo Coelho', '14.57€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Travels of Ibn Fudayl', 'George Richard Sole', '13.34€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Dreams, Dialogues and Desires', 'David McNulty', '4.19€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Great Gatsby', 'F. Scott Fitzgerald', '9.99€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('To Kill a Mockingbird', 'Harper Lee', '8.50€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('1984', 'George Orwell', '10.25€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Catcher in the Rye', 'J.D. Salinger', '7.75€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Pride and Prejudice', 'Jane Austen', '6.99€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('To the Lighthouse', 'Virginia Woolf', '12.30€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Brave New World', 'Aldous Huxley', '11.20€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('One Hundred Years of Solitude', 'Gabriel García Márquez', '13.45€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Hobbit', 'J.R.R. Tolkien', '9.75€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Lord of the Rings', 'J.R.R. Tolkien', '15.99€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Jane Eyre', 'Charlotte Brontë', '8.75€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Wuthering Heights', 'Emily Brontë', '10.50€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Moby-Dick', 'Herman Melville', '11.80€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Crime and Punishment', 'Fyodor Dostoevsky', '9.25€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('Anna Karenina', 'Leo Tolstoy', '12.60€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Picture of Dorian Gray', 'Oscar Wilde', '8.99€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Grapes of Wrath', 'John Steinbeck', '10.75€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Adventures of Huckleberry Finn', 'Mark Twain', '7.95€'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Road', 'Cormac McCarthy', '13.20€'); ");
			log.info("books TABLE POPULATED");
		}

		// List<String> categories;
		// String sql = "select * from categories";
		// categories = jdbcTemplate.query(sql,
        //         (rs, rowNum) ->
        //                 { return new String (rs.getString("name") );
        //                 }
        // );
		// log.info(categories.toString());
		
		// sql = "SELECT * FROM tasks";
		// List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		// for (Map<String, Object> row : rows) {
		//   	log.info(row.get("content").toString());
		//   	log.info(categories.get((Integer)row.get("category")-1));
		// }
		
	}
}