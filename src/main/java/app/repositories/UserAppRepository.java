package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<User, Long> {
 
    User findByUsername(String username);
}
