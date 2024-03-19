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
		if (list.contains("install")) {
			// le code de création de la base
			// voir ci-dessous
			jdbcTemplate.execute("DROP TABLE categories IF EXISTS");
			jdbcTemplate.execute(
			"CREATE TABLE categories ("+
			"category_id IDENTITY PRIMARY KEY," +
			"name VARCHAR(20) DEFAULT '' "+
			");"
			);
			log.info("categories TABLE CREATED");

			jdbcTemplate.update("INSERT INTO categories(name) values('todo'); ");
			jdbcTemplate.update("INSERT INTO categories(name) values('wip');  ");
			jdbcTemplate.update("INSERT INTO categories(name) values('done'); ");
			log.info("categories TABLE POPULATED");

			jdbcTemplate.execute("DROP TABLE tasks IF EXISTS");
			jdbcTemplate.execute(
			"CREATE TABLE tasks (" +
			"task_id       IDENTITY PRIMARY KEY," +
			"category      INTEGER NOT NULL," +
			"content       VARCHAR(500) NOT NULL," +
			"creation_date DATE DEFAULT CURRENT_DATE(), " +
			"end_date      DATE DEFAULT NULL, " +
			"FOREIGN KEY(category) REFERENCES categories(category_id)"+
			");"
			);
			log.info("tasks TABLE CREATED");

			jdbcTemplate.update("INSERT INTO tasks (category, content) values(3, 'finir le tp 1'); ");
			jdbcTemplate.update("INSERT INTO tasks (category, content) values(2, 'finir le tp 2'); ");
			jdbcTemplate.update("INSERT INTO tasks (category, content) values(1, 'finir le tp 3'); ");
			jdbcTemplate.update("INSERT INTO tasks (category, content) values(1, 'finir le tp 3'); ");
			log.info("tasks TABLE POPULATED");
		}
		else if (list.contains("bookStore")) {
			// jdbcTemplate.execute("DROP TABLE books IF EXISTS");
			// jdbcTemplate.execute(
			// "CREATE TABLE books ("+
			// "category_id IDENTITY PRIMARY KEY," +
			// "name VARCHAR(20) DEFAULT '' "+
			// ");"
			// );
			// log.info("categories TABLE CREATED");

			// jdbcTemplate.update("INSERT INTO categories(name) values('todo'); ");
			// jdbcTemplate.update("INSERT INTO categories(name) values('wip');  ");
			// jdbcTemplate.update("INSERT INTO categories(name) values('done'); ");
			// log.info("categories TABLE POPULATED");

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

			jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('The age of Adaline', 'Lorde', '22$'); ");
			jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('Harry Potter', 'J. K. Rowling', '96$'); ");
			jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('True Story', 'Ari', '596$'); ");
			jdbcTemplate.update("INSERT INTO MY_BOOKS (name, author, price) values('The Lucky One', 'T Swizle', '13$'); ");
			log.info("MY_BOOKS TABLE POPULATED");

			// jdbcTemplate.execute("DROP TABLE books IF EXISTS");
			// jdbcTemplate.execute(
			// "CREATE TABLE books (" +
			// "book_id       IDENTITY PRIMARY KEY," +
			// "name       VARCHAR(500) NOT NULL," +
			// "author       VARCHAR(500) NOT NULL," +
			// "price       VARCHAR(500) NOT NULL" +
			// ");"
			// );
			// log.info("books TABLE CREATED");

			// jdbcTemplate.update("INSERT INTO books (name, author, price) values('The age of Adaline', 'Lorde', '22$'); ");
			// jdbcTemplate.update("INSERT INTO books (name, author, price) values('Harry Potter', 'J. K. Rowling', '96$'); ");
			// jdbcTemplate.update("INSERT INTO books (name, author, price) values('True Story', 'Ari', '596$'); ");
			// jdbcTemplate.update("INSERT INTO books (name, author, price) values('The Lucky One', 'T Swizle', '13$'); ");
			// log.info("books TABLE POPULATED");
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