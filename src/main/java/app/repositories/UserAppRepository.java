package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entities.UserApp;
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
 
    UserApp findByUsername(String username);
}
