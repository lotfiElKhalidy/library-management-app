package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import app.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>  {

}