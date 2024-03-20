package app.entities;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;


@Entity

@Table(name="usersapp") 
public class UserApp implements Serializable, UserDetails {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, unique = true)
    private String username;
    
    private String password;

    public UserApp() {

    }

    public UserApp(String username, String password) {
      this.username = username;
      this.password = password;
    }
      
    public boolean isEnabled() { return true; }

    public boolean isCredentialsNonExpired() { return true; }

    public boolean isAccountNonLocked() { return true; }

    public boolean isAccountNonExpired() { return true; }

    public Collection< ? extends GrantedAuthority> getAuthorities() { return null; }

}
