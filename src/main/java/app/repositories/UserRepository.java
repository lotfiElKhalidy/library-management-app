package app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import app.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>  {

}