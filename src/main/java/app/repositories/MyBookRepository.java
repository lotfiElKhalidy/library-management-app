package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
import app.entities.MyBookList;

public interface MyBookRepository extends CrudRepository<MyBookList,Integer>{

}