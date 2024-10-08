package it.itsrizzoli.backend.controllers;
import it.itsrizzoli.backend.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @PostMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "index";
    }
}
