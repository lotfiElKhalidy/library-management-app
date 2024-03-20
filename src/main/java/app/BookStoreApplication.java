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
			"price       VARCHAR(500) NOT NULL," +
			"synopsis       VARCHAR(2000) NOT NULL" +
			");"
			);
			log.info("MY_BOOKS TABLE CREATED");

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
			"price       VARCHAR(500) NOT NULL," +
			"synopsis       VARCHAR(2000) NOT NULL" +
			");"
			);
			log.info("books TABLE CREATED");

			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values ('A Court of Mist and Fury', 'Sarah J. Maas', '11.50€', 'Après avoir survécu à des épreuves dévastatrices Feyre entreprend un voyage pour découvrir sa véritable destinée dans un monde de magie et de danger');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('La Quinta Montaña', 'Paulo Coelho', '14.57€', 'Dans cette histoire captivante un homme lutte pour trouver la paix intérieure alors qu il affronte les défis de la vie sur une montagne isolée');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Travels of Ibn Fudayl', 'George Richard Sole', '13.34€', 'Ibn Fudayl entreprend un voyage épique à travers des terres lointaines découvrant des trésors cachés et des secrets perdus depuis longtemps');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Dreams, Dialogues and Desires', 'David McNulty', '4.19€', 'Un recueil de réflexions profondes sur la nature de nos rêves nos conversations et nos désirs les plus profonds');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Great Gatsby', 'F. Scott Fitzgerald', '9.99€', 'Dans les années folles de New York Jay Gatsby poursuit son rêve américain tout en luttant avec les conséquences tragiques de son obsession pour Daisy Buchanan');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('To Kill a Mockingbird', 'Harper Lee', '8.50€', 'Dans une ville du sud des États-Unis Atticus Finch avocat et père défend un homme noir accusé à tort de viol');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('1984', 'George Orwell', '10.25€', 'Dans un monde dystopique totalitaire Winston Smith tente de résister à la surveillance constante du Parti et de trouver l amour et la liberté');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Catcher in the Rye', 'J.D. Salinger', '7.75€', 'Holden Caulfield un adolescent désillusionné traverse New York en cherchant à échapper à la superficialité du monde adulte.');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Pride and Prejudice', 'Jane Austen', '6.99€', 'Dans l Angleterre du début du XIXe siècle Elizabeth Bennet et Mr. Darcy naviguent à travers les conventions sociales pour trouver l amour');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('To the Lighthouse', 'Virginia Woolf', '12.30€', 'Dans une maison au bord de la mer la famille Ramsay et leurs invités explorent les complexités de la vie et de l amour');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Brave New World', 'Aldous Huxley', '11.20€', 'Dans une société futuriste où la reproduction est contrôlée et les émotions sont étouffées un homme remet en question les fondements de son monde');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('One Hundred Years of Solitude', 'Gabriel García Márquez', '13.45€', 'La saga épique de la famille Buendía marquée par l isolement l amour la magie et la tragédie dans une ville imaginaire de la jungle colombienne');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Hobbit', 'J.R.R. Tolkien', '9.75€', 'Bilbo Baggins un hobbit paisible est entraîné dans une aventure épique pour récupérer un trésor gardé par un dragon redoutable');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Lord of the Rings', 'J.R.R. Tolkien', '15.99€', 'Frodo Baggins entreprend un voyage périlleux pour détruire un anneau magique et sauver la Terre du Milieu de l obscurité');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Jane Eyre', 'Charlotte Brontë', '8.75€', 'Une histoire intemporelle d amour et de résilience Jane Eyre trouve le courage de défier les conventions sociales pour suivre son propre chemin');");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Wuthering Heights', 'Emily Brontë', '10.50€', 'Dans cette histoire tourmentée de passion et de vengeance les amants Heathcliff et Catherine se déchirent dans les landes sauvages de l Angleterre'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Moby-Dick', 'Herman Melville', '11.80€', 'Le capitaine Ahab poursuit obstinément sa quête de vengeance contre la baleine blanche Moby Dick à travers les vastes océans du monde'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Crime and Punishment', 'Fyodor Dostoevsky', '9.25€', 'Dans les rues sombres de Saint-Pétersbourg Raskolnikov lutte avec sa conscience après avoir commis un meurtre brutal'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('Anna Karenina', 'Leo Tolstoy', '12.60€', 'Dans la haute société russe Anna Karenina sacrifie tout pour une passion interdite qui la conduit vers sa propre destruction'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Picture of Dorian Gray', 'Oscar Wilde', '8.99€', 'Dorian Gray échange son âme pour la jeunesse éternelle mais découvre que chaque péché laisse une marque indélébile sur son portrait caché'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Grapes of Wrath', 'John Steinbeck', '10.75€', 'Dans l Amérique de la Grande Dépression la famille Joad lutte pour trouver espoir et dignité alors qu elle migre vers la Californie en quête d une vie meilleure'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Adventures of Huckleberry Finn', 'Mark Twain', '7.95€', 'Le jeune Huck Finn s échappe avec l esclave Jim sur un radeau à travers le fleuve Mississippi découvrant l amitié la liberté et les contradictions de la société'); ");
			jdbcTemplate.update("INSERT INTO books (name, author, price, synopsis) values('The Road', 'Cormac McCarthy', '13.20€', 'Dans un monde post-apocalyptique stérile et désolé un père et son fils entreprennent un voyage désespéré pour survivre et trouver un semblant d espoir'); ");

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