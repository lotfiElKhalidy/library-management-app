package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import app.entities.Book;
import app.entities.MyBookList;
import app.repositories.BookRepository;
import app.repositories.UserRepository;
import app.repositories.MyBookRepository;

import java.util.*;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (isValidUser(username, password)) {
            return "redirect:/";
        } else {
            return "redirect:/login?error=true";
        }
    }

    private boolean isValidUser(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }
}

// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private UserRepository userRepository;

//     @GetMapping("/login")
//     public String showLoginForm() {
//         return "login";
//     }

//     // @PostMapping("/login")
//     // public ResponseEntity<String> login(@RequestBody UserLoginRequest loginRequest) {
        
//     //     String username = loginRequest.getUsername();
//     //     String password = loginRequest.getPassword();

//     //     User user = userRepository.findByUsername(username);
//     //     if (user != null && user.getPassword().equals(password)) {
//     //         // Authentification réussie
//     //         return ResponseEntity.ok("Login successful");
//     //     } else {
//     //         // Authentification échouée
//     //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//     //     }
//     // }
// }