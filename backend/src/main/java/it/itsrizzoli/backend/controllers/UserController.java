package it.itsrizzoli.backend.controllers;
import it.itsrizzoli.backend.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping(value="/login")
    public String ShowLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("/login")
    public String SubmitLogin(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        String email = user.getEmail().trim();    //.trim() restituisce la stringa togliendo gli spazi sia all'inizio che fine
        String password = user.getPassword().trim();
        boolean stato = true;

        //al posto dei controlli sottostanti, fare query al DB per verificare credenziali

        /* \\p{L} consente tutte le lettere anche accentate
           \\s    consente gli spazi
         */
        if(email.isEmpty() || !email.matches("[\\p{L}\\s]+")) {
            model.addAttribute("errorEmail", "Email inserita non valida");
            stato = false;
        }
        if(password.isEmpty() || !password.matches("[\\p{L}\\s]+")) {
            model.addAttribute("errorPassword", "Password errata");
            stato = false;
        }
        if(!stato) {
            return "login";
        }

        return "homePage";
    }
}
