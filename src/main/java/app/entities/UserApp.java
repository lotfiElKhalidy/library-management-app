package app.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.Entity;


@Entity

@Table(name="usersapp") 
public class UserApp implements Serializable, UserDetails {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, unique = true)
    private String username;
    
    private String password;
     private String roles;

    public UserApp() {

    }

    public UserApp(String username, String password, String roles) {
      this.username = username;
      this.password = password;
      this.roles=roles;
    }
      
    public boolean isEnabled() { return true; }

    public boolean isCredentialsNonExpired() { return true; }

    public boolean isAccountNonLocked() { return true; }

    public boolean isAccountNonExpired() { return true; }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    public String getRoles() {
        return roles;
    }
 public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection< ? extends GrantedAuthority> getAuthorities() { return null; }

}
